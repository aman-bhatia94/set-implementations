/**
 * An implementation of Hash Table
 */

package datastructures;//An implementation of hash table
import java.lang.Math;
public class HashTable {
    private LinkedList[] lists;
    private int capacity;//capacity of the hash table
    private int size = 0;//size of the hash table
    public HashTable(){
        //capacity is chosen as a prime number, because using a prime number reduces the number of collisions, mod operations become easy
        //source of the above info - stackoverflow.com
        capacity = 1019;
        lists = new LinkedList[capacity];
        //initialize the linked lists
        for(int index = 0; index < capacity; index++){
            lists[index] = new LinkedList();
        }

    }

    //method to get the size(no of items) in the hash table
    public int size(){
        return size;
    }

    //method to call addToTable function
    public boolean add(String word){
        return addToTable(word);
    }

    //method to add an element into the table
    private boolean addToTable(String word){
        int hashCode = word.hashCode(); //hashcode
        int index = hashCode%this.capacity;
        index = Math.abs(index);
        lists[index].add(word);
        size++;
        return true;
    }

    //method to call search in the table
    public boolean contains(String word){
        return search(word);
    }

    //method to search for a word in the hash table
    private boolean search(String word){
        int hashCode = word.hashCode(); //hashcode
        int index = hashCode%this.capacity;
        index = Math.abs(index);
        if(lists[index].contains(word) != null){
            return true;
        }
        return false;
    }

    public void display(){
        for(int index=0 ; index < 1000 ; index++){
            lists[index].display();
            System.out.println("--end--  |");
        }
    }
}
