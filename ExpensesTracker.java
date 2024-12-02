import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
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
        //if we initislised a Sacnner object here would it be the same as passing the scanner object as a parameter?
        try{
            FileWriter writer = new FileWriter(FILE_PATH, true);//what's the role of true here?
            LocalDate currentDate = LocalDate.now();
            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Enter description: ");
            String description = scanner.nextLine();

            String expenseRecord = currentDate + " | " + amount + " | " + description;
            writer.write(expenseRecord + "\n");

            System.out.println("Expense added successfully!");
        }
        catch (IOException e){
            System.out.println("Error writing to the file.");
            e.printStackTrace();
        }
    }

    private static void deleteSpecificExpense(Scanner scanner){
        File file = new File(FILE_PATH);

        if (!file.exists() || file.length() == 0){
            System.out.println("No expenses found. Please add some expenses first.");
            return;
        }

        //Shouldn't this part be in the addExpenses method
        ArrayList<String> expenses = new ArrayList<>();
        try {
            Scanner fileScannner = new Scanner(file);

            while (fileScannner.hasNextLine()){
                expenses.add(fileScannner.nextLine());
            }
        }
        catch (Exception e){
            System.out.println("Error reading the file.");
            e.printStackTrace();
            return;
        }

        //or we could just call the displayExpenses method
        //Display expenses with indices
        System.out.println("\n=== Current Expenses ===");
        for (int i = 0; i < expenses.size(); i++){
            System.out.println((i + 1) + ". " + expenses.get(i));
        }

        System.out.print("Enter the number of the expense to delete: ");
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= expenses.size()){
            System.out.println("Invalid index. No expense deleted.");
            return;
        }
        expenses.remove(index);

        //Rewrite the file
        //You mean it's not going to adjust itself after deletion?
        try{
            FileWriter writer = new FileWriter(FILE_PATH);

            for(String expense : expenses){
                writer.write(expense + "/n");
            }
            System.out.println("Expense deleted successfully!");
        }
        catch (IOException e){
            System.out.println("Error writing to the file.");
            e.printStackTrace();
        }
    }

    private static void deleteAllExpenses(){
        File file = new File(FILE_PATH);

        if(file.delete()){
            ensureFileExists();
            System.out.println("All expenses have been deleted.");
        }
        else {
            System.out.println("Error deleting the expenses.");
        }

        //how about this version of the if-statement above
        if (file.exists()){
            file.delete();
            System.out.println("All expenses have been deleted.");
        }
        else {
            System.out.println("Error deleting the expenses!");
        }
    }
}
