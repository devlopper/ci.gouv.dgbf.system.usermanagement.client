package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCodedAndNamed;

public interface RoleCategory extends DataIdentifiedByStringAndCodedAndNamed {

	@Override RoleCategory setIdentifier(String identifier);
	@Override RoleCategory setCode(String code);
	@Override RoleCategory setName(String name);
	
}
