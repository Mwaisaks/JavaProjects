import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ExpensesTracker {
    private static final String FILE_PATH = "Expenses.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ensureFileExists();

        //Display current expenses and total when the program starts
        System.out.println("\n === Welcome to the Expense Tracker ===");
        displayExpenses();

        int choice;
        do {
            System.out.println("\nChoose an action:");
            System.out.println("1.Add a new expense");
            System.out.println("2. Delete a specific expense");
            System.out.println("3. Delete all expenses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1 -> addExpense(scanner);
                case 2 -> deleteSpecificExpense(scanner);
                case 3 -> deleteAllExpenses();
                case 4 -> System.out.println("Exiting...\nThank you for using the Expense Tracker!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        while(choice != 4);
    }

    //why do prefer to make the methods private?
    private static void ensureFileExists(){
        File file = new File(FILE_PATH);

        try {
            if (file.createNewFile()) {
                System.out.println("No previous records found a new expense file has been created.");
            }
        }
        catch(IOException e){
            System.out.println("Error creating the file.");
            e.printStackTrace();
        }
    }

    private static void displayExpenses(){
        File file = new File(FILE_PATH);

        if (!file.exists() || file.length() == 0){
            System.out.println("No expenses found. Please add some expenses.");
            return;
        }

        try{
            Scanner filescanner = new Scanner(file);

            double total = 0;
            System.out.println(("\n=== Current Expenses ==="));
            int index = 1;

            //how would this look like if we had a separate method(toString()) to format the output?
            while ( filescanner.hasNextLine()){
                String expense = filescanner.nextLine();
                System.out.println(index + ". " + expense);
                String[] parts = expense.split("\\|");
                total += Double.parseDouble(parts[1].trim());
                index++;
            }
            System.out.println("Total Expense : $" + total);
        }
        catch (Exception e){
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }

    private static void addExpense(Scanner scanner){
        try{
            FileWriter fileWriter = new FileWriter(FILE_PATH, true);//what's the role of true here?
            LocalDate
        }
    }
}
