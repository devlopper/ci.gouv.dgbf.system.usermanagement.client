package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.Data;

public interface Role extends Data {

	RoleType getType();
	Role setType(RoleType type);
	
	String getName();
	Role setName(String name);
	
	String getDescription();
	Role setDescription(String description);
	
	@Override Role setIdentifier(Object identifier);
	@Override Role setCode(String code);
	
	/**/
	
	String PROPERTY_NAME = "name";
	String PROPERTY_DESCRIPTION = "description";
	String PROPERTY_TYPE = "type";
}
