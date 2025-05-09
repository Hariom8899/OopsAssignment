package IntermediateLevel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class q8_ReadCSVAndPrintUppercase {

    public static void main(String[] args) {
        // Specify the file path (assuming it's in the same directory as the program)
        String fileName = "Employee.csv";

        // Read and process the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Convert the line to uppercase and print it
                System.out.println(line.toUpperCase());
            }
        } catch (IOException e) {
            // Handle any IOExceptions
            System.err.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}



