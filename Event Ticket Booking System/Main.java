package EventTicketBookingSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EventBookingSystem eventbookingsystem = new EventBookingSystem();
        Scanner scanner = new Scanner(System.in);

        eventbookingsystem.loadEvents();

        while (true) {
            System.out.println("\n1. Register Attendee");
            System.out.println("\n2. Add Event");
            System.out.println("\n3. Book Ticket");
            System.out.println("\n4. Show Events");
            System.out.println("\n5. Save & Exit");
            System.out.print("Enter your Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        eventbookingsystem.registerUser(new Attendee(id, name));
                        System.out.println("Attendee registered.");
                        break;
                    
                    case 2:
                        System.out.print("Enter Event Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Available Tickets: ");
                        int tickets = scanner.nextInt();
                        eventbookingsystem.addEvent(new Event(title, tickets));
                        System.out.println("Event added.");
                        break;
                    
                    case 3:
                        System.out.print("Enter Attendee ID: ");
                        String id1 = scanner.nextLine();
                        System.out.print("Enter Event Title: ");
                        String title1 = scanner.nextLine();
                        eventbookingsystem.bookTicket(id1, title1);
                        break;
                    
                    case 4:
                    	eventbookingsystem.showEvents();
                    	break;
                    	
                    case 5:
                    	eventbookingsystem.saveEvents();
                        System.out.println("Events saved. Exiting...");
                        System.exit(0);
                        
                    default:
                    	System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}