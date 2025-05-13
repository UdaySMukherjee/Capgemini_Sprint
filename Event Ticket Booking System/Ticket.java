package eventTicketBookingSystem;

public class Ticket {
	private Attendee attendee;
	private Event event;
	private String status;
	public Ticket(Attendee attendee,Event event, String status) {
		this.attendee=attendee;
		this.event=event;
		this.status="Booked";
	}
	void cancel() {
		this.status="Cancelled";
	}
	String getStatus() {
		return this.status;
	}
	String ticketDetails() {
		return "Event Titel: \t"+this.event.titel+"Attendee Name: \t"+this.attendee.name+"Status \t"+this.status;
	}
}
