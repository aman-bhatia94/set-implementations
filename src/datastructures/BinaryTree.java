/**
 * An implementation of Binary Search Tree
 */
package datastructures;

public class BinaryTree {
    private Node root; //root node of the binary search tree
    private int size = 0; //stores the number of nodes in the tree
    class Node{
        String word; //value of this node
        Node left; //left child of the node
        Node right; //right child of the node
        Node(String word){
            this.word = word;
            this.left = null;
            this.right = null;
        }
    }
    //method to return the size of the tree
    public int size(){
        return size;
    }

    //method to call the search method on the tree
    public Node contains(String word){

        return search(this.root,word);
    }

    //method to search for a given element in the tree
    private Node search(Node trav, String word){
        if(trav == null){
            return null;
        }
        else if(trav.word.equals(word)){
            return trav;
        }
        else if(word.compareTo(trav.word) < 0){
            return search(trav.left,word);
        }
        else{
            return search(trav.right, word);
        }
    }

    //method to traverse a tree
    private void traverseTree(Node root){
        if(size == 0){
            System.out.println("Empty tree");
        }
        if(root != null){
            traverseTree(root.left);
            System.out.print(root.word +" ");
            traverseTree(root.right);
        }
    }

    //method to call the traverseTree method
    public void display(){
        traverseTree(this.root);
    }

    //method to call addToTree method
    public Node add(String word){
        Node temp = addToTree(this.root,word);
        return temp;
    }

    //method to add a node to the tree
    private Node addToTree(Node root,String word){
        if(root == null){
            Node temp = new Node(word);
            if(size == 0){
                this.root = temp;
            }
            size++;
            return temp;
        }
        else if(word.compareTo(root.word) < 0){
            root.left = addToTree(root.left,word);
        }
        else if(word.compareTo(root.word) > 0){
            root.right = addToTree(root.right,word);
        }
        return root;

    }

}
