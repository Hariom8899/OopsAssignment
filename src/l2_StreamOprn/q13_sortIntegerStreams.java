package l2_StreamOprn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class q13_sortIntegerStreams {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(19, 12, 23, 24, 35, 16, 7, 8, 19);

        num.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}
