import java.util.Random;
import java.util.Scanner;

public class RandomPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:,.<>?/";

        while(true){
            System.out.println("This a Random Password Generator.");
            System.out.print("Enter the desired password length: ");
            int passwordLength = scanner.nextInt();
            scanner.nextLine();

            StringBuilder charPool = new StringBuilder();
            charPool.append(lowercase).append(uppercase).append(numbers).append(specialChars);

            String password = generatePassword(charPool.toString(), passwordLength);
            System.out.println("Generated password: " + password);

            System.out.print("Generate another password? (yes/no): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("yes")){
                System.out.println("Okay....byee!");
                break;
            }
        }
        scanner.close();
    }

    //Method to generate password
    public static String generatePassword(String charPool, int length){
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++){
            int randomIndex = random.nextInt(charPool.length());//explain this line
            password.append(charPool.charAt(randomIndex));
        }

        return password.toString();
    }
}
