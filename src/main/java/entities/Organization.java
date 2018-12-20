package entities;

import java.time.LocalDate;

public class Organization extends Entity {
	private String headquarter;					// Trụ sở

	// *****************************************
	// Constructor
	// *****************************************
	public Organization() {
		super();
	}

	public Organization(String id, String name) {
		super(id, name);
	}
	
	public Organization(String id, String name, String description) {
		super(id, name, description);
	}
	
	public Organization(String id, String name, String description, String link, LocalDate date) {
		super(id, name, description, link, date);
	}

	public Organization(String id, String name, String description, String link, LocalDate date, String headquarter) {
		super(id, name, description, link, date);
		this.headquarter = headquarter;
	}
	
	// *****************************************
	// Setter
	// *****************************************
	public void setHeadquarter(String headquarter) {
		this.headquarter = headquarter;
	}
	
	// *****************************************
	// Getter
	// *****************************************
	public String getHeadquarter() {
		return headquarter;
	}
	
	
	
	
}
