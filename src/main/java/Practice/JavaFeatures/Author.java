package Practice.JavaFeatures;

import java.util.*;

public class Author {
    private final String name;
    private final List<String> books;

    public Author(String name, List<String> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public List<String> getBooks() {
        return books;
    }
}
