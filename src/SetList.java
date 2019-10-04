/**
 * Set implementation using a singly linked list
 */
public class SetList implements SetInterface{
    private LinkedList list;
    //initialize a linked list
    SetList(){
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
    /*public static void main(String[] args){

        SetList setList = new SetList();
        setList.displaySet();
        setList.add("abc");

        setList.add("def");
        setList.displaySet();

        setList.add("def");
        setList.displaySet();

        setList.add("abc");
        setList.displaySet();

        setList.add("ghi");
        setList.displaySet();

        System.out.print(setList.size());
    }*/
}
