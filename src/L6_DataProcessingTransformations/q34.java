package L6_DataProcessingTransformations;

import java.util.*;
import java.util.stream.*;

public class q34 {
    private String name;
    private String department;

    public q34(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public static void main(String[] args) {
        List<q34> employees = Arrays.asList(
                new q34("Alice", "HR"),
                new q34("Bob", "Engineering"),
                new q34("Charlie", "HR"),
                new q34("David", "Engineering"),
                new q34("Eve", "Sales")
        );

        Map<String, Long> departmentCount = employees.stream()
                .collect(Collectors.groupingBy(q34::getDepartment, Collectors.counting()));

        departmentCount.forEach((department, count) ->
                System.out.println("Department: " + department + ", Number of Employees: " + count));
    }
}

