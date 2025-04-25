package q6_StudentRegistry;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        Student student3 = new Student("Charlie");

        System.out.println("Student 1: " + student1.getName() + ", ID: " + student1.getId());
        System.out.println("Student 2: " + student2.getName() + ", ID: " + student2.getId());
        System.out.println("Student 3: " + student3.getName() + ", ID: " + student3.getId());

        // Display total number of students
        System.out.println("Total number of students: " + Student.getTotalStudents());
    }
}

