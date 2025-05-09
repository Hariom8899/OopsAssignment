package AdvanceLevel;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class q15_CharFrequencyCounter {

    public static void main(String[] args) {
        // Specify the input and output file paths
        String inputFilePath = "src/data.txt"; // Replace with your input file path
        String outputFilePath = "src/charcount.txt"; // Output file path

        // Create a map to store character frequencies
        Map<Character, Integer> charCountMap = new HashMap<>();

        try {
            // Read all lines from the input file
            List<String> lines = Files.readAllLines(Paths.get(inputFilePath));

            // Process each line
            for (String line : lines) {
                // Convert the line to a character array
                char[] characters = line.toCharArray();

                // Count the frequency of each character
                for (char c : characters) {
                    charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
                }
            }

            // Write the character frequencies to the output file
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFilePath))) {
                for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
                    writer.write(entry.getKey() + ": " + entry.getValue());
                    writer.newLine();
                }
            }

            System.out.println("Character frequencies have been written to " + outputFilePath);

        } catch (IOException e) {
            System.err.println("An error occurred while reading or writing files: " + e.getMessage());
        }
    }
}

