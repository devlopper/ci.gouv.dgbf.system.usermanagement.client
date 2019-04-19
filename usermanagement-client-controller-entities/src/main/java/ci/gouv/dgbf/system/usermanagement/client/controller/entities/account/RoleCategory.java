package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.Data;

public interface RoleCategory extends Data {

	String getName();
	RoleCategory setName(String name);
	
	String getDescription();
	RoleCategory setDescription(String description);
	
	@Override RoleCategory setIdentifier(Object identifier);
	@Override RoleCategory setCode(String code);
	
	/**/
	
	String PROPERTY_NAME = "name";
	String PROPERTY_DESCRIPTION = "description";
}
