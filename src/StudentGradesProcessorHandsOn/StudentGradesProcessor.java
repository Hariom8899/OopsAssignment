package StudentGradesProcessorHandsOn;
import java.io.*;
import java.util.*;
import java.util.logging.*;

// Custom exception for invalid grades
class InvalidGradeException extends Exception {
    public InvalidGradeException(String message) {
        super(message);
    }
}

// StudentGradesProcessor class to process student grades
public class StudentGradesProcessor {

    // Logger to log warnings
    private static final Logger logger = Logger.getLogger(StudentGradesProcessor.class.getName());

    public static void main(String[] args) {
        // File path (can be changed if needed)
        String filePath = "grades.txt";

        // List to hold valid student names and grades
        List<String> validStudents = new ArrayList<>();
        List<Integer> grades = new ArrayList<>();
        List<String> failingStudents = new ArrayList<>();

        BufferedReader reader = null;
        try {
            // Initialize reader
            reader = new BufferedReader(new FileReader(filePath));
            String line;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                try {
                    // Split the line into name and grade
                    String[] parts = line.split(" ");
                    if (parts.length != 2) {
                        throw new IllegalArgumentException("Invalid line format");
                    }
                    String studentName = parts[0];
                    int grade = Integer.parseInt(parts[1]);

                    // Validate grade range
                    if (grade < 0 || grade > 100) {
                        throw new InvalidGradeException("Grade out of range for " + studentName);
                    }

                    // If everything is valid, add to the lists
                    validStudents.add(studentName);
                    grades.add(grade);

                    // Identify failing students
                    if (grade < 40) {
                        failingStudents.add(studentName);
                    }

                } catch (NumberFormatException e) {
                    logger.warning("Non-numeric grade for line: " + line);
                } catch (InvalidGradeException e) {
                    logger.warning(e.getMessage());
                } catch (IllegalArgumentException e) {
                    logger.warning("Invalid format in line: " + line);
                }
            }

            // Calculate the average grade if there are any valid entries
            if (grades.size() > 0) {
                double averageGrade = grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
                System.out.println("Average grade: " + averageGrade);
            } else {
                System.out.println("No valid grades found.");
            }

            // Print valid students and their grades
            System.out.println("Valid Students and Grades:");
            for (int i = 0; i < validStudents.size(); i++) {
                System.out.println(validStudents.get(i) + ": " + grades.get(i));
            }

            // Print failing students
            System.out.println("\nFailing Students:");
            for (String failingStudent : failingStudents) {
                System.out.println(failingStudent);
            }

        } catch (FileNotFoundException e) {
            logger.severe("File not found: " + filePath);
        } catch (IOException e) {
            logger.severe("Error reading the file: " + e.getMessage());
        } finally {
            // Close the BufferedReader properly in the finally block
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                logger.warning("Error closing the file: " + e.getMessage());
            }
        }
    }
}
