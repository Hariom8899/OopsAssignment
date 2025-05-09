package BasicLevel;
import java.io.IOException;
import java.nio.file.*;

public class q5_copyFile {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("data.txt");
        Path destinationPath = Paths.get("backup.txt");

        try {
            // Copy the source file to the destination
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.err.println("An error occurred during file copy: " + e.getMessage());
        }
    }
}

