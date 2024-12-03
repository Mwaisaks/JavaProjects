public class TicketBookingSystem {
    private int availableTickets = 10;

    public synchronized void bookTicket(String userName){
        if (availableTickets > 0){
            System.out.println(userName + " booked 1 ticket. Tickets left: " + (availableTickets - 1));
            availableTickets--;
        }
        else {
            System.out.println(userName + " tried to book, but tickets are sold out.");
        }
    }

    public static void main(String[] args){
        TicketBookingSystem bookingSystem = new TicketBookingSystem();

        Runnable userTask = () -> {
            String userName = Thread.currentThread().getName()
        }
    }
}
