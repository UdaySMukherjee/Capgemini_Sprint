package EventTicketBookingSystem;

import java.util.Iterator;
import java.util.List;

@MyAnnotation(role = "Admin")
public class Admin extends User {
    public Admin(String id, String name) {
        super(id, name);
    }

    public void removeEvent(List<Event> events, String title) {
        Iterator<Event> iterator = events.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getTitel().equalsIgnoreCase(title)) {
                iterator.remove();
                System.out.println("Event removed: " + title);
                return;
            }
        }
        System.out.println("Event not found: " + title);
    }

    @Override
    public void showProfile() {
        System.out.println("Admin ID: " + id + "\t Name: " + name);
    }
}