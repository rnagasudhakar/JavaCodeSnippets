package org.example.LLDDesigns.AutoCompleteSystem.models;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }


    public void storeWord(String word){
        TrieNode temp = root;
        for(int i=0;i<word.length();i++){
            TrieNode child = temp.getChildren().get(word.charAt(i));
            if(child==null){
                child = new TrieNode();
                temp.getChildren().put(word.charAt(i),child);
            }
            temp=child;
        }
        temp.setEndOfWord(true);
        temp.getCount().incrementAndGet();
    }

    void generateAllWords(TrieNode curr, HashSet<String> words,StringBuilder currWord){
        if(curr.isEndOfWord){
            words.add(String.valueOf(currWord));
        }
        for(HashMap.Entry<Character,TrieNode> entry : curr.getChildren().entrySet() ){
            currWord.append(entry.getKey());
            generateAllWords(entry.getValue(),words, currWord);
            currWord.deleteCharAt(currWord.length() - 1);
        }
    }

    public List<String> searchWord(String word){
        TrieNode temp = root;
        for(int i=0;i<word.length();i++){
            TrieNode child = temp.getChildren().get(word.charAt(i));
            if(child==null){
               throw new IllegalArgumentException("There is no prefix for this word");
            }
            temp=child;
        }
        HashSet<String> words = new HashSet<>();
        StringBuilder sb = new StringBuilder(word);
        generateAllWords(temp,words,sb);
        return new ArrayList<>(words);
    }
}
