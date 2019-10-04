package setimplementations;

import datastructures.HashTable;

//Implementation of a set using a hash table
public class SetHashTable implements SetInterface {

    private HashTable hashTable;
    //initialize the HashSet and thus internally the datastructures.HashTable
    public SetHashTable(){
        hashTable = new HashTable();
    }

    @Override
    public boolean add(String word) {
        boolean isPresent = hashTable.contains(word);
        if(isPresent == true){
            return false;
        }
        hashTable.add(word);
        return true;
    }

    @Override
    public boolean contains(String word) {

        boolean isPresent = hashTable.contains(word);
        return isPresent;
    }

    @Override
    public int size() {
        return hashTable.size();
    }

    /*public static void main(String[] args) {
        setimplementations.SetHashTable set = new setimplementations.SetHashTable();
        System.out.println(set.size());
        System.out.println(set.contains("aaa"));
        set.add("aaa");
        System.out.println(set.contains("aaa"));
        System.out.println(set.size());
        System.out.println(set.contains("aaa"));
        System.out.println(set.contains("bbb"));
        set.add("bbb");
        System.out.println(set.contains("bbb"));
        System.out.println(set.size());
        boolean isadded = set.add("aaa");
        System.out.println("is aaa added again"+isadded);
        System.out.println(set.contains("aaa"));
        System.out.println(set.size());
    }*/
}
