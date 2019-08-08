package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.util.Collection;
import java.util.List;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Function;

public interface User extends DataIdentifiedByString {

	@Override User setIdentifier(String identifier);
	
	String getFirstName();
	User setFirstName(String firstName);
	
	String getLastNames();
	User setLastNames(String lastNames);
	
	String getNames();
	User setNames(String names);
	
	String getElectronicMailAddress();
	User setElectronicMailAddress(String electronicMailAddress);
	
	List<Function> getFunctions();
	List<Function> getFunctions(Boolean injectIfNull);
	User setFunctions(List<Function> functions);
	User addFunctions(Collection<Function> functions);
	User addFunctions(Function...functions);
	
	/**/
	
	String PROPERTY_FIRST_NAME = "firstName";
	String PROPERTY_LAST_NAMES = "lastNames";
	String PROPERTY_ELECTRONIC_MAIL_ADDRESS = "electronicMailAddress";
	String PROPERTY_FUNCTIONS = "functions";
}
