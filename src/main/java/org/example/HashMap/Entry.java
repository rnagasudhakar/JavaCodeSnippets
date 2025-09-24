package org.example.HashMap;

public class Entry<K, V> {

    private final K key;
    private V value;
    private Entry<K,V> entry;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setEntry(Entry<K,V> entry) {
        this.entry = entry;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Entry<K,V> getEntry() {
        return entry;
    }

}