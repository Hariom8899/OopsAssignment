package IntermediateLevel;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class q7_AppendToFile {
    public static void main(String[] args) {
        // Get the current date in the desired format
        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        // The line to append to the file
        String lineToAppend = "Last updated on " + currentDate + "\n";

        // Try-with-resources to ensure the FileWriter is closed automatically
        try (FileWriter fileWriter = new FileWriter("log.txt", true)) {
            // Append the line to the file
            fileWriter.write(lineToAppend);
            System.out.println("Appended the line: " + lineToAppend);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

