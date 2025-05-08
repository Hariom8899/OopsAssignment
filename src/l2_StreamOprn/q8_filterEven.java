package l2_StreamOprn;
import java.util.List;
import java.util.Arrays;

public class q8_filterEven {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        num.stream()
                .filter(n -> n%2 == 0)
                .forEach(System.out::println);
    }
}
