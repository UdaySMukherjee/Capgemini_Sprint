package eventTicketBookingSystem;

public class Ticket {
	Attendee attendee;
	Event event;
	String status;
	public Ticket(Attendee attendee,Event event, String status) {
		attendee=this.attendee;
		event=this.event;
		this.status="Booked";
	}
	void cancel() {
		this.status="Cancelled";
	}
	String getStatus() {
		return this.status;
	}
	String ticketDetails() {
		return "Event Name: \t"+this.event.getName()+"Attendee NAme: \t"+this.attendee.getName()+"Status \t"+this.status;
	}
}
