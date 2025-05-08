package l2_StreamOprn;

import java.util.Arrays;
import java.util.List;

public class q11_startsWithS {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("ram", "Sun", "hsya", "meena", "abc", "Sony", "Sorge", "abced", "numbers");

        stringList.stream()
                .filter(s -> s.startsWith("S"))
                .forEach(System.out::println);
    }
}
