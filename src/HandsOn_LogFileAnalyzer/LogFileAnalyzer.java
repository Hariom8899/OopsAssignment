package HandsOn_LogFileAnalyzer;

import java.io.*;
import java.nio.file.*;

public class LogFileAnalyzer {

    public static void main(String[] args) {
        // Specify the input and output file paths
        String inputFilePath = "myLog.log"; // Input log file
        String outputFilePath = "src/summary.txt"; // Output summary file

        // Initialize counters
        int totalEntries = 0;
        int errorCount = 0;
        int warningCount = 0;

        // Read and analyze the log file
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                totalEntries++;
                if (line.contains("ERROR")) {
                    errorCount++;
                } else if (line.contains("WARNING")) {
                    warningCount++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the log file: " + e.getMessage());
            return;
        }

        // Write the summary to the output file
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFilePath))) {
            writer.write("Log Summary Report");
            writer.newLine();
            writer.write("------------------");
            writer.newLine();
            writer.write("Total log entries: " + totalEntries);
            writer.newLine();
            writer.write("ERROR entries: " + errorCount);
            writer.newLine();
            writer.write("WARNING entries: " + warningCount);
            writer.newLine();
            writer.write("ERROR percentage: " + calculatePercentage(errorCount, totalEntries) + "%");
            writer.newLine();
            writer.write("WARNING percentage: " + calculatePercentage(warningCount, totalEntries) + "%");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing the summary file: " + e.getMessage());
        }

        System.out.println("Log analysis complete. Summary written to " + outputFilePath);
    }

    /**
     * Calculates the percentage of a part over the total.
     *
     * @param part  The part value
     * @param total The total value
     * @return The percentage as a double
     */
    private static double calculatePercentage(int part, int total) {
        if (total == 0) {
            return 0.0;
        }
        return ((double) part / total) * 100;
    }
}

