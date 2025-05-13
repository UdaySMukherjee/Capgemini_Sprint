package eventTicketBookingSystem;

public class Organizer extends User{
	
	public Organizer(String id, String name) {
		super(id, name);
	}
	
	boolean active=true;
	boolean isActive() {
		return this.active;
	}
	void setActive(boolean active) {
		this.active=active;
	}
	@Override
	public void showProfile() {
		System.out.println("Event ID: "+this.id+" Event name: "+"Is Event Active: "+this.active);
	}
}
