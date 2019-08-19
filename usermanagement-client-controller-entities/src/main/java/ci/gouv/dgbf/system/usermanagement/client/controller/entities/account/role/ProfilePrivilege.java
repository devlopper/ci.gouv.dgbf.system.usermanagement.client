package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

public interface ProfilePrivilege extends DataIdentifiedByString {

	@Override ProfilePrivilege setIdentifier(String identifier);

	ProfilePrivilege setProfile(Profile profile);
	Profile getProfile();
	
	ProfilePrivilege setPrivilege(Privilege privilege);
	Privilege getPrivilege();
	
	String PROPERTY_PROFILE = "profile";
	String PROPERTY_PRIVILEGE = "privilege";
}
