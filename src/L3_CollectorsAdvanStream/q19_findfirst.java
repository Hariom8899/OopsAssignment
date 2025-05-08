package L3_CollectorsAdvanStream;
import java.util.Optional;
import java.util.Arrays;
import java.util.List;

public class q19_findfirst {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 9, 10, 12, 590);

        // Finding the first number divisible by 5
        Optional<Integer> firstDivisibleByFive = numbers.stream()
                .filter(n -> n % 5 == 0)
                .findFirst();

        // Checking if a result is present and printing it
        if (firstDivisibleByFive.isPresent()) {
            System.out.println("The first number divisible by 5 is: " + firstDivisibleByFive.get());
        } else {
            System.out.println("No number divisible by 5 found.");
        }
    }
}

