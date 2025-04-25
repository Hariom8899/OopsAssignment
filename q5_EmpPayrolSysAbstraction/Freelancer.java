package q5_EmpPayrolSysAbstraction;

public class Freelancer extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    // Constructor to initialize Freelancer with name, id, hourly rate, and hours worked
    public Freelancer(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        // Freelancer salary is calculated based on hourly rate and hours worked
        return hourlyRate * hoursWorked;
    }

    @Override
    public void getDetails() {
        // Display details of freelancer
        System.out.println("Freelancer: " + name + " (ID: " + id + ")");
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}

