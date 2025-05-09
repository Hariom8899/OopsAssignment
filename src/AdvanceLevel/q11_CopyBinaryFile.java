package AdvanceLevel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class q11_CopyBinaryFile {
    public static void main(String[] args) {
        String sourceFile = "/Users/htiwari/Desktop/Image.jpg";
        String destinationFile = "Image_copy.jpg";

        try (
                FileInputStream inputStream = new FileInputStream(sourceFile);
                FileOutputStream outputStream = new FileOutputStream(destinationFile)
        ) {
            byte[] buffer = new byte[1024];  // Buffer for reading chunks
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);  // Write only the bytes read
            }

            System.out.println("File copied successfully from " + sourceFile + " to " + destinationFile);
        } catch (IOException e) {
            System.err.println("An error occurred during file copy.");
            e.printStackTrace();
        }
    }
}

