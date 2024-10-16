import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Meeting_scheduler {
    public static void main(String[] args) {
        String response;
        int days;
        String time;

        //Display the date and time
        LocalDateTime currDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E ,MMM dd yyyy h:mm a");
        System.out.println(formatter.format(currDateTime));

        Scanner input = new Scanner(System.in);

        System.out.println("Would you like to schedule a meeting? (Yes/No)");
        response = input.nextLine();

        if (response == "Yes"){//you can still use response.equals("Yes")
            System.out.println("Enter the number of days to the meeting(e.g. 2,3..): ");
            days = input.nextInt();

            System.out.println("What time will the meeting be?(24-hour format hh:mm) ");
            time = input.nextLine();

            LocalDateTime meetingDate = currDateTime.plusDays(days);

            System.out.println("Your meeting is scheduled for " + formatter.format(meetingDate) + time);
        }
        else{
            System.out.println("Have a nice day ahead!");
        }

    }
}