import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<Employee>();

        employees.add(new Employee("Leila", "Hussein", 6730, 30));
        employees.add(new Employee("Marjan", "Abdalla", 5893, 72));
        employees.add(new Employee("Sofiya", "Nzau", 4923, 47));
        employees.add(new Employee("Coi", "Leray", 4028, 58));

        Collections.sort(employees);

        System.out.println("---Employee List---");
        for (Employee employee : employees){
            System.out.println(employee);
        }
    }
}


/*
Project 2: Employee Management System (Using Comparable)
Goal: Create an employee management system that sorts employees based on a natural order (e.g., employee ID or last name).

Details:
The system should store each employee’s details: employee ID, first name, last name, and salary.
Since employee ID is unique, it will serve as the primary sorting criterion to ensure consistent ordering.
In this project, you’ll implement the natural ordering with Comparable.

Algorithm:

Define an Employee Class: Create an Employee class with attributes employeeId, firstName, lastName, and salary.

Implement Comparable:

Implement the Comparable<Employee> interface in the Employee class.
Define the compareTo method to compare employees based on employeeId as the natural ordering criterion.
If you wish to sort by lastName as an alternative natural order, you could define that instead.
Populate the Employee List:

Create a list of Employee objects and add multiple employees with different employeeId values.
Sort by Natural Order:

Use Collections.sort() directly on the list. Since Employee implements Comparable,
this method will use the compareTo implementation to sort the employees by employeeId.
Display the Sorted Employee List: Print the sorted list to verify the correct order by employeeId.
*/