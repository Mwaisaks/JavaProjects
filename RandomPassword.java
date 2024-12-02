import java.util.Scanner;

public class RandomPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:,.<>?/";

        while(){
            System.out.println("This a Random Password Generator.");
            System.out.print("Enter the desired password length: ");
            int length = scanner.nextInt();
            System.out.println("Generating a password...");
            System.out.print("I've included numbers, special characters, uppercase and lowercase letters");
            System.out.println("Generated Password: " + password);
        }
    }
}
