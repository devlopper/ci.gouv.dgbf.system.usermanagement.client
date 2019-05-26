package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

public interface User extends DataIdentifiedByString {

	@Override User setIdentifier(String identifier);
	
	String getFirstName();
	User setFirstName(String firstName);
	
	String getLastNames();
	User setLastNames(String lastNames);
	
	String getElectronicMailAddress();
	User setElectronicMailAddress(String electronicMailAddress);
	
	/**/
	
	String PROPERTY_FIRST_NAME = "firstName";
	String PROPERTY_LAST_NAMES = "lastNames";
	String PROPERTY_ELECTRONIC_MAIL_ADDRESS = "electronicMailAddress";
	
}
