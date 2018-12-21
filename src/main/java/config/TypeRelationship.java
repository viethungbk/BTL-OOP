package config;

/**
 * Các loại quan hệ giữa các thực thể.
 * @author Viet Hung
 *
 */
public enum TypeRelationship {
	RE_COUNTRY_EVENT("relationship_country_event"),
	RE_EVENT_LOCATION("relationship_event_location"),
	RE_EVENT_TIME("relationship_event_time"),
	RE_ORGANIZATION_EVENT("relationship_organization_event"),
	RE_ORGANIZTION_LOCATION("relationship_organization_location"),
	RE_PERSON_EVENT("relationship_person_event"),
	RE_PERSON_LOCATION("relationship_person_location");
	
	private String relationship;
	/**
	 * Constructor
	 * 
	 * @param relationship Quan hệ giữa các thực thể.
	 */
	private TypeRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	public String getRelationship() {
		return relationship;
	}
	
}
