package Report;

// Manager class inheriting from Employee
public class Manager extends Employee {
    private String department;

    public Manager(int id, String name, double salary, String department) {
        super(id, name, salary);
        this.department = department;
    }

    // Method to display manager details including inherited details
    @Override
    public void displayDetails() {
        super.displayDetails(); // Calling superclass method
        System.out.println("Manager Department: " + department);
    }

    @Override
    public double calculatePay() {
        // More complex implementation for manager pay calculation
        return getSalary() / 12 + 1000; // Monthly salary + bonus
    }
}
