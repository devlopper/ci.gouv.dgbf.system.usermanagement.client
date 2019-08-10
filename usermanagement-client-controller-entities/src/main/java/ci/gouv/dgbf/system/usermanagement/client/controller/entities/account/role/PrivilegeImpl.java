package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.hierarchy.AbstractDataIdentifiedByStringAndCodedAndNamedImpl;

public class PrivilegeImpl extends AbstractDataIdentifiedByStringAndCodedAndNamedImpl implements Privilege,Serializable {
	private static final long serialVersionUID = 1L;

	private PrivilegeType type;
	
	@Override
	public Privilege setIdentifier(String identifier) {
		return (Privilege) super.setIdentifier(identifier);
	}
	
	@Override
	public Privilege setCode(String code) {
		return (Privilege) super.setCode(code);
	}
	
	@Override
	public Privilege setName(String name) {
		return (Privilege) super.setName(name);
	}

	@Override
	public PrivilegeType getType() {
		return type;
	}

	@Override
	public Privilege setType(PrivilegeType type) {
		this.type = type;
		return this;
	}

}
