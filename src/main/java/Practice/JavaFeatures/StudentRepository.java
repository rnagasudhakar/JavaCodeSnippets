package Practice.JavaFeatures;

import java.util.*;

public class StudentRepository {
    private final Map<Integer, Student> studentDb = new HashMap<>();

    public StudentRepository() {
        studentDb.put(101, new Student(101, "John Doe"));
        studentDb.put(102, new Student(102, "Jane Smith"));
    }

    public Optional<Student> findStudentById(Integer id) {
        return Optional.ofNullable(studentDb.get(id));
    }
}
