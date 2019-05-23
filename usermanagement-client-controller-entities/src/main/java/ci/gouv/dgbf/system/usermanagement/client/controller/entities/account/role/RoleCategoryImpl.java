package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedAndNamedImpl;

public class RoleCategoryImpl extends AbstractDataIdentifiedByStringAndCodedAndNamedImpl implements RoleCategory,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public RoleCategory setIdentifier(String identifier) {
		return (RoleCategory) super.setIdentifier(identifier);
	}
	
	@Override
	public RoleCategory setCode(String code) {
		return (RoleCategory) super.setCode(code);
	}
	
	@Override
	public RoleCategory setName(String name) {
		return (RoleCategory) super.setName(name);
	}
}
