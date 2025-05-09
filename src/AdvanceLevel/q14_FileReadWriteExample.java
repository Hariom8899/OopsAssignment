package AdvanceLevel;
import java.nio.file.*;
        import java.io.IOException;
import java.util.List;
import java.util.Arrays;

public class q14_FileReadWriteExample {
    public static void main(String[] args) {
        // Define the paths for the source and destination files
        Path sourcePath = Paths.get("source.txt");
        Path destinationPath = Paths.get("destination.txt");

        // Data to write to the source file
        List<String> lines = Arrays.asList("Hello, World!", "Java NIO is powerful.");

        // Write data to the source file
        try {
            Files.write(sourcePath, lines);
            System.out.println("Data written to source file successfully.");
        } catch (IOException e) {
            System.err.println("I/O error while writing to source file: " + e.getMessage());
        }

        // Read data from the source file and write it to the destination file
        try {
            List<String> readLines = Files.readAllLines(sourcePath);
            Files.write(destinationPath, readLines);
            System.out.println("Data copied to destination file successfully.");
        } catch (IOException e) {
            System.err.println("I/O error during file operations: " + e.getMessage());
        }
    }
}

