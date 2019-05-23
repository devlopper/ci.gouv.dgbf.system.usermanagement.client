package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCodedAndNamed;

public interface RoleFunction extends DataIdentifiedByStringAndCodedAndNamed {

	RoleCategory getCategory();
	RoleFunction setCategory(RoleCategory category);
	
	@Override RoleFunction setIdentifier(String identifier);
	@Override RoleFunction setCode(String code);
	@Override RoleFunction setName(String name);
	
	/**/
	
	String PROPERTY_CATEGORY = "category";
}
