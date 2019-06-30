package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringImpl;

public class ProfileFunctionImpl extends AbstractDataIdentifiedByStringImpl implements ProfileFunction,Serializable {
	private static final long serialVersionUID = 1L;
	
	private Profile profile;
	private Function function;
	
	@Override
	public ProfileFunction setIdentifier(String identifier) {
		return (ProfileFunction) super.setIdentifier(identifier);
	}

	@Override
	public ProfileFunction setProfile(Profile profile) {
		this.profile = profile;
		return this;
	}

	@Override
	public Profile getProfile() {
		return profile;
	}

	@Override
	public ProfileFunction setFunction(Function function) {
		this.function = function;
		return this;
	}

	@Override
	public Function getFunction() {
		return function;
	}
	
}
