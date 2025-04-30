package q3_DepartmentDireSortEmp;
import java.util.*;

class Employee {
    String department, name;
    double salary;
    Employee(String dep, double salary, String name){
        this.department = dep;
        this.salary = salary;
        this.name = name;
    }
    String getDepartment(){
        return department;
    }
    double getSalary(){
        return salary;
    }
}

public class Solve{
    public  static void main(String[] strs) {
        Map<String, List<Employee>> depMap = new HashMap<>();
        Employee e1 = new Employee("HR", 50000, "Alice");
        Employee e2 = new Employee("IT", 60000, "Bob");
        Employee e3 = new Employee("HR", 55000, "Charlie");
        Employee e4 = new Employee("IT", 70000, "David");
        Employee e5 = new Employee("Finance", 65000, "Eve");
        Employee e6 = new Employee("Finance", 62000, "Frank");
        Employee e7 = new Employee("HR", 48000, "Grace");
        Employee e8 = new Employee("IT", 75000, "Henry");
        Employee e9 = new Employee("Finance", 54000, "Ivy");
        Employee e10 = new Employee("IT", 58000, "Jack");

        insertInMap(e1, depMap);
        insertInMap(e2, depMap);
        insertInMap(e3, depMap);
        insertInMap(e4, depMap);
        insertInMap(e5, depMap);
        insertInMap(e6, depMap);
        insertInMap(e7, depMap);
        insertInMap(e8, depMap);
        insertInMap(e9, depMap);
        insertInMap(e10, depMap);

        depMap.entrySet().stream()
                .forEach(entry -> {
                    String Dep = entry.getKey();

                    Employee highestPaidEmployee = entry.getValue().stream()
                            .reduce((a, b) -> a.getSalary() > b.getSalary() ? a : b)
                            .orElse(null);

                    if (highestPaidEmployee != null) {
                        System.out.println("Highest Paid Employee of " + Dep + " Salary: " + highestPaidEmployee.getSalary());
                    }
                });
    }

    static void insertInMap(Employee emp, Map<String, List<Employee>> m){
        m.computeIfAbsent(emp.department, (k) -> new ArrayList<>()).add(emp);
    }
}
