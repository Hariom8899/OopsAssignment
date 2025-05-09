//Ques -> Chain multiple stream operations: filter > map > sort > collect.
package L4_ComplexOprComposition;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
public class q24 {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "army", "airforce","banana", "kiwi", "pear", "plum", "cherry", "date");

        // Chaining filter > map > sort > collect
        List<String> result = words.stream()
                .filter(word -> word.toLowerCase().startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result);
    }
}

