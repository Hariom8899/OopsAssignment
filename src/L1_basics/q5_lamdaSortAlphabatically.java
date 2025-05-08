package L1_basics;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class q5_lamdaSortAlphabatically {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("car");
        strList.add("ram");
        strList.add("hariom");
        strList.add("hari");
        strList.add("AbC");
        strList.add("toy");
        // Sorting the ArrayList in alphabetical order using a lambda expression
        Collections.sort(strList, (s1, s2) -> s1.compareTo(s2));
        System.out.println(strList);
    }
}
