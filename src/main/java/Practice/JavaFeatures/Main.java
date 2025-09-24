package Practice.JavaFeatures;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User(1, "Alice", "alice@example.com", true),
                new User(2, "Bob", "bob@gmail.com", false),
                new User(3, "Charlie", "charlie@example.com", true),
                new User(4, "David", "david@yahoo.com", true),
                new User(5, "Eve", "eve@example.com", false)
        );

        List<UserDTO> filteredUsers = users.stream().filter((user)-> user.isActive() && user.getEmail().contains("@example.com")).map((user)->new UserDTO(user.getName(), user.getEmail())).collect(Collectors.toList());

        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.00),
                new Product("Mouse", "Electronics", 25.00),
                new Product("Keyboard", "Electronics", 75.00),
                new Product("T-Shirt", "Apparel", 20.00),
                new Product("Jeans", "Apparel", 60.00),
                new Product("Coffee", "Groceries", 15.00)
        );

        Map<String,Double> productType = products.stream().collect(Collectors.toConcurrentMap(Product::getCategory,Product::getPrice, Double::sum));

        Map<String,Double> productsType = products.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice)));

        LinkedHashMap<String, Double> sortedProductType = productType.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Double::sum,
                        LinkedHashMap::new
                ));
        for(Map.Entry<String,Double> entry:sortedProductType.entrySet()){
            System.out.println(entry.getValue() + entry.getKey());
        }


        StudentRepository repository = new StudentRepository();

        String studentName = repository.findStudentById(104).map((student)-> student.getName().toUpperCase()).orElse("Name does not Exist");

        System.out.println(studentName);


        Author author1 = new Author("Author A", Arrays.asList("Book 1", "Book 2"));
        Author author2 = new Author("Author B", Arrays.asList("Book 2", "Book 3", "Book 4"));
        Author author3 = new Author("Author C", Arrays.asList("Book 5"));

        List<Author> authors = Arrays.asList(author1, author2, author3);

        Set<String> authorsBook = authors.stream().flatMap((author)-> author.getBooks().stream()).collect(Collectors.toSet());

        authorsBook.forEach(System.out::println);



    }

}
