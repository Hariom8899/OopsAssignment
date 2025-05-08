package L3_CollectorsAdvanStream;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;
public class q20_OptionalDefault {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 6, 7, 8);

            Optional<Integer> optionalNumber = numbers.stream()
                    .filter(n -> n % 5 == 0)
                    .findFirst();

            // Use orElse() to provide a default value if not found
            int result = optionalNumber.orElse(-1);

            System.out.println("First number divisible by 5 (or default): " + result);
        }
    }

