package org.example.LLDDesigns.AutoCompleteSystem.models;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TrieNode {
    HashMap<Character,TrieNode> children;
    boolean isEndOfWord;
    AtomicInteger count;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isEndOfWord = false;
        this.count = new AtomicInteger(0);
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public AtomicInteger getCount() {
        return count;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    public void setCount(AtomicInteger count) {
        this.count = count;
    }
}
