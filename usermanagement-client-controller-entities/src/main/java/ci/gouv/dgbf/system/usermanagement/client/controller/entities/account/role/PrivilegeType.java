package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.hierarchy.DataIdentifiedByStringAndCodedAndNamed;

public interface PrivilegeType extends DataIdentifiedByStringAndCodedAndNamed<PrivilegeType> {

	@Override PrivilegeType setIdentifier(Object identifier);
	@Override PrivilegeType setCode(String code);
	@Override PrivilegeType setName(String name);
}
