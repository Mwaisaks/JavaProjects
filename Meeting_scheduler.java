/*
 Project: Meeting Scheduler
Objective: Create a program that calculates the date and time for a future meeting based on the user's input.
The user should input the current date, time, and the number of days until the meeting. 
The program should display the scheduled meeting date and time in a user-friendly format.

Pseudocode:
Get the current date and time from the user.
Get the number of days until the meeting.
Add the number of days to the current date using LocalDateTime.plusDays().
Format the meeting date and time using DateTimeFormatter.
Display the formatted meeting date and time.

START
    Prompt user for current date and time
    Prompt user for number of days until the meeting
    Add the number of days to current date
    Format the new date and time
    Display the formatted meeting date and time
END

 */

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

        if (response.equalsIgnoreCase("Yes")){
            System.out.println("Enter the number of days to the meeting(e.g. 2,3..): ");
            days = input.nextInt();
            input.nextLine();

            System.out.println("What time will the meeting be?(24-hour format hh:mm) ");
            time = input.nextLine();

            //Splitting the time input into hour and minute
            String[] timeparts = time.split(":");
            int hour = Integer.parseInt(timeparts[0]);
            int minute = Integer.parseInt(timeparts[1]);

            if(hour<0 || hour>23 || minute<0 || minute>59){
                System.out.println("Invalid time entered. Please try again.");
            } 
            else {
                LocalDateTime meetingDate = currDateTime.plusDays(days).withHour(hour).withMinute(minute);

                System.out.println("Your meeting is scheduled for " + formatter.format(meetingDate));
            }
        }
        else{
            System.out.println("Have a nice day ahead!");
        }

        input.close();

    }
}