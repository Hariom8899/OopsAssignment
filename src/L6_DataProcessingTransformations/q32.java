//From a list of students with names and grades, return a list of names of students who scored above 80, sorted alphabetically.
package L6_DataProcessingTransformations;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}

public class q32 {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 90),
                new Student("Bob", 75),
                new Student("Charlie", 85),
                new Student("David", 95),
                new Student("Eve", 80),
                new Student("Zoe", 88),
                new Student("Carol", 92)
        );

        List<String> highScoringStudentNames = students.stream()
                .filter(student -> student.getGrade() > 80)
                .map(Student::getName)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Students who scored above 80 (sorted):");
        highScoringStudentNames.forEach(System.out::println);
    }
}