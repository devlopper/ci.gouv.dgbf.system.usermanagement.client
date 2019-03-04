package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.Data;

public interface UserNaturalPerson extends Data {

	@Override UserNaturalPerson setIdentifier(Object identifier);
	@Override UserNaturalPerson setCode(String code);
	
	String getFirstName();
	UserNaturalPerson setFirstName(String firstName);
	
	String getLastNames();
	UserNaturalPerson setLastName(String lastNames);
	
	/**/
	
	public static final String PROPERTY_USER = "user";
	public static final String PROPERTY_FIRST_NAME = "firstName";
	public static final String PROPERTY_LAST_NAMES = "lastNames";
	public static final String PROPERTY_IS_MASCULINE = "isMasculine";
	
}
