package l2_StreamOprn;

import java.util.Arrays;
import java.util.List;

public class q14_numToSquars {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        num.stream()
                .map(n -> n * n)
                .forEach(System.out::println);
    }
}
