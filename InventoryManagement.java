import java.util.*;

public class InventoryManagement {
    public static void main(String[] args) {
        HashMap<String, Integer>  inventory = new HashMap<>();
        LinkedList<String> itemList = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\n1.Add Item \n2.Update Stock \n3.Display Inventory \n4.Sort by Stock \n5.Exit ");
            //Why do you have to start with the backslash n?
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter item name: ");
                    scanner.nextLine(); //the consume newLine thing should be right after nextInt(), no?
                    String itemName = scanner.nextLine();
                    System.out.print("Enter initial stock: ");
                    int stock = scanner.nextInt();

                    try {
                        if (inventory.containsKey(itemName)){
                            throw new Exception("Item already exists");
                        }
                        inventory.put(itemName, stock);
                        itemList.add(itemName);
                        System.out.println("Item added successfully.");
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                        //returns the message string passed to the Exception when it was created.
                    }
                    break;

                case 2:
                    System.out.print("Enter item name to update: ");
                    scanner.nextLine(); //why is this necessary I thought it comes after integer user inputs
                    String updateItem = scanner.nextLine();
                    System.out.print("Enter new stock: ");
                    int newStock = scanner.nextInt();

                    try {
                        if (!inventory.containsKey(updateItem)){
                            throw new Exception("Item not found.");
                        }
                        inventory.put(updateItem, newStock);
                        System.out.println("Stock updated successfully");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        //what does e.getMessage() mean ?
                    }
                    break;
                
                case 3:
                    System.out.println("---Inventory List---");
                    Iterator<Map.Entry<String, Integer>> iterator = inventory.entrySet().iterator();
                    while (iterator.hasNext()){
                        Map.Entry<String, Integer> entry = iterator.next();
                        System.out.println("item: " + entry.getKey() + ", Stock: " + entry.getValue());
                    }
                    break;

                case 4:
                    //Sort itemList by stock quantity using Comparator
                    itemList.sort((item1, item2) -> inventory.get(item2).compareTo(inventory.get(item1)));
                    //Explain the previous line of code
                    System.out.println("Inventory sorted by stock level: ");
                    for (String item : itemList){
                        System.out.println("item: " + item + ", Stock: " + inventory.get(item));
                    }
                    break;

                case 5:
                    System.out.println("Exciting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}


/*Objective: Implement an inventory system that allows adding items, updating stock levels, displaying items, and sorting items by stock level. This project incorporates LinkedList, HashMap, Wrapper classes, Iterator, sorting, and exception handling.

Algorithm
Use a HashMap<String, Integer> where the key is the item name and the value is the stock quantity (using Integer as a wrapper class).
Use a LinkedList to store and update the items as they’re added.
Use an Iterator to loop through and display the items.
Add sorting functionality to sort items by stock quantity.
Handle exceptions, such as adding duplicate items or invalid operations.

 */


/*import java.util.*;

public class InventoryManagement {
    public static void main(String[] args) {
        HashMap <String, Integer> inventory = new HashMap<>();
        Scanner scanner = new Scanner(System.in);


        while(true){
            System.out.println("---Inventory Management System---");
            System.out.println("1.Add an Item. \n2.Update an item. \n3.Display Items \n4.Exit ");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter the name of the item: ");
                    String item = scanner.nextLine();
                    System.out.print("Enter the price for "+ item +" : ");
                    int itemPrice = scanner.nextInt();
                    scanner.nextLine(); //to consume the line

                    inventory.put(item, itemPrice);
                    System.out.println("Item added successfully!");
                    break;

                case 2:
                    for (String i : inventory.keySet()){
                        System.out.println( i + " : " +inventory.get(i));
                    }

                    //System.out.println();
                    System.out.println("Enter the name of the item to be updated: ");
                    item = scanner.nextLine();
                    inventory.get(item);

                    break;
            }
        }


        }
    }
*/

