package entities;

import java.time.LocalDate;

public class Time extends Entity {

	
	// *****************************************
	// Constructor
	// *****************************************
	public Time() {
		super();
	}
	
	public Time(String id, String name) {
		super(id, name);
	}
	
	public Time(String id, String name, String description) {
		super(id, name, description);
	}
	
	public Time(String id, String name, String description, String link, LocalDate date) {
		super(id, name, description, link, date);
	}

	

	
	
}
