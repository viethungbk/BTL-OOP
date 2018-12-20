package entities;

import java.time.LocalDate;

public class Person extends Entity{
	private String job;					// Chức vụ
	
	// *****************************************
	// Constructor
	// *****************************************
	public Person() {
		super();
	}

	public Person(String id, String name) {
		super(id, name);
	}

	public Person(String id, String name, String description, String job) {
		super(id, name, description);
		this.job = job;
	}

	public Person(String id, String name, String description, String link, LocalDate date, String job) {
		super(id, name, description, link, date);
		this.job = job;
	}
	
	// *****************************************
	// Setter
	// *****************************************
	public void setJob(String job) {
		this.job = job;
	}
	
	// *****************************************
	// Getter
	// *****************************************
	public String getJob() {
		return job;
	}
	
	
	
}
