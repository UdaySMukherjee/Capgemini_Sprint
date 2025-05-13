package EventTicketBookingSystem;

public class InvalidBookingException extends RuntimeException{
	public InvalidBookingException(String message) {
		super(message);
	}
}
