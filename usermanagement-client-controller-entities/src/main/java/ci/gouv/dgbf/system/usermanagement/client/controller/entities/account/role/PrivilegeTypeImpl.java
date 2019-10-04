package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.hierarchy.AbstractDataIdentifiedByStringAndCodedAndNamedImpl;

public class PrivilegeTypeImpl extends AbstractDataIdentifiedByStringAndCodedAndNamedImpl<PrivilegeType> implements PrivilegeType,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public PrivilegeType setIdentifier(String identifier) {
		return (PrivilegeType) super.setIdentifier(identifier);
	}
	
	@Override
	public PrivilegeType setCode(String code) {
		return (PrivilegeType) super.setCode(code);
	}
	
	@Override
	public PrivilegeType setName(String name) {
		return (PrivilegeType) super.setName(name);
	}
}
