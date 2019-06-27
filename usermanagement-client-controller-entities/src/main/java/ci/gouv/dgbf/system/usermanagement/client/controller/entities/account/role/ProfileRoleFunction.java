package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

public interface ProfileRoleFunction extends DataIdentifiedByString {

	@Override ProfileRoleFunction setIdentifier(String identifier);

	ProfileRoleFunction setProfile(Profile profile);
	Profile getProfile();
	
	ProfileRoleFunction setFunction(RoleFunction function);
	RoleFunction getFunction();
}
