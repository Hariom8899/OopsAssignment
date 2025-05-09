package L6_DataProcessingTransformations;
//Calculate the average salary of employees in each department using Collectors.groupingBy() and averagingDouble().
import java.util.*;
import java.util.stream.*;

public class q35 {
    private String name;
    private String department;
    private double salary;

    public q35(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double getSalary(){
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public static void main(String[] args) {
        List<q35> employees = Arrays.asList(
                new q35("Alice", "HR", 10000),
                new q35("Bob", "Engineering", 56000),
                new q35("Charlie", "HR", 100300),
                new q35("David", "Engineering", 230050),
                new q35("Eve", "Sales", 45500)
        );

        Map<String, Double> departmentCount = employees.stream()
                .collect(Collectors.groupingBy(q35::getDepartment, Collectors.averagingDouble(q35::getSalary)));

        departmentCount.forEach((department, avgSalary) ->
                System.out.println("Department : " + department + " AvgSalary : " + avgSalary));
    }
}



