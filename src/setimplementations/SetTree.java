/**
 * Implementation of a set using a Tree
 */

package setimplementations;
import datastructures.BinaryTree;

public class SetTree implements SetInterface{
    private BinaryTree bst;
    public SetTree(){
        bst = new BinaryTree();
    }

    public int size(){
        return bst.size();
    }

    //Searching if the set already contains the given element
    public boolean contains(String word){
        if(bst.contains(word) != null){
            return true;
        }
        return false;
    }

    //method to add an element into the set
    public boolean add(String word){
        boolean present = contains(word);
        if(present == true)
            return false;
        bst.add(word);
        return true;
    }

    //method to display the set
    public void displaySet(){
        if(size() == 0){
            System.out.println("Empty Set");
            return;
        }
        bst.display();
        System.out.println();
    }

}
