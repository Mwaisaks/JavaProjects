import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ExpensesTracker {
    private static final String FILE_PATH = "Expenses.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ensureFileExists();

        //Display current expenses and total when the program starts
        System.out.println("\n === Welcome to the Expense Tracker ===");
        displayExpenses();
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
        File file = new File(FILE_PATH){
            File file = new File(FILE_PATH);
            if
        }
    }
}
