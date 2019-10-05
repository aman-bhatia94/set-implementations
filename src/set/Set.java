package set;
import setimplementations.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Set {

    int tokenizeFlag = 0; //0 represents add and 1 represents search

    public void insert(SetInterface set,String ds){
        File file = new File("src/set/pride-and-prejudice.txt");
        String identifier = getIdentifier(set);
        tokenizeFlag = 0; //setting it to 0 denotes add operation
        int setSize = tokenize(set,file,tokenizeFlag,ds);
        System.out.println("The total number of words exist in "+identifier+" is: "+setSize);
    }

    public void searchWords(SetInterface set,String ds){
        String identifier = getIdentifier(set);
        File file = new File("src/set/words-shuffled.txt");
        tokenizeFlag = 1; //1 denotes search operation on the set
        int count = tokenize(set,file,tokenizeFlag,ds);
        System.out.println("The number of words that don't exist in "+identifier+" is: "+count);
    }

    private int tokenize(SetInterface set,File file, int tokenizeFlag,String ds){
        int count = 0; //for counting the number of words not present in the set
        FileWriter fileToWrite = null;
        String fileName = "src/csvFiles/"+ds+".csv";
        String fileHeader = "words_present,time_to_insert";
        try {
            fileToWrite = new FileWriter(fileName,true);
            Scanner scanner = new Scanner(file);
            fileToWrite.append(fileHeader);
            fileToWrite.append("\n");
            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split("[^a-zA-Z0-9]+");
                for (String token : tokens) {
                    if(tokenizeFlag == 0){
                        if(!token.equals("")) {
                            Integer x = set.size();//no of words already inserted
                            long startTime = System.nanoTime();
                            set.add(token); //perform adding elements
                            long estimatedTime = System.nanoTime() - startTime;
                            Long y = estimatedTime; //number of nanoseconds it took to insert this particular token
                            fileWriter(fileToWrite, x.toString(), y.toString());
                        }
                    }
                    else if(tokenizeFlag == 1){
                        if(!token.equals("")){
                            if(set.contains(token) == false){
                                count++;
                            }
                        }
                    }
                }
            }
            fileToWrite.flush();
            fileToWrite.close();
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

    public static void main(String[] args) {

        Set set = new Set();
        SetList setList = new SetList();
        SetTree setTree = new SetTree();
        SetHashTable setHashTable = new SetHashTable();
        for(int i = 1; i <= 10; i++){
            set.insert(setList,"list"+i);
            set.insert(setTree,"tree"+i);
            set.insert(setHashTable,"hashTable"+i);
        }
        //set.insert(setList);
        //set.insert(setTree);
        //set.insert(setHashTable);
        //set.searchWords(setList);
        //set.searchWords(setTree);
        //set.searchWords(setHashTable);

    }
}
