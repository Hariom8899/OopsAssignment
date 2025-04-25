package q5_EmpPayrolSysAbstraction;

public abstract class Employee {
    protected String name;
    protected int id;

    // Constructor to initialize the common fields for all employees
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Abstract method to calculate salary, to be implemented by subclasses
    public abstract double calculateSalary();

    // Abstract method to get employee details, to be implemented by subclasses
    public abstract void getDetails();
}

