//Ques Find the product of all even numbers in a list using reduce()
package L4_ComplexOprComposition;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class q28_prodEvenNumFilt {
    public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 9, 10, 12);

    int productEvenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .reduce(1, (a, b) -> a*b);

    System.out.println(productEvenNumbers);
}
}
