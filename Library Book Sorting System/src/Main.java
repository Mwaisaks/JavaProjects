import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void displayBooks(ArrayList<Book> books){
        System.out.println("\n ---Book List---");
        
        for (Book book : books){
            System.out.println(book);
        }
    }
        
    public static void main(String[] args) {
        Comparator<Book> titleComparator = new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.title.compareTo(book2.title);
            }
        };

        Comparator<Book> authorcomparator = new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.author.compareTo(book2.author);
            }
        };

        Comparator<Book> yearComparator = new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.publicationYear - book2.publicationYear;
            }
        };

        Comparator<Book> pageComparator = new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                return book1.pageCount - book2.pageCount;
            }
        };

        ArrayList<Book> books = new ArrayList<Book>();

        books.add(new Book("Laws of Human Nature", "RobertGreene", 2018, 624));
        books.add(new Book("Ho Tactics", "G.L Lambert", 2014, 285 ));
        books.add(new Book("The Art of Seduction", "Robert Greene", 2001, 496));
        books.add(new Book("Girls Just Wanna Have Funds: A Feminist's Guide to Investing", "Maree Higgins", 2023, 224));
        books.add(new Book("Jokes to Offend Men", "Anneliese Mackintosh", 2023, 208));
        books.add(new Book("Why Men Love Bitches: From Doormat to Dreamgirl—A Woman's Guide to Holding Her Own in a Relationship", "Sherry Argov", 2002, 255));
        books.add(new Book("Love Your Imposter: Be Your Best Self, Flaws and All", "Rita Clifton", 2020, 288));

        Scanner scanner = new Scanner(System.in);

        boolean running = true; //Control flag for the loop

        while(running){
            System.out.println("\n ---Book Sorting---");
            System.out.println("Sort books by: \n1. Title \n2. Author \n3. Publication Year \n4. Page Count \n5. Exit");

            System.out.print("Choose an option: ");
            int input = scanner.nextInt();
            scanner.nextLine();

            switch (input){
                case 1:
                    System.out.println("Sorted by Title: ");
                    Collections.sort(books, titleComparator);
                    displayBooks(books);
                    break;
                case 2:
                    System.out.println("Sorted by Author: ");
                    Collections.sort(books, authorcomparator);
                    displayBooks(books);
                    break;
                case 3:
                    System.out.println("Sorted by Publication Year: ");
                    Collections.sort(books, yearComparator);
                    displayBooks(books);
                    break;
                case 4:
                    System.out.println("Sorted by Page Count: ");
                    Collections.sort(books, pageComparator);
                    displayBooks(books);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    running = false; //set flag to exit the loop
                    break;
                default:
                    System.out.println("Invalid input! Please try Again :) ");

            }
        }

        scanner.close();
    }
}

