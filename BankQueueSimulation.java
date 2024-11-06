import java.util.PriorityQueue;
import java.util.Random;

class Customer implements Comparable<Customer> { // Defines sorting by priority
    int id;
    String type;
    int priority;
    int serviceTime;

    public Customer(int id, String type, int priority, int serviceTime) {
        this.id = id;
        this.type = type;
        this.priority = priority;
        this.serviceTime = serviceTime;
    }

    @Override
    public int compareTo(Customer other) {
        return Integer.compare(other.priority, this.priority); // Higher priority customers come first
    }

    @Override
    public String toString() {
        return "Customer " + id + " (" + type + "), Priority: " + priority + ", Service time: " + serviceTime + "s";
    }
}

public class BankQueueSimulation {
    public static void main(String[] args) {
        PriorityQueue<Customer> queue = new PriorityQueue<>();
        Random rand = new Random();

        System.out.println("Welcome to the Bank Queue System!\n");

        // Adding customers to the queue with unique IDs and random attributes
        for (int i = 1; i <= 10; i++) {
            String type;
            int priority;

            switch (rand.nextInt(3)) {
                case 0:
                    type = "VIP";
                    priority = 3;
                    break;
                case 1:
                    type = "Regular";
                    priority = 2;
                    break;
                default:
                    type = "Newcomer";
                    priority = 1;
                    break;
            }

            int serviceTime = rand.nextInt(5) + 1; // Random service time between 1 and 5 seconds
            Customer newCustomer = new Customer(i, type, priority, serviceTime);
            queue.offer(newCustomer);
            System.out.println("Added to queue: " + newCustomer);
        }

        System.out.println("\n--- Serving Customers ---");

        // Serving each customer in priority order
        while (!queue.isEmpty()) {
            Customer current = queue.poll();
            System.out.println("\nNow serving: " + current);

            // Simulate serving time
            try {
                Thread.sleep(current.serviceTime * 1000);
            } catch (InterruptedException e) {
                System.out.println("Service interrupted for " + current);
            }

            // Display the next customer in line if there are more in the queue
            if (!queue.isEmpty()) {
                System.out.println("Next in line: " + queue.peek());
            }
        }

        System.out.println("\nAll customers have been served. Thank you for visiting the bank!");
    }
}
