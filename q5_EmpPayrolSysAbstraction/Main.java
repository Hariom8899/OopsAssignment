package q5_EmpPayrolSysAbstraction;

public class Main {
    public static void main(String[] args) {
        // Create an array of Employee objects
        Employee[] employees = new Employee[2];

        // Create FullTimeEmployee and Freelancer objects and store them in the array
        employees[0] = new FullTimeEmployee("Alice", 101, 5000);
        employees[1] = new Freelancer("Bob", 102, 50, 120);

        // Loop through the array and call getDetails() for each employee
        for (Employee employee : employees) {
            employee.getDetails();
            System.out.println("Salary: $" + employee.calculateSalary());
            System.out.println();
        }
    }
}

