package q8_EmployeeHierarchySys;

import java.util.*;

// Employee class
class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

// Manager class
class Manager {
    String name;

    public Manager(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Manager)) return false;
        Manager other = (Manager) obj;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}

// You can also use enum or int for levels; using int here
public class EmployeeHierarchy {
    public static void main(String[] args) {
        // Map: Manager -> TreeMap<Level, List<Employee>>
        Map<Manager, TreeMap<Integer, List<Employee>>> hierarchy = new HashMap<>();

        Manager alice = new Manager("Alice");
        Manager bob = new Manager("Bob");

        // Add employees under Alice
        addEmployee(hierarchy, alice, 1, new Employee("John"));
        addEmployee(hierarchy, alice, 2, new Employee("David"));
        addEmployee(hierarchy, alice, 1, new Employee("Sara"));

        // Add employees under Bob
        addEmployee(hierarchy, bob, 1, new Employee("Emma"));
        addEmployee(hierarchy, bob, 3, new Employee("Liam"));
        addEmployee(hierarchy, bob, 2, new Employee("Noah"));

        // Print hierarchy
        printHierarchy(hierarchy);
    }

    // Add employee to the manager’s level
    public static void addEmployee(Map<Manager, TreeMap<Integer, List<Employee>>> hierarchy,
                                   Manager manager, int level, Employee employee) {
        hierarchy
                .computeIfAbsent(manager, m -> new TreeMap<>())
                .computeIfAbsent(level, l -> new ArrayList<>())
                .add(employee);
    }

    // Print employees reporting to each manager by level
    public static void printHierarchy(Map<Manager, TreeMap<Integer, List<Employee>>> hierarchy) {
        for (Map.Entry<Manager, TreeMap<Integer, List<Employee>>> managerEntry : hierarchy.entrySet()) {
            Manager manager = managerEntry.getKey();
            TreeMap<Integer, List<Employee>> levels = managerEntry.getValue();

            System.out.println("Manager: " + manager);
            for (Map.Entry<Integer, List<Employee>> levelEntry : levels.entrySet()) {
                int level = levelEntry.getKey();
                List<Employee> employees = levelEntry.getValue();
                System.out.println("  Level " + level + ": " + employees);
            }
        }
    }
}
