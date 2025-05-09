package BasicLevel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class q2_ReadPrint  {
    public static void main(String[] args) {
        File file = new File("input.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'input.txt' was not found.");
            e.printStackTrace();
        }
    }
}

