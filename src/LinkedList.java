public class LinkedList {
    private Node head; //To store the head of the list
    private int size = 0; //keeping count of the list size
    class Node{
        String word; //value at this node
        Node next; // pointer to the next
        Node(String word){ //constructor to initialize node
            this.word = word;
            this.next = null;
        }
    }
    //method to return the size of the linked list
    public int size(){
        return size;
    }
    //method to call the search function
    public Node contains(String word){
        return search(this.head,word);
    }

    //method to search for a node in the list
    private Node search(Node head,String word){
        Node trav = head;
        if(head == null ){
            return head;
        }
        while(trav != null){
            if(trav.word.equals(word)){
                return trav;
            }
            trav = trav.next;
        }
        return trav;
    }
    //method to add an element in the list at the head
    public void add(String word){
        size++;
        Node temp = new Node(word);
        temp.next = this.head;
        this.head = temp;

    }
    /*
    public void remove(Node head, String word){
        Node trav = head;
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        else if(head.word.equals(word)){
            this.head = this.head.next;
            return;
        }
        while(trav != null && !trav.next.word.equals(word)){
            trav = trav.next;
        }
        trav.next = trav.next.next;
    }*/

    //method to call the traversal function
    public void display(){
        traverse(this.head);
    }

    //method to traverse the list
    private void traverse(Node head){
        Node trav = head;
        while(trav != null){
            System.out.print(trav.word+"->");
            trav = trav.next;
        }
    }


}
