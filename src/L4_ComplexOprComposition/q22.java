//Ques -> Write a function that takes a list of strings and returns a map of word to its length.

package L4_ComplexOprComposition;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class q22 {

    public static void main(String[] args) {
        List<String> wordList = List.of("apple", "banana", "cherry", "date");

        Map<String, Integer> result = wordList.stream()
                .collect(Collectors.toMap(
                        word -> word,
                        word -> word.length()
                ));

        System.out.println(result);
    }
}
