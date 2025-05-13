package EventTicketBookingSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class EventBookingSystem {
	private List<Attendee> attendees;
	private List<Organizer> organizers;
	private List<Event> events;
	private List<Ticket> tickets;
	
	public EventBookingSystem() {
		attendees = new ArrayList<Attendee>();
		organizers = new ArrayList<Organizer>();
		events = new ArrayList<Event>();
		tickets = new ArrayList<Ticket>();
	}
	
	void registerUser(User user) {
		if (user instanceof Attendee) 
			attendees.add((Attendee) user);
        else if (user instanceof Organizer)
        	organizers.add((Organizer) user);
	}
	
	void addEvent(Event e) {
		events.add(e);
	}
	
	void bookTicket(String attendeeId, String eventTitle) throws InvalidBookingException {
		Attendee attendee = attendees.stream().filter(a -> a.id.equals(attendeeId)).findFirst().orElse(null);
        Event event = events.stream().filter(e -> e.getTitel().equalsIgnoreCase(eventTitle)).findFirst().orElse(null);

        if (attendee == null || event == null || !event.isAvailable()) {
            throw new InvalidBookingException("Invalid booking request. Register First");
        }

        event.setAvailableTickets(event.getAvailableTickets() - 1);
        Ticket ticket = new Ticket(attendee, event);
        tickets.add(ticket);
        System.out.println("Ticket booked successfully!");
	}
	
	public void saveEvents() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\UDAY SANKAR\\Desktop\\CASESTUDY\\events.txt"))) {
            for (Event event : events) {
                writer.write(event.getTitel() + "," + event.getAvailableTickets());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving event: " + e.getMessage());
        }
    }
	
	public void loadEvents() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\UDAY SANKAR\\Desktop\\CASESTUDY\\events.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String title = parts[0];
                    int availableTickets = Integer.parseInt(parts[1]);
                    Event event = new Event(title, availableTickets);
                    addEvent(event);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading events: " + e.getMessage());
        }
    }
	
	void showEvents() {
		for (Event event: events) {
			System.out.println("Event Name:" +event.getTitel()+"\t"+"Available Tickets: "+event.getAvailableTickets());
		}
	}

}
 