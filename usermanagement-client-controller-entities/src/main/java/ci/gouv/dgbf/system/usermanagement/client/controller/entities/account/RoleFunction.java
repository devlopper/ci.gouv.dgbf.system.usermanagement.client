package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.Data;

public interface RoleFunction extends Data {

	String getName();
	RoleFunction setName(String name);
	
	String getDescription();
	RoleFunction setDescription(String description);
	
	@Override RoleFunction setIdentifier(Object identifier);
	@Override RoleFunction setCode(String code);
	
	/**/
	
	String PROPERTY_NAME = "name";
	String PROPERTY_DESCRIPTION = "description";
}
