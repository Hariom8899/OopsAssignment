package q15_ColledgeSubjectAllot;

import java.util.*;

public class CollegeSubjectAllotment {
    // Map to store which subjects each student is allotted
    private static Map<String, List<String>> studentSubjects = new HashMap<>();

    // Map to store reverse lookup: which students chose a specific subject
    private static Map<String, List<String>> subjectStudents = new HashMap<>();

    public static void main(String[] args) {
        // Add subjects for students
        allotSubject("Alice", "Math");
        allotSubject("Alice", "Physics");
        allotSubject("Bob", "Chemistry");
        allotSubject("Bob", "Physics");
        allotSubject("Charlie", "Math");

        // Display subjects for each student
        displayStudentSubjects();

        // Reverse lookup: Find which students chose a particular subject
        findStudentsBySubject("Math");
        findStudentsBySubject("Physics");
        findStudentsBySubject("Chemistry");
    }

    // Method to allot subject to a student and update both maps
    public static void allotSubject(String studentName, String subject) {
        // Update studentSubjects map
        studentSubjects.computeIfAbsent(studentName, k -> new ArrayList<>()).add(subject);

        // Update subjectStudents map for reverse lookup
        subjectStudents.computeIfAbsent(subject, k -> new ArrayList<>()).add(studentName);

        System.out.println(studentName + " has been allotted " + subject);
    }

    // Display subjects allotted to each student
    public static void displayStudentSubjects() {
        System.out.println("\nStudent Subject Allotment:");
        for (Map.Entry<String, List<String>> entry : studentSubjects.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Find which students chose a particular subject
    public static void findStudentsBySubject(String subject) {
        List<String> students = subjectStudents.get(subject);
        if (students != null) {
            System.out.println("Students who chose " + subject + ": " + students);
        } else {
            System.out.println("No students chose " + subject);
        }
    }
}

