package entities;

import java.time.LocalDate;

public class Location extends Entity {
	private String country;				// Đất nước mà địa điểm này thuộc về

	// *****************************************
	// Constructor
	// *****************************************
	public Location() {
		super();
	}

	public Location(String id, String name) {
		super(id, name);
	}
	
	public Location(String id, String name, String description) {
		super(id, name, description);
	}
	
	public Location(String id, String name, String description, String link, LocalDate date) {
		super(id, name, description, link, date);
	}
	
	public Location(String id, String name, String description, String link, LocalDate date, String country) {
		super(id, name, description, link, date);
		this.country = country;
	}
	
	// *****************************************
	// Setter
	// *****************************************
	public void setCountry(String country) {
		this.country = country;
	}
	
	// *****************************************
	// Getter
	// *****************************************
	public String getCountry() {
		return country;
	}
}
