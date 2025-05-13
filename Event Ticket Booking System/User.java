package eventTicketBookingSystem;

public abstract class User {
	protected String id;
	protected String name;
	public User(String id, String name) {
		this.id=id;
		this.name=name;
	}
	public abstract void showProfile();
}
