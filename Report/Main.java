package Report;


public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "John Doe", 50000);
        Manager manager1 = new Manager(2, "Jane Smith", 80000, "Finance");

        // Polymorphic behavior
        emp1.displayDetails(); // Employee's details
        System.out.println();
        manager1.displayDetails(); // Manager's overrides displayDetails

        // Using polymorphism with Payable interface
        System.out.println("\nEmployee Monthly Pay: $" + emp1.calculatePay());
        System.out.println("Manager Monthly Pay: $" + manager1.calculatePay());
    }
}
