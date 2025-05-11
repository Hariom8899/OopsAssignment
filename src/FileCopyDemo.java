import java.io.*;

public class FileCopyDemo {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        // try-with-resources to safely handle both resources
        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // preserve line breaks
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.err.println("Error during file operation: " + e.getMessage());
        }
    }
}
