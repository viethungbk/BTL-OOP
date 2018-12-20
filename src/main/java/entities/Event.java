package entities;

import java.time.LocalDate;

public class Event extends Entity {

	// *****************************************
	// Constructor
	// *****************************************
	public Event() {
		super();
	}
	
	public Event(String id, String name) {
		super(id, name);
	}
	
	public Event(String id, String name, String description) {
		super(id, name, description);
	}

	public Event(String id, String name, String description, String link, LocalDate date) {
		super(id, name, description, link, date);
	}
	
}
