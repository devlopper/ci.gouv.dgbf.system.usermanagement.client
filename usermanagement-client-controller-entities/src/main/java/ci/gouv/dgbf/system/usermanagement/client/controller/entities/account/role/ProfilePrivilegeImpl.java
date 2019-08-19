package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringImpl;

public class ProfilePrivilegeImpl extends AbstractDataIdentifiedByStringImpl implements ProfilePrivilege,Serializable {
	private static final long serialVersionUID = 1L;
	
	private Profile profile;
	private Privilege privilege;
	
	@Override
	public ProfilePrivilege setIdentifier(String identifier) {
		return (ProfilePrivilege) super.setIdentifier(identifier);
	}

	@Override
	public ProfilePrivilege setProfile(Profile profile) {
		this.profile = profile;
		return this;
	}

	@Override
	public Profile getProfile() {
		return profile;
	}

	@Override
	public ProfilePrivilege setPrivilege(Privilege privilege) {
		this.privilege = privilege;
		return this;
	}

	@Override
	public Privilege getPrivilege() {
		return privilege;
	}
	
}
