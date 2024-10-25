import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class EmailValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        String emailRegex = "^[\\w-\\.]+@[\\w-\\.]+\\.[a-zA-Z]{2,7}$";
        String nameRegex = "^[A-Za-z]+([\\s\\-'][A-Za-z]+)*$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);

        Pattern namePattern = Pattern.compile(nameRegex);
        Matcher nameMatcher = namePattern.matcher(name);

        if (nameMatcher.matches() && emailMatcher.matches()){
            System.out.println("Valid credentials , you may proceed.");
        }else{
            if (!nameMatcher.matches()){
                System.out.println("Invalid name format.");
            }
            else if(!emailMatcher.matches()){
                System.out.println("Invalid email format.");
            }
        }
        scanner.close();
    }
}

