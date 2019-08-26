package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.hierarchy.DataIdentifiedByStringAndCodedAndNamed;

public interface Privilege extends DataIdentifiedByStringAndCodedAndNamed<Privilege> {

	PrivilegeType getType();
	Privilege setType(PrivilegeType type);
	
	@Override Privilege setIdentifier(String identifier);
	@Override Privilege setCode(String code);
	@Override Privilege setName(String name);
}
