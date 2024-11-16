import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;

public class ToDoApp {
    public static void main(String[] args) {
        String fileName = "tasks.txt";
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("\n To-Do List Options: ");
            System.out.println("1. Add a task");
            System.out.println("2. View tasks");
            System.out.println("3. Clear all tasks");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Enter a task: ");
                    String task = scanner.nextLine();

                    try(FileWriter writer = new FileWriter (fileName, true)){
                        writer.write(task + "\n");
                        System.out.println("Task added successfully!");
                    }
                    catch(IOException e){
                        System.out.println("Error adding task.");
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    File file = new File(fileName);
                    if(file.exists()){
                        try {
                            Scanner fileReader = new Scanner(file);

                            System.out.println("\n Your tasks: ");
                            while (fileReader.hasNextLine()){
                                System.out.println("- " + fileReader.nextLine());
                            }
                        }
                        catch (FileNotFoundException e){
                            System.out.println("Error reading tasks!");
                            e.printStackTrace();
                        }
                    }
                    else{
                        System.out.println("No tasks found.");
                    }
                    break;

                case 3:
                    //Clear tasks
                    File fileToDelete = new File(fileName);
                    if (fileToDelete.exists() && fileToDelete.delete()){
                        System.out.println("All tasks cleared!");
                    }
                    else{
                        System.out.println("No tasks to clear.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
