package store.data;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;

import config.EntityConfig;

/**
 * Tạo các IRI (để lưu trữ các thực thể vào Model) bằng ValueFactory
 * @author Viet Hung
 *
 */
public class CreateIri {
	// Các IRI ứng với Country
	private IRI countryNameIri;
	private IRI countryDescriptionIri;
	private IRI countryDateIri;
	private IRI countryLinkIri;
	
	// Các IRI ứng với Event
	private IRI eventNameIri;
	private IRI eventDescriptionIri;
	private IRI eventDateIri;
	private IRI eventLinkIri;
	
	// Các IRI ứng với Location
	private IRI locationNameIri;
	private IRI locationDescriptionIri;
	private IRI locationDateIri;
	private IRI locationLinkIri;
	private IRI locationCountryIri;
	
	// Các IRI ứng với Organization
	private IRI organizationNameIri;
	private IRI organizationDescriptionIri;
	private IRI organizationDateIri;
	private IRI organizationLinkIri;
	private IRI organizationHeadquarterIri;
	
	// Các IRI ứng với Person
	private IRI personNameIri;
	private IRI personDescriptionIri;
	private IRI personDateIri;
	private IRI personLinkIri;
	private IRI personJobIri;
	
	// Các IRI ứng với Time
	private IRI timeNameIri;
	private IRI timeDescriptionIri;
	private IRI timeDateIri;
	private IRI timeLinkIri;
	

	public IRI getCountryNameIri(ValueFactory vf) {
		countryNameIri = vf.createIRI(EntityConfig.COUNTRY, EntityConfig.LABEL);
		return countryNameIri;
	}

	public IRI getCountryDescriptionIri(ValueFactory vf) {
		countryDescriptionIri = vf.createIRI(EntityConfig.COUNTRY, EntityConfig.DESCRIPTION);
		return countryDescriptionIri;
	}

	public IRI getCountryDateIri(ValueFactory vf) {
		countryDateIri = vf.createIRI(EntityConfig.COUNTRY, EntityConfig.DATE);
		return countryDateIri;
	}

	public IRI getCountryLinkIri(ValueFactory vf) {
		countryLinkIri = vf.createIRI(EntityConfig.COUNTRY, EntityConfig.LINK);
		return countryLinkIri;
	}
	
	public IRI getEventNameIri(ValueFactory vf) {
		eventNameIri = vf.createIRI(EntityConfig.EVENT, EntityConfig.LABEL);
		return eventNameIri;
	}

	public IRI getEventDescriptionIri(ValueFactory vf) {
		eventDescriptionIri = vf.createIRI(EntityConfig.EVENT, EntityConfig.DESCRIPTION);
		return eventDescriptionIri;
	}

	public IRI getEventDateIri(ValueFactory vf) {
		eventDateIri = vf.createIRI(EntityConfig.EVENT, EntityConfig.DATE);
		return eventDateIri;
	}

	public IRI getEventLinkIri(ValueFactory vf) {
		eventLinkIri = vf.createIRI(EntityConfig.EVENT, EntityConfig.LINK);
		return eventLinkIri;
	}

	public IRI getLocationNameIri(ValueFactory vf) {
		locationNameIri = vf.createIRI(EntityConfig.COUNTRY, EntityConfig.LABEL);
		return locationNameIri;
	}

	public IRI getLocationDescriptionIri(ValueFactory vf) {
		locationDescriptionIri = vf.createIRI(EntityConfig.COUNTRY, EntityConfig.DESCRIPTION);
		return locationDescriptionIri;
	}

	public IRI getLocationDateIri(ValueFactory vf) {
		locationDateIri = vf.createIRI(EntityConfig.COUNTRY, EntityConfig.DATE);
		return locationDateIri;
	}

	public IRI getLocationLinkIri(ValueFactory vf) {
		locationLinkIri = vf.createIRI(EntityConfig.COUNTRY, EntityConfig.LINK);
		return locationLinkIri;
	}

	public IRI getLocationCountryIri(ValueFactory vf) {
		locationCountryIri = vf.createIRI(EntityConfig.COUNTRY, EntityConfig.IN_COUNTRY);
		return locationCountryIri;
	}

	public IRI getOrganizationNameIri(ValueFactory vf) {
		organizationNameIri = vf.createIRI(EntityConfig.LOCATION, EntityConfig.LABEL);
		return organizationNameIri;
	}

	public IRI getOrganizationDescriptionIri(ValueFactory vf) {
		organizationDescriptionIri = vf.createIRI(EntityConfig.LOCATION, EntityConfig.DESCRIPTION);
		return organizationDescriptionIri;
	}

	public IRI getOrganizationDateIri(ValueFactory vf) {
		organizationDateIri = vf.createIRI(EntityConfig.LOCATION, EntityConfig.DATE);
		return organizationDateIri;
	}

	public IRI getOrganizationLinkIri(ValueFactory vf) {
		organizationLinkIri = vf.createIRI(EntityConfig.LOCATION, EntityConfig.LINK);
		return organizationLinkIri;
	}

	public IRI getOrganizationHeadquarterIri(ValueFactory vf) {
		organizationHeadquarterIri = vf.createIRI(EntityConfig.LOCATION, EntityConfig.HEADQUARTER);
		return organizationHeadquarterIri;
	}

	public IRI getPersonNameIri(ValueFactory vf) {
		personNameIri = vf.createIRI(EntityConfig.PERSON, EntityConfig.LABEL);
		return personNameIri;
	}

	public IRI getPersonDescriptionIri(ValueFactory vf) {
		personDescriptionIri = vf.createIRI(EntityConfig.PERSON, EntityConfig.DESCRIPTION);

		return personDescriptionIri;
	}

	public IRI getPersonDateIri(ValueFactory vf) {
		personDateIri = vf.createIRI(EntityConfig.PERSON, EntityConfig.DATE);
		return personDateIri;
	}

	public IRI getPersonLinkIri(ValueFactory vf) {
		personLinkIri = vf.createIRI(EntityConfig.PERSON, EntityConfig.LINK);
		return personLinkIri;
	}

	public IRI getPersonJobIri(ValueFactory vf) {
		personJobIri = vf.createIRI(EntityConfig.PERSON, EntityConfig.JOB);
		return personJobIri;
	}

	public IRI getTimeNameIri(ValueFactory vf) {
		timeNameIri = vf.createIRI(EntityConfig.TIME, EntityConfig.LABEL);
		return timeNameIri;
	}

	public IRI getTimeDescriptionIri(ValueFactory vf) {
		timeDescriptionIri = vf.createIRI(EntityConfig.TIME, EntityConfig.DESCRIPTION);
		return timeDescriptionIri;
	}

	public IRI getTimeDateIri(ValueFactory vf) {
		timeDateIri = vf.createIRI(EntityConfig.TIME, EntityConfig.DATE);
		return timeDateIri;
	}

	public IRI getTimeLinkIri(ValueFactory vf) {
		timeLinkIri = vf.createIRI(EntityConfig.TIME, EntityConfig.LINK);
		return timeLinkIri;
	}
	
	
}
