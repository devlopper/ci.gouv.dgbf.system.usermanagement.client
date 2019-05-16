package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCoded;

public interface RoleType extends DataIdentifiedByStringAndCoded {

	String getName();
	RoleType setName(String name);
	
	String getDescription();
	RoleType setDescription(String description);
	
	@Override RoleType setIdentifier(Object identifier);
	@Override RoleType setCode(String code);
	
	/**/
	
	String PROPERTY_NAME = "name";
	String PROPERTY_DESCRIPTION = "description";
}
