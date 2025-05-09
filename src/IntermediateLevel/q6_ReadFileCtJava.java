//Write a program to read all the words from paragraph.txt and
//count how many times the word "Java" appears.
package IntermediateLevel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class q6_ReadFileCtJava {
    public static void main(String[] args) {
        String filePath = "src/data.txt"; // Path to your input file
        String targetWord = "java"; // Word to search for
        int count = countWordOccurrences(filePath, targetWord);
        System.out.println("The word '" + targetWord + "' appears " + count + " times.");
    }

    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Convert line to lowercase and split into words
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}

