package L3_CollectorsAdvanStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class q18_joinListStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "grape", "kiwi", "cherry", "blueberry");

        String joinedStr = words.stream()
                .collect(Collectors.joining(","));
        System.out.println(joinedStr);
    }
}
