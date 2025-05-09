package IntermediateLevel;
import java.io.File;

public class q10_ListFilesInDirectory {
    public static void main(String[] args) {
        String folderPath = "/Users/htiwari/Documents";

        // Create a File object representing the folder
        File folder = new File(folderPath);

        // Check if the folder exists and is a directory
        if (folder.exists() && folder.isDirectory()) {
            // List all files and directories inside the folder
            String[] fileList = folder.list();

            if (fileList != null && fileList.length > 0) {
                System.out.println("Files and directories in the '" + folderPath + "' folder:");
                for (String fileName : fileList) {
                    System.out.println(fileName);
                }
            } else {
                System.out.println("The folder is empty.");
            }
        } else {
            System.out.println("The folder '" + folderPath + "' does not exist or is not a directory.");
        }
    }
}
