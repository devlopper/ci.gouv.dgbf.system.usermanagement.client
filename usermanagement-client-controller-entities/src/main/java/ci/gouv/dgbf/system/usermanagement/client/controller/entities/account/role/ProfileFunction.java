package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

public interface ProfileFunction extends DataIdentifiedByString {

	@Override ProfileFunction setIdentifier(String identifier);

	ProfileFunction setProfile(Profile profile);
	Profile getProfile();
	
	ProfileFunction setFunction(Function function);
	Function getFunction();
	
	String PROPERTY_PROFILE = "profile";
	String PROPERTY_FUNCTION = "function";
}
