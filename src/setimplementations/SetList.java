/**
 * Implementation of a set using a Linked List
 */
package setimplementations;
import datastructures.LinkedList;

public class SetList implements SetInterface{
    private LinkedList list;
    //initialize a linked list
    public SetList(){
        list = new LinkedList();
    }
    //Searching if the set already contains the given element
    public boolean contains(String word){
        if(list.contains(word) != null){
            return true;
        }
        else
            return false;
    }

    //method to add an element into the set
    public boolean add(String word){
        boolean wordPresent = contains(word);
        if(wordPresent == true){
            return false;
        }
        else{
            list.add(word);
            return true;
        }
    }
    //method to get the size of the set
    public int size(){
        return list.size();
    }

    //method to display the elements in the set
    public void displaySet(){
        if(size() == 0) {
            System.out.println("Empty Set" + "\n");
            return;
        }
        list.display();
        System.out.println();
    }
}
