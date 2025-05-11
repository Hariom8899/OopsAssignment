import java.io.*;
import java.nio.file.*;
import java.util.*;

public class MultiLevelExceptionDemo {

    // Custom exception for data processing errors
    static class DataProcessingException extends Exception {
        public DataProcessingException(String message) {
            super(message);
        }
    }

    // Method to read data from a file
    public static void readData() throws IOException {
        Path path = Paths.get("server.log");
        List<String> lines = Files.readAllLines(path);
        System.out.println("File read successfully.");
    }

    // Method to process data, calls readData() and handles IOException
    public static void processData() throws DataProcessingException {
        try {
            readData();
        } catch (IOException e) {
            System.err.println("IOException caught in processData: " + e.getMessage());
            throw new DataProcessingException("Data processing failed due to I/O error.");
        }
    }

    // Main method to handle DataProcessingException
    public static void main(String[] args) {
        try {
            processData();
        } catch (DataProcessingException e) {
            System.err.println("DataProcessingException caught in main: " + e.getMessage());
        }
    }
}
