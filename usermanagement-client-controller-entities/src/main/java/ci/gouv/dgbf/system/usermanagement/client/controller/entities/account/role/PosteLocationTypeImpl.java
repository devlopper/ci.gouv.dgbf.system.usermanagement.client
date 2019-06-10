package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedAndNamedImpl;

public class PosteLocationTypeImpl extends AbstractDataIdentifiedByStringAndCodedAndNamedImpl implements PosteLocationType,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public PosteLocationType setIdentifier(String identifier) {
		return (PosteLocationType) super.setIdentifier(identifier);
	}
	
	@Override
	public PosteLocationType setCode(String code) {
		return (PosteLocationType) super.setCode(code);
	}
	
	@Override
	public PosteLocationType setName(String name) {
		return (PosteLocationType) super.setName(name);
	}
}
