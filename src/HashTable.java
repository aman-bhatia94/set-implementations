//An implementation of hash table
import java.lang.Math;
public class HashTable {
    private LinkedList[] lists;
    private int capacity;//capacity of the hash table
    private int size = 0;//size of the hash table
    HashTable(){
        capacity = 1000;
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

        //checking if a list is created at the index or not
        /*if(lists[index].size() == 0){
            //if the linked list is empty at this index then we create it, otherwise we simply add the element
            lists[index] = new LinkedList();
        }*/
        lists[index].add(word);
        size++;
        return true;
    }

    //method to call search in the table
    public boolean contains(String word){
        return search(word);
    }

    private boolean search(String word){
        int hashCode = word.hashCode(); //hashcode
        int index = hashCode%this.capacity;
        index = Math.abs(index);

        //internally the linked list methods will now search if this element is present in the  chained list or not
        /*if(lists[index].size() == 0){
            return false;
        }*/
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

   /* public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.add("abc");
        ht.add("abc");
        ht.add("a");
        ht.add("b");
        ht.display();
        System.out.println(ht.size());
    }*/

}
