package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCoded;

public interface User extends DataIdentifiedByStringAndCoded {

	@Override User setIdentifier(Object identifier);
	@Override User setCode(String code);
	
	String getElectronicMailAddress();
	User setElectronicMailAddress(String electronicMailAddress);
	
	UserNaturalPerson getPerson();
	User setPerson(UserNaturalPerson person);
	
	/**/
	
	String PROPERTY_ELECTRONIC_MAIL_ADDRESS = "electronicMailAddress";
	String PROPERTY_PERSON = "person";
	
}
