package BasicLevel;

import java.io.File;

public class q3_pdfChecker {
    public static void main(String[] args) {
        File file = new File("/Users/htiwari/Downloads/report.pdf");

        if (file.exists() && file.isFile()) {
            long fileSize = file.length();
            System.out.println("File 'report.pdf' exists.");
            System.out.println("File size: " + fileSize + " bytes");
        } else {
            System.out.println("File 'report.pdf' does not exist or is not a valid file.");
        }
    }
}

