package IntermediateLevel;
import java.io.File;
public class q9_DeleteFile {
    public static void main(String[] args) {
        String fileName = "oldfile.txt";

        // Create a File object representing the file
        File file = new File(fileName);

        if (file.exists()) {
            if (file.delete()) {
                System.out.println(fileName + " has been deleted.");
            } else {
                System.out.println("Failed to delete " + fileName);
            }
        } else {
            System.out.println(fileName + " does not exist.");
        }
    }
}

