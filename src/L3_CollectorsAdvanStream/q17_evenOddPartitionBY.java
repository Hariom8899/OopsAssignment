package L3_CollectorsAdvanStream;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;

public class q17_evenOddPartitionBY {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Map<Boolean, List<Integer> > partitons = num.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println(partitons.get(true));
        System.out.println(partitons.get(false));
    }
}
