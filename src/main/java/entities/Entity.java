package entities;

import java.time.LocalDate;

public class Entity {
	protected String id;				// Định danh
	protected String name;				// Tên
	protected String description;		// Mô tả
	protected String link;				// Link trích rút
	protected LocalDate date;				// Ngày trích rút
	
	// *****************************************
	// Constructor
	// *****************************************
	public Entity() {
		
	}
	
	public Entity(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Entity(String id, String name, String description) {
		this(id, name);
		this.description = description;
	}

	public Entity(String id, String name, String description, String link, LocalDate date) {
		this(id, name, description);
		this.link = link;
		this.date = date;
	}
	
	// *****************************************
	// Setter
	// *****************************************
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	// *****************************************
	// Getter
	// *****************************************
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getLink() {
		return link;
	}

	public LocalDate getDate() {
		return date;
	}
	
}
