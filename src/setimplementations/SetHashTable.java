/**
 * Implementation of a set using a Hash Table
 */
package setimplementations;
import datastructures.HashTable;

//Implementation of a set using a hash table
public class SetHashTable implements SetInterface {

    private HashTable hashTable;
    //initialize the Set
    public SetHashTable(){
        hashTable = new HashTable();
    }

    //method to add a word to Hash set
    @Override
    public boolean add(String word) {
        boolean isPresent = hashTable.contains(word);
        if(isPresent == true){
            return false;
        }
        hashTable.add(word);
        return true;
    }

    //method to check if set contains word
    @Override
    public boolean contains(String word) {

        boolean isPresent = hashTable.contains(word);
        return isPresent;
    }

    //method to get the size of the set
    @Override
    public int size() {
        return hashTable.size();
    }

}
