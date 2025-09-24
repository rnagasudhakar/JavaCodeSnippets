package org.example.HashMap;

public class CustomHashMap<K,V>{

    static final int INITIAL_SIZE = 1<<4;
    static final int MAX_SIZE = 1<<30; // as size is denoted by integer in java so max size can be max integer which is 2^31 but one bit goes for signed.
    public final double loadBalanceFactor = 0.75f;
    // if number of elements / size increases by loadBalanceFactor then we will multiply size by 2 and again insert all elements again.

    public Entry<K,V>[] hashTable;

    CustomHashMap(){
        this.hashTable = new Entry[INITIAL_SIZE];
    }

    public void put(K key, V value){
        int hashCode = key.hashCode() & (hashTable.length - 1); // this works only when length is in 2 powers

        if(hashTable[hashCode]==null){
            Entry<K,V> currentNode = new Entry<>(key,value);
            hashTable[hashCode] = currentNode;
        }
        else{
            Entry<K,V>  currentNode = hashTable[hashCode];
            while(currentNode.getEntry() != null){
                if(currentNode.getKey().equals(key)){
                    currentNode.setValue(value);
                    return ;
                }
                currentNode = currentNode.getEntry();
            }
            if(currentNode.getKey().equals(key)){
                currentNode.setValue(value);
                return ;
            }
            currentNode.setEntry(new Entry<K,V>(key,value));
        }
    }









}