import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do{
            System.out.println("\n === Expense Tracker ===");
            System.out.println("1. Add a new expense");
            System.out.println("2. View all expenses");
            System.out.println("3. Calculate total expenses");
            System.out.println("4. Reset (delete all records");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> addExpense(scanner); //what kind of a syntax is this?
                case 2 -> viewExpenses();
                case 3 -> calculateTotal();
                case 4 -> resetExamples();
                case 5 -> System.out.println("Exiting...Thabk you for using the Expense Tracker!");
                default -> System.out.println("Invalid choice.Please try again");
            }
        }
    }
}
