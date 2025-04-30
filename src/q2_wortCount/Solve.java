package q2_wortCount;
import com.sun.source.tree.Tree;

import java.util.*;

class Data {
    String para = "He raced to the grocery store. He went inside but realized he forgot his wallet. He raced back home to grab it. Once he found it, he raced to the car again and drove back to the grocery store";
}

public class Solve{
    public static void main(String[] args) {
        Data d = new Data();
        // Create a TreeMap with String as the key and Integer as the value
        TreeMap<String, Integer> map = new TreeMap<>();
        //splitting it as per the space bases and then inserting each word in the string array
        String[] words = d.para.split("\\s+");
        for(String word : words){
            int ct = map.getOrDefault(word, 0);
            map.put(word, ct+1);
        }

        System.out.println("Number of Unique Words: " + map.size());

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        List<String> sortedWords = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            for(int i = 0; i < entry.getValue(); i++ ){
                sortedWords.add(entry.getKey());
            }
        }

        for(String word : sortedWords){
            System.out.print(word + " ");
        }

    }
}

