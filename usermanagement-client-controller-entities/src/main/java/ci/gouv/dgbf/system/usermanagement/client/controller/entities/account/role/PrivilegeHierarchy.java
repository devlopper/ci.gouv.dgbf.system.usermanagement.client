package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

public interface PrivilegeHierarchy extends DataIdentifiedByString {

	Privilege getParent();
	PrivilegeHierarchy setParent(Privilege privilege);
	
	Privilege getChild();
	PrivilegeHierarchy setChild(Privilege child);
}
