package RealLifeMiniChallenge;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class q53_DateAnalyzer {

    // Method to find the earliest and latest date from a list of dates
    public static Map<String, LocalDate> findEarliestAndLatest(List<LocalDate> dates) {
        // Custom comparator (although the natural ordering of LocalDate can be used)
        Comparator<LocalDate> dateComparator = Comparator.naturalOrder();

        // Using Stream API to find the earliest (min) and latest (max) dates
        LocalDate earliest = dates.stream()
                .min(dateComparator)  // Get the earliest date
                .orElse(null);        // Return null if the list is empty

        LocalDate latest = dates.stream()
                .max(dateComparator)  // Get the latest date
                .orElse(null);         // Return null if the list is empty

        // Returning both dates in a map
        Map<String, LocalDate> result = new HashMap<>();
        result.put("Earliest", earliest);
        result.put("Latest", latest);

        return result;
    }

    public static void main(String[] args) {
        // Sample list of dates
        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2023, 5, 10),
                LocalDate.of(2021, 3, 15),
                LocalDate.of(2022, 7, 25),
                LocalDate.of(2023, 1, 1),
                LocalDate.of(2020, 8, 5)
        );

        // Find the earliest and latest date
        Map<String, LocalDate> result = findEarliestAndLatest(dates);

        // Output the result
        System.out.println("Earliest Date: " + result.get("Earliest"));
        System.out.println("Latest Date: " + result.get("Latest"));
    }
}

