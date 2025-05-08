package l2_StreamOprn;

import java.util.Arrays;
import java.util.List;

public class q9_mapUpperCase {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("ram", "hsya", "meena", "forge", "abced", "numbers");

        stringList.stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);
    }
}
