package eventTicketBookingSystem;

public class Event {
	String titel;
	int availableTickets;
	
	public Event(String titel,int availableTickets) {
		this.titel=titel;
		setAvailableTickets(availableTickets);
	}
	void setAvailableTickets(int availableTickets) {
		this.availableTickets=availableTickets;
	}
	boolean isAvailable() {
		if(availableTickets>=1) {
			return true;
		}
		else {
			return false;
		}
	}
	public int getAvailableTickets() {
		return this.availableTickets;
	}
	
}
