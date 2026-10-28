import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
public class HelpDeskTicketQueue {
    public static void main(String[] args) {
        Deque<String> tickets = new ArrayDeque<>();
        Deque<String> resolvedTickets = new ArrayDeque<>();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println("\n1. New ticket  2. Next (serve)  3. Peek  4. Count  5. Undo  0. Exit");
                System.out.print("Please choose an option: ");
                String choice = scanner.nextLine().trim();
                switch (choice) {
                    case "1":
                        System.out.print("Please enter ticket description: ");
                        String ticket = scanner.nextLine().trim();
                        if (ticket.isEmpty()) {
                            System.out.println("Silly goose, the ticket description cannot be empty.");
                        } else {
                            tickets.addLast(ticket);
                            System.out.println("Ticket added successfully!");
                        }
                        break;
                    case "2":
                        if (tickets.isEmpty()) {
                            System.out.println("There isn't anything to serve.");
                        } else {
                            String served = tickets.removeFirst();
                            resolvedTickets.push(served);
                            System.out.println("Resolved: " + served);
                        }
                        break;
                    case "3":
                        System.out.println(tickets.isEmpty()
                                ? "The ticket queue is currently empty."
                                : "Next ticket: " + tickets.peekFirst());
                        break;
                    case "4":
                        System.out.println("Tickets waiting: " + tickets.size());
                        break;
                    case "5":
                        if (resolvedTickets.isEmpty()) {
                            System.out.println("There are no resolved tickets to undo.");
                        } else {
                            String reopened = resolvedTickets.pop();
                            tickets.addFirst(reopened);
                            System.out.println("Reopened: " + reopened);
                        }
                        break;
                    case "0":
                        running = false;
                        break;
                    default:
                        System.out.println("This option is invalid, please try again.");
                }
            }
        }
    }
}