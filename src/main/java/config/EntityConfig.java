package config;

public class EntityConfig {
	// ID mặc định cho các thực thể
	public static final String COUNTRY_ID = "country";
	public static final String EVENT_ID = "event";
	public static final String LOCATION_ID = "location";
	public static final String ORGANIZATION_ID = "organization";
	public static final String PERSON_ID = "person";
	public static final String TIME_ID = "time";

	// Prefix Link mô tả mặc định cho các thực thể
	public static final String COUNTRY_LINK = "https://hust.edu.vn/country/";
	public static final String EVENT_LINK = "https://hust.edu.vn/time/";
	public static final String LOCATION_LINK = "https://hust.edu.vn/location/";
	public static final String ORGANIZATION_LINK = "https://hust.edu.vn/organization/";
	public static final String PERSON_LINK = "https://hust.edu.vn/person/";
	public static final String TIME_LINK = "https://hust.edu.vn/time/";

	// Prefix Namespace cho các thực thể
	public static final String COUNTRY_NAMESPACE = "http://hust.btl.namespace/country/";
	public static final String EVENT_NAMESPACE = "http://hust.btl.namespace/event/";
	public static final String LOCATION_NAMESPACE = "http://hust.btl.namespace/location/";
	public static final String ORGANIZATION_NAMESPACE = "http://hust.btl.namespace/organization/";
	public static final String PERSON_NAMESPACE = "http://hust.btl.namespace/person/";
	public static final String TIME_NAMESPACE = "http://hust.btl.namespace/time/";
	
	// Prefix Namespace cho quan hệ
	public static final String RELATIONSHIP_NAMESPACE = "http://hust.btl.namespace/relationship/";

	// Các thuộc tính của thực thể
	public static final String LABEL = "has_label";
	public static final String DESCRIPTION = "has_description";
	public static final String LINK = "has_link";
	public static final String DATE = "has_date";
	public static final String JOB = "has_job";
	public static final String IN_COUNTRY = "in_country";
	public static final String HEADQUARTER = "has_headquarter";
}
