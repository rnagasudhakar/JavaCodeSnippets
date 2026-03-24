package org.example.LLDDesigns.AutoCompleteSystem.strategy;

import java.util.List;

public interface SearchStrategy {
    public List<String> getSuggestions(List<String> words, String currentWord);
}
