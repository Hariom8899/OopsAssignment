package q1_studentManager;
import java.util.*;
import java.util.stream.Collectors;

class Student {
    int id;
    String name;
    int age;
    double grade;
    String branch;

    public Student(int id, String name, int age, double grade, String branch) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.branch = branch;
    }

    @Override
    public String toString() {
        return String.format("Student{id=%d, name='%s', age=%d, grade=%.2f, branch='%s'}",
                id, name, age, grade, branch);
    }

    public String getBranch() {
        return branch;
    }
    public double getGrade() {
        return grade;
    }
}

public class StudentManager {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Alice", 20, 88.5, "Computer Science"),
                new Student(2, "Bob", 21, 91.2, "Electronics"),
                new Student(3, "Charlie", 22, 79.0, "Mechanical"),
                new Student(4, "Diana", 20, 85.3, "Computer Science"),
                new Student(5, "Eve", 23, 92.1, "Electronics"),
                new Student(6, "Frank", 22, 76.5, "Mechanical"),
                new Student(7, "Grace", 21, 88.0, "Computer Science"),
                new Student(8, "Hank", 23, 70.4, "Civil"),
                new Student(9, "Ivy", 20, 89.5, "Electronics"),
                new Student(10, "Jack", 24, 81.3, "Mechanical"),
                new Student(11, "Kathy", 21, 93.2, "Computer Science"),
                new Student(12, "Leo", 20, 67.0, "Civil"),
                new Student(13, "Mona", 22, 85.0, "Mechanical"),
                new Student(14, "Nick", 23, 90.5, "Electronics"),
                new Student(15, "Oscar", 24, 72.8, "Civil")
        ));

        // Sort by branch, then by descending grade
        students.sort(Comparator.comparing(Student::getBranch)
                .thenComparing(Comparator.comparingDouble(Student::getGrade).reversed()));

        // Group by branch
        Map<String, List<Student>> groupedByBranch = students.stream()
                .collect(Collectors.groupingBy(Student::getBranch));

        // Print grouped students
        for (Map.Entry<String, List<Student>> entry : groupedByBranch.entrySet()) {
            System.out.println("Branch: " + entry.getKey());
            for (Student s : entry.getValue()) {
                System.out.println("  " + s);
            }
        }
    }
}
