package set;
import setimplementations.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Set {

    int counter = 0; //counter is used to count multiples of 100, in order to account for data sampling

    public void setCounter(int counter) {
        this.counter = counter;
    }

    int tokenizeFlag = 0; //0 represents add and 1 represents search, used in tokenize method
    //using this flag to avoid writing tokenize subroutine multiple times

    //inserting data(words_present vs time) into csv
    public void insert(SetInterface set,String ds){
        File file = new File("src/inputfiles/pride-and-prejudice.txt");
        String identifier = getIdentifier(set);
        tokenizeFlag = 0; //setting it to 0 denotes add operation
        int setSize = tokenize(set,file,tokenizeFlag,ds);
        System.out.println("The total number of words exist in "+identifier+" is: "+setSize);
    }

    //searching data in the sets and inserting into csv(words,time to search)
    public void searchWords(SetInterface set,String ds){
        String identifier = getIdentifier(set);
        File file = new File("src/inputfiles/words-shuffled.txt");
        tokenizeFlag = 1; //1 denotes search operation on the set
        int count = tokenize(set,file,tokenizeFlag,ds);
        System.out.println("The number of words that don't exist in "+identifier+" is: "+count);
    }

    //method that tokenizes the strings from a file and performs actual add operations and search
    private int tokenize(SetInterface set,File file, int tokenizeFlag,String ds){
        int count = 0; //for counting the number of words not present in the set
        FileWriter fileWriter = null;
        String fileHeader = null;
        if(tokenizeFlag == 0){
            fileHeader = "words_present,time_to_insert";
            try {
                fileWriter = new FileWriter("src/csvFiles/adding/"+ds+".csv",true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(tokenizeFlag == 1){
            fileHeader = "word,time_to_search";
            try {
                fileWriter = new FileWriter("src/csvFiles/searching/"+ds+".csv",true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split("[^a-zA-Z0-9]+");
                for (String token : tokens) {
                    if(tokenizeFlag == 0){
                        if(!token.equals("")) {
                            if(counter%100 == 0) {
                                Integer x = set.size();//no of words already inserted
                                long startTime = System.nanoTime();
                                set.add(token); //perform adding elements
                                long estimatedTime = System.nanoTime() - startTime;
                                Long y = estimatedTime; //number of nanoseconds it took to insert this particular token
                                fileWriter(fileWriter, x.toString(), y.toString());

                            }
                            else{
                                set.add(token);
                            }
                            counter++;
                        }
                    }
                    else if(tokenizeFlag == 1){
                        if(!token.equals("")){
                            if(counter%100 == 0) {
                                Long startTime = System.nanoTime();
                                if (set.contains(token) == false) {
                                    count++;
                                }
                                Long estimatedTime = System.nanoTime() - startTime;
                                fileWriter(fileWriter, token, estimatedTime.toString());
                            }
                            else{
                                if(set.contains(token) == false){
                                    count++;
                                }
                            }
                            counter++;
                        }
                    }
                }
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file specified, check the path");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Couldn't create the csv file for writing");
            e.printStackTrace();
        }
        if(tokenizeFlag == 0)
            return set.size();
        else
            return count;
    }

    //file writer method to append to csv files
    private void fileWriter(FileWriter file,String x, String y){
        try {
            file.append(x);
            file.append(",");
            file.append(y);
            file.append("\n");
        } catch (IOException e) {
            System.out.println("Could not append to the file");
            e.printStackTrace();
        }

    }

    //method used to return the set type, used for formatting file names
    private String getIdentifier(SetInterface set){
        String identifier;
        if(set.getClass().getName().equals("setimplementations.SetList")){
            identifier = "LinkedList Set";
        }
        else if(set.getClass().getName().equals("setimplementations.SetTree")){
            identifier = "Tree Set";
        }
        else{
            identifier = "HashTable Set";
        }
        return identifier;
    }

    //main method
    public static void main(String[] args) {

        Set set = new Set();
        SetList setList = new SetList();
        SetTree setTree = new SetTree();
        SetHashTable setHashTable = new SetHashTable();
        set.setCounter(0);
        for(int i = 1; i <= 10; i++) {
            setList = new SetList();
            set.insert(setList,"list");
        }
        set.setCounter(0);
        for(int i = 1; i <= 10; i++) {
            setTree = new SetTree();
            set.insert(setTree,"tree");
        }
        set.setCounter(0);
        for(int i = 1; i <= 10; i++){
            setHashTable = new SetHashTable();
            set.insert(setHashTable,"hashTable");
        }
        //
        set.setCounter(0);
        for(int i = 1; i <= 10; i++) {
            set.searchWords(setList,"searchList");
        }
        set.setCounter(0);
        for(int i = 1; i <= 10; i++) {
            set.searchWords(setTree,"searchTree");
        }
        set.setCounter(0);
        for(int i = 1; i <= 10; i++){
            set.searchWords(setHashTable,"searchHashTable");
        }
    }
}
