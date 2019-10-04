package set; /**
 * @Author Aman Bhatia
 * The main class that tokenizes each file...
 */
import setimplementations.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Set {

    public static void main(String[] args) {
        /*String s = "Posting Date: August 26, 2008 [EBook #1342]";
        //String check = s.replaceAll("[^a-zA-Z0-9]"," ");
        //System.out.print(check);
        //String check2 = s.
        String[] array = s.split("[^a-zA-Z0-9]+");
        int count = 0;
        for (int i = 0; i < array.length; i++){
            if(array[i].equals("")){
                continue;
            }
            System.out.println(array[i]);
            count++;
        }
        System.out.print(count);*/
        SetList setList = new SetList();
        SetTree setTree = new SetTree();
        SetHashTable setHashTable = new SetHashTable();
        try {
            Scanner scanner = new Scanner(new File("src/set/pride-and-prejudice.txt"));
            while(scanner.hasNextLine()){
                String[] tokens = scanner.nextLine().split("[^a-zA-Z0-9]+");
                for(String token : tokens){
                    setList.add(token);
                    setTree.add(token);
                    setHashTable.add(token);
                }

            }
            System.out.println("The size of the list set is: "+setList.size());
            System.out.println("The size of the tree set is: "+setTree.size());
            System.out.println("The size of the hash table set is: "+setHashTable.size());
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file specified, check the path");
            e.printStackTrace();
        }

    }
}
