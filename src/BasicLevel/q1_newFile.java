package BasicLevel;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class q1_newFile {
    public static void main(String[] args) {
        String filePath = "/Users/htiwari/Desktop/notes.txt";
        String content = "This is my first file in Java.";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content); // Write content to the file
            System.out.println("File created and content written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while creating or writing to the file.");
            e.printStackTrace();
        }
    }
}

