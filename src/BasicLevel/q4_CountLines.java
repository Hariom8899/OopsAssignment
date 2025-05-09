package BasicLevel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class q4_CountLines {
    public static void main(String[] args) {
        String filePath = "src/data.txt"; // Specify the path to your file
        int lineCount = countLines(filePath);
        if (lineCount != -1) {
            System.out.println("Number of lines in 'data.txt': " + lineCount);
        } else {
            System.out.println("An error occurred while counting the lines.");
        }
    }

    public static int countLines(String filePath) {
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return lineCount;
    }
}
