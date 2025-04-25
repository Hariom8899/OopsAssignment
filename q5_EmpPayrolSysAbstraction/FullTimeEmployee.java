package q5_EmpPayrolSysAbstraction;

public class FullTimeEmployee extends Employee {
    private double monthlySalary;

    // Constructor to initialize FullTimeEmployee with name, id, and monthly salary
    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public void getDetails() {
        System.out.println("Full-time Employee: " + name + " (ID: " + id + ")");
        System.out.println("Monthly Salary: $" + monthlySalary);
    }
}

