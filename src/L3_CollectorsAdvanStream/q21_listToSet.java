package L3_CollectorsAdvanStream;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.stream.Collectors;

    public class q21_listToSet {
        public static void main(String[] args) {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 3, 5);

            Set<Integer> numberSet = numbers.stream()
                    .collect(Collectors.toSet());

            System.out.println("Set of unique numbers: " + numberSet);
        }
    }