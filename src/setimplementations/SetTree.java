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

    public boolean contains(String word){
        if(bst.contains(word) != null){
            return true;
        }
        return false;
    }

    public boolean add(String word){
        boolean present = contains(word);
        if(present == true)
            return false;
        bst.add(word);
        return true;
    }

    public void displaySet(){
        if(size() == 0){
            System.out.println("Empty Set");
            return;
        }
        bst.display();
        System.out.println();
    }

    /*public static void main(String[] args) {
        setimplementations.SetTree set = new setimplementations.SetTree();
        set.displaySet();
        set.add("b");
        set.displaySet();
        set.add("aman");
        set.displaySet();
        set.add("a");
        set.displaySet();
        set.add("cat");
        set.displaySet();
        set.add("c");
        set.displaySet();
    }*/
}
