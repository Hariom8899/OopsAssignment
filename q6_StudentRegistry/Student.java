package q6_StudentRegistry;

public class Student {
    private static int studentCount = 0;  // Static counter to track total number of students
    private int id;                       // Unique ID for each student
    private String name;                  // Name of the student

    // Constructor to initialize student ID and name
    public Student(String name) {
        this.id = ++studentCount;        // Increment student count for each new student
        this.name = name;
    }

    // Getter for student ID
    public int getId() {
        return id;
    }

    // Getter for student name
    public String getName() {
        return name;
    }

    // Static method to get the total number of students
    public static int getTotalStudents() {
        return studentCount;
    }
}

