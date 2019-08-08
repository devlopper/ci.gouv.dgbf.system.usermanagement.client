package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringImpl;

public class PrivilegeHierarchyImpl extends AbstractDataIdentifiedByStringImpl implements PrivilegeHierarchy,Serializable {
	private static final long serialVersionUID = 1L;

	private Privilege parent,child;
	
	@Override
	public Privilege setIdentifier(Object identifier) {
		return (Privilege) super.setIdentifier(identifier);
	}

	@Override
	public Privilege getParent() {
		return parent;
	}

	@Override
	public PrivilegeHierarchy setParent(Privilege parent) {
		this.parent = parent;
		return this;
	}

	@Override
	public Privilege getChild() {
		return child;
	}

	@Override
	public PrivilegeHierarchy setChild(Privilege child) {
		this.child = child;
		return this;
	}
	
	
}
