package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringImpl;

public class ProfileRoleFunctionImpl extends AbstractDataIdentifiedByStringImpl implements ProfileRoleFunction,Serializable {
	private static final long serialVersionUID = 1L;
	
	private Profile profile;
	private RoleFunction function;
	
	@Override
	public ProfileRoleFunction setIdentifier(String identifier) {
		return (ProfileRoleFunction) super.setIdentifier(identifier);
	}

	@Override
	public ProfileRoleFunction setProfile(Profile profile) {
		this.profile = profile;
		return this;
	}

	@Override
	public Profile getProfile() {
		return profile;
	}

	@Override
	public ProfileRoleFunction setFunction(RoleFunction function) {
		this.function = function;
		return this;
	}

	@Override
	public RoleFunction getFunction() {
		return function;
	}
	
}
