package store.data;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import config.EntityConfig;
import entities.Country;
import entities.Event;
import entities.Location;
import entities.Organization;
import entities.Person;

public class StoreData {

	public StoreData() {

	}

	/**
	 * Lưu trữ đối tượng Person vào Model để chuẩn bị thêm vào database.
	 * 
	 * @param person
	 *            Đối tượng Person muốn lưu trữ
	 * @param vf
	 *            ValueFactory để tạo triples
	 * @param model
	 *            Lưu trữ các triple
	 * @return IRI của id person vừa tạo
	 */
	public IRI addToModel(Person person, ValueFactory vf, Model model) {
		IRI idIri = vf.createIRI(EntityConfig.PERSON, person.getId());

		CreateIri createIri = new CreateIri();

		model.add(idIri, createIri.getPersonNameIri(vf), vf.createLiteral(person.getName()));
		model.add(idIri, createIri.getPersonDescriptionIri(vf), vf.createLiteral(person.getDescription()));
		model.add(idIri, createIri.getPersonDateIri(vf), vf.createLiteral(person.getDate().toString()));
		model.add(idIri, createIri.getPersonLinkIri(vf), vf.createLiteral(person.getLink()));
		model.add(idIri, createIri.getPersonJobIri(vf), vf.createLiteral(person.getJob()));

		return idIri;
	}

	/**
	 * Lưu trữ đối tượng Country vào Model để chuẩn bị thêm vào database.
	 * 
	 * @param country
	 *            Đối tượng Country muốn lưu trữ.
	 * @param vf
	 *            ValueFactory để tạo triples.
	 * @param model
	 *            Lưu trữ các triple.
	 * @return IRI của id Country vừa tạo
	 */
	public IRI addToModel(Country country, ValueFactory vf, Model model) {
		IRI idIri = vf.createIRI(EntityConfig.COUNTRY, country.getId());

		CreateIri createIri = new CreateIri();

		model.add(idIri, createIri.getCountryNameIri(vf), vf.createLiteral(country.getName()));
		model.add(idIri, createIri.getCountryDescriptionIri(vf), vf.createLiteral(country.getDescription()));
		model.add(idIri, createIri.getCountryDateIri(vf), vf.createLiteral(country.getDate().toString()));
		model.add(idIri, createIri.getCountryLinkIri(vf), vf.createLiteral(country.getLink()));

		return idIri;
	}

	/**
	 * Lưu trữ đối tượng Event vào Model để chuẩn bị thêm vào database.
	 * 
	 * @param event
	 *            Đối tượng Event muốn lưu trữ.
	 * @param vf
	 *            ValueFactory để tạo triples.
	 * @param model
	 *            Lưu trữ các triple.
	 * @return IRI của id Event vừa tạo
	 */
	public IRI addToModel(Event event, ValueFactory vf, Model model) {
		IRI idIri = vf.createIRI(EntityConfig.EVENT, event.getId());

		CreateIri createIri = new CreateIri();

		model.add(idIri, createIri.getEventNameIri(vf), vf.createLiteral(event.getName()));
		model.add(idIri, createIri.getEventDescriptionIri(vf), vf.createLiteral(event.getDescription()));
		model.add(idIri, createIri.getEventDateIri(vf), vf.createLiteral(event.getDate().toString()));
		model.add(idIri, createIri.getEventLinkIri(vf), vf.createLiteral(event.getLink()));

		return idIri;
	}

	/**
	 * Lưu trữ đối tượng Location vào Model để chuẩn bị thêm vào database.
	 * 
	 * @param location
	 *            Đối tượng Location muốn lưu trữ.
	 * @param vf
	 *            ValueFactory để tạo triples.
	 * @param model
	 *            Lưu trữ các triple.
	 * @return IRI của id Location vừa tạo
	 */
	public IRI addToModel(Location location, ValueFactory vf, Model model) {
		IRI idIri = vf.createIRI(EntityConfig.EVENT, location.getId());

		CreateIri createIri = new CreateIri();

		model.add(idIri, createIri.getLocationNameIri(vf), vf.createLiteral(location.getName()));
		model.add(idIri, createIri.getLocationDescriptionIri(vf), vf.createLiteral(location.getDescription()));
		model.add(idIri, createIri.getLocationDateIri(vf), vf.createLiteral(location.getDate().toString()));
		model.add(idIri, createIri.getLocationLinkIri(vf), vf.createLiteral(location.getLink()));
		model.add(idIri, createIri.getLocationCountryIri(vf), vf.createLiteral(location.getCountry()));

		return idIri;
	}

	/**
	 * Lưu trữ đối tượng Organization vào Model để chuẩn bị thêm vào database.
	 * 
	 * @param organization
	 *            Đối tượng Organization muốn lưu trữ.
	 * @param vf
	 *            ValueFactory để tạo triples.
	 * @param model
	 *            Lưu trữ các triple.
	 * @return IRI của id Organization vừa tạo
	 */
	public IRI addToModel(Organization organization, ValueFactory vf, Model model) {
		IRI idIri = vf.createIRI(EntityConfig.EVENT, organization.getId());

		CreateIri createIri = new CreateIri();

		model.add(idIri, createIri.getOrganizationNameIri(vf), vf.createLiteral(organization.getName()));
		model.add(idIri, createIri.getOrganizationDescriptionIri(vf), vf.createLiteral(organization.getDescription()));
		model.add(idIri, createIri.getOrganizationDateIri(vf), vf.createLiteral(organization.getDate().toString()));
		model.add(idIri, createIri.getOrganizationLinkIri(vf), vf.createLiteral(organization.getLink()));
		model.add(idIri, createIri.getOrganizationHeadquarterIri(vf), vf.createLiteral(organization.getHeadquarter()));

		return idIri;
	}

	public void addToDB(Model model, RepositoryConnection conn) {
		try {
			conn.add(model);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
