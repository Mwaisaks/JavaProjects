import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


//Contact Class to hold the details of each contact
class Contact implements Comparable<Contact>{
    //Comparable interface provides compareTo() method which defines how two objects(contacts)
    //should be compared for sorting purposes.
    //variable declaration
    private String name;
    private String email;
    private String phoneNo;

    //constructor
    Contact(String name, String email, String phoneNo){
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    //Getters and Setters
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhoneNo(){
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo){
        this.phoneNo = phoneNo;
    }

    //Overriding compareTo method to sort by name
    @Override
    public int compareTo(Contact other){
        return this.name.compareToIgnoreCase(other.name);
    }

    //Overriding toString method to display contact details
    @Override
    public String toString(){
        return "Name: "+ name + ", Phone: "+ phoneNo + ", Email: " + email;
    }
}

//main class to manage contacts
public class ContactManager{
    //create the objects of arrayList and Scanner class
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            //display options
            System.out.println("\n----Contact Manager----");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. Edit Contact");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Quit");
            System.out.print("Choose an Option: ");
            //accept userinput
            int option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 1:
                addContact();
                break;

                case 2:
                removeContact();
                break;

                case 3:
                searchContact();
                break;

                case 4: 
                editContact();
                break;

                case 5:
                displayContacts();
                break;

                case 6:
                quit = true;
                break;

                default:
                System.out.println("Invalid option. Try again.");
            }
        }
    }

    //method to add new contact
    public static void addContact(){
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the email: ");
        String email = scanner.nextLine();

        System.out.print("Enter the phone Number: ");
        String phoneNo = scanner.nextLine();

        contacts.add(new Contact(name, phoneNo, email));
        System.out.println("Contact added successfully.");
    }

    //method to remove a contact by name
    public static void removeContact(){
        System.out.print("Enter the name of the contact to remove: ");
        String name = scanner.nextLine();
        Contact contact = findContactByName(name);

        if (contact != null){
            contacts.remove(contact);
            System.out.println("Contact removed successfully");
        }
        else{
            System.out.println("Contact not found.");
        }
    }

    //method to search a contact by name
    public static void searchContact(){
        System.out.print("Enter the name of the contact to search: ");
        String name = scanner.nextLine();
        Contact contact = findContactByName(name);

        if (contact != null){
            System.out.println("Contact: " + contact);
        }
        else{
            System.out.println("Contact not found.");
        }
    }

    //method to edit a contact's details
    public static void editContact(){
        System.out.print("Enter the name of the contact to be edited: ");
        String name = scanner.nextLine();
        Contact contact = findContactByName(name);
        if (contact != null){
            System.out.print("Enter the new phone number: ");
            String newPhoneNo = scanner.nextLine();

            if (!newPhoneNo.isEmpty()){
                contact.setPhoneNo(newPhoneNo);
            }

            System.out.print("Enter the new email: ");
            String newEmail = scanner.nextLine();

            if (!newEmail.isEmpty()){
                contact.setEmail(newEmail);
            }

            System.out.println("Contact updated successfully!");
        }
        else{
            System.out.println("Contact not found.");
        }
    }

    //method to display all contacts sorted by name
    public static void displayContacts(){
        if (contacts.isEmpty()){
            System.out.println("No contacts available!");
        }
        else{
            Collections.sort(contacts);
            System.out.println("\n---All Contacts---");
            for (Contact contact : contacts){
                System.out.println(contact);
            }
        }
    }

    //helper method to find a contact by name
    public static Contact findContactByName(String name){
        for (Contact contact : contacts){
            if (contact.getName().equalsIgnoreCase(name)){
                return contact;
            }
        }
        return null;
    }
}

/*
 * 1. Task: Contact Manager

Goal: Implement a simple contact manager using ArrayList. 
Each contact will have a name, phone number, and email address.
Steps:

Create a class Contact with attributes name, phoneNumber, and email.
Use an ArrayList<Contact> to store the contacts.
Implement methods to:
Add a new contact.
Remove a contact by name.
Search for a contact by name.
Edit an existing contact’s details.
Print all contacts in alphabetical order (use Collections.sort()).
Bonus: Add functionality to save the contact list to a file and read it back (using Java I/O).

 */

/* 
public class Contact{
        String name;
        String email;
        int phoneNo;

        public Contact(String name,String email, int phoneNo){
            name = this.name;
            email = this.email;
            phoneNo = this.phoneNo;
        }

        ArrayList contacts = new ArrayList<Integer>();
        
        

        

}

 * So the main idea here was to create a class called contacts that will contain
 * all the methods and attributes of a contact.
 

public class Main{
    public static void main(String[] args) {
        System.out.println(contacts.size() + " contacts.");
        System.out.println("Welcome to Contacts.");
        System.out.println("How can we serve you today? ");
        System.out.println("1. Add new contact \\n" + //
                        "2. Delete a contact \\n" + //
                        "3. Search for a contact \\n" + //
                        "4. edit a contact \");");

        Scanner keyboard = new Scanner(System.in);

        int input = keyboard.nextLine();

        if (input == 1){
            System.out.println("Enter the name of the contact: ");

        }



    }
}*/
