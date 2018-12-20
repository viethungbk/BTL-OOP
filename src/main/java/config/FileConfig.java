package config;

public class FileConfig {
	// Đường dẫn của Project
	public static final String PROJECT_PATH = System.getProperty("user.dir");

	/* Đường dẫn của các file dữ liệu */

	public static final String FILE_COUNTRY_NAME = PROJECT_PATH + "/rawdata-test/country/Country.txt";
	public static final String FILE_COUNTRY_DESCRIPTION = PROJECT_PATH
			+ "/rawdata-test/country/CountryDescription.txt";
	public static final String FILE_COUNTRY_DATE = PROJECT_PATH + "/rawdata-test/country/CountryDate.txt";

	public static final String FILE_EVENT_NAME = PROJECT_PATH + "/rawdata-test/event/EventName.txt";
	public static final String FILE_EVENT_DESCRIPTION = PROJECT_PATH + "/rawdata-test/event/EventDescription.txt";
	public static final String FILE_EVENT_DATE = PROJECT_PATH + "/rawdata-test/event/EventDate.txt";

	public static final String FILE_LOCATION_NAME = PROJECT_PATH + "/rawdata-test/location/LocationName.txt";
	public static final String FILE_LOCATION_DESCRIPTION = PROJECT_PATH
			+ "/rawdata-test/location/LocationDescription.txt";
	public static final String FILE_LOCATION_DATE = PROJECT_PATH + "/rawdata-test/location/LocationDate.txt";
	public static final String FILE_LOCATION_COUNTRY = PROJECT_PATH + "/rawdata-test/location/LocationCountry.txt";

	public static final String FILE_ORGANIZATION_NAME = PROJECT_PATH
			+ "/rawdata-test/organization/OrganizationName.txt";
	public static final String FILE_ORGANIZATION_DESCRIPTION = PROJECT_PATH
			+ "/rawdata-test/organization/OrganizationDescription.txt";
	public static final String FILE_ORGANIZATION_HEADQUARTER = PROJECT_PATH
			+ "/rawdata-test/organization/OrganizationHeadquarter.txt";
	public static final String FILE_ORGANIZATION_DATE = PROJECT_PATH
			+ "/rawdata-test/organization/OrganizationDate.txt";

	public static final String FILE_PERSON_NAME = PROJECT_PATH + "/rawdata-test/person/PersonName.txt";
	public static final String FILE_PERON_DESCRIPTION = PROJECT_PATH + "/rawdata-test/person/PersonDescription.txt";
	public static final String FILE_PERSON_JOB = PROJECT_PATH + "/rawdata-test/person/PersonJob.txt";
	public static final String FILE_PERSON_DATE = PROJECT_PATH + "/rawdata-test/person/PersonDate.txt";

	public static final String FILE_TIME = PROJECT_PATH + "/rawdata-test/time/DateTime.txt";
	public static final String FILE_TIME_DESCRIPTION = PROJECT_PATH + "/rawdata-test/time/TimeDescription.txt";

	public static final String FILE_RELATIONSHIP_COUNTRY_EVENT = PROJECT_PATH
			+ "/rawdata-test/relationship/Country_Event.txt";
	public static final String FILE_RELATIONSHIP_EVENT_LOCATION = PROJECT_PATH
			+ "/rawdata-test/relationship/Event_Location.txt";
	public static final String FILE_RELATIONSHIP_EVENT_TIME = PROJECT_PATH
			+ "/rawdata-test/relationship/Event_Time.txt";
	public static final String FILE_RELATIONSHIP_ORGANIZATION_EVENT = PROJECT_PATH
			+ "/rawdata-test/relationship/Organization_Event.txt";
	public static final String FILE_RELATIONSHIP_ORGANIZATION_LOCATION = PROJECT_PATH
			+ "/rawdata-test/relationship/Organization_Location.txt";
	public static final String FILE_RELATIONSHIP_PERSON_EVENT = PROJECT_PATH
			+ "/rawdata-test/relationship/Person_Event.txt";
	public static final String FILE_RELATIONSHIP_PERSON_LOCATION = PROJECT_PATH
			+ "/rawdata-test/relationship/Person_Location.txt";

}
