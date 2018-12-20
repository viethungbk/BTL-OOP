package entities;

import java.time.LocalDate;

public class Country extends Entity {

	// *****************************************
	// Constructor
	// *****************************************
	public Country() {
		super();
	}

	public Country(String id, String name) {
		super(id, name);
	}	

	public Country(String id, String name, String description) {
		super(id, name, description);
	}
	
	public Country(String id, String name, String description, String link, LocalDate date) {
		super(id, name, description, link, date);
	}
	
}
