package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedAndNamedImpl;

public class ProfileTypeImpl extends AbstractDataIdentifiedByStringAndCodedAndNamedImpl implements ProfileType,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public ProfileType setIdentifier(Object identifier) {
		return (ProfileType) super.setIdentifier(identifier);
	}
	
	@Override
	public ProfileType setCode(String code) {
		return (ProfileType) super.setCode(code);
	}
	
	@Override
	public ProfileType setName(String name) {
		return (ProfileType) super.setName(name);
	}
}
