package l2_StreamOprn;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class q12_longestStr {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("ram", "hsya", "meena", "abc", "forge", "abced", "znder" ,"nfrtu");

        Optional<String> longest  = stringList.stream()
                .reduce( (a, b) -> a.length()>=b.length()?a:b);
        longest.ifPresent(str -> System.out.println("Longest string: " + str));
    }
}