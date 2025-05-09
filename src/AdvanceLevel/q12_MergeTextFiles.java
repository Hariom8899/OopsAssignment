package AdvanceLevel;

import java.io.*;
import java.nio.file.*;

public class q12_MergeTextFiles {
    public static void main(String[] args) {
        // Specify the folder containing .txt files
        String folderPath = "/Users/htiwari/IdeaProjects/IO/src";  // Folder where .txt files are located
        String mergedFilePath = "merged.txt";  // Output file

        // Create a File object representing the folder
        File folder = new File(folderPath);

        // Check if the folder exists and is a directory
        if (folder.exists() && folder.isDirectory()) {
            // Get all .txt files in the folder
            File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

            // If there are no .txt files in the folder
            if (files == null || files.length == 0) {
                System.out.println("No .txt files found in the folder.");
                return;
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(mergedFilePath))) {
                // Loop through each .txt file
                for (File file : files) {
                    System.out.println("Merging file: " + file.getName());

                    // Read the contents of each .txt file
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            // Write each line to the merged file
                            writer.write(line);
                            writer.newLine();
                        }
                    } catch (IOException e) {
                        System.err.println("Error reading file: " + file.getName());
                        e.printStackTrace();
                    }
                }
                System.out.println("All files have been merged into " + mergedFilePath);
            } catch (IOException e) {
                System.err.println("Error writing to the merged file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("The folder does not exist or is not a directory.");
        }
    }
}
