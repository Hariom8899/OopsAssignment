package l2_StreamOprn;

import java.util.Arrays;
import java.util.List;

public class q10_filterLen {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("ram", "hsya", "meena","abc",  "forge", "abced", "numbers");

        stringList.stream()
                .filter(s -> s.length() > 4)
                .forEach(System.out::println);
    }
}
