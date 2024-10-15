/*
Project: Daily Journal Reminder

Objective: Create a program that sends reminders to the user to write their daily journal. It will take the current date and time and format it nicely to prompt the user to reflect on their day at exactly 9:00 PM every day.

Pseudocode:
Get the current date using LocalDate.now().
Set the time to 21:00:00 (9:00 PM) using LocalTime.of(21, 0).
Combine the date and time into LocalDateTime.
Format the date and time in a user-friendly format using DateTimeFormatter.
Display the message: "It's 9:00 PM on [date]. Time to write in your journal!"

START
    Get the current date
    Set time to 9:00 PM
    Combine date and time into LocalDateTime
    Format date and time
    Display reminder message
END

 */

