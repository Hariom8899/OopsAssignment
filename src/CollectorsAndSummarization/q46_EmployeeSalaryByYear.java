package CollectorsAndSummarization;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int joiningYear;
    private double salary;

    public Employee(String name, int joiningYear, double salary) {
        this.name = name;
        this.joiningYear = joiningYear;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getJoiningYear() {
        return joiningYear;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " (" + joiningYear + ") - $" + salary;
    }
}

public class q46_EmployeeSalaryByYear {

    public static void main(String[] args) {
        // Sample list of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 2015, 50000),
                new Employee("Bob", 2015, 55000),
                new Employee("Charlie", 2016, 60000),
                new Employee("David", 2016, 75000),
                new Employee("Eve", 2017, 80000),
                new Employee("Frank", 2017, 65000)
        );

        // Group employees by their joining year and find the max salary in each year
        Map<Integer, Optional<Employee>> maxSalaryByYear = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getJoiningYear, // Group by joining year
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)) // Find the max salary in each year
                ));

        // Print the max salary for each year
        maxSalaryByYear.forEach((year, employeeOpt) -> {
            employeeOpt.ifPresent(employee -> {
                System.out.println("Year: " + year + ", Max Salary: " + employee);
            });
        });
    }
}

