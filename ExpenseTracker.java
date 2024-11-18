import java.io.File;
import java.util.Scanner;

public class ExpenseTracker {
    private static final String FILE_PATH = "expenses.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ensureFileExists();
        System.out.println("\n === Welcome to the Expense Tracker ===");
        displayExpenses();

        do {
            System.out.println("\nChoose an action: ");
            System.out.println("1. Add a new expense");
            System.out.println("2. Delete an expense");
            System.out.println("3. Delete all expenses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch(choice){
                case 1 -> addExpemse(scanner);
                case 2 -> deleteSpecificExpense(scanner);
                case 3 -> deleteAllExpenses();
                case 4 -> System.out.println("Exiting... \n Thank you for using the Expense Tracker!");
            }
        }
        while (choice != 4);
    }

    private static void ensureFileExists(){
        File file = new File(FILE_PATH);

        try {
            if (file.createNewFile()){

            }
        }
    }
}
