package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCoded;

public interface RoleFunction extends DataIdentifiedByStringAndCoded {

	String getName();
	RoleFunction setName(String name);
	/*
	String getDescription();
	RoleFunction setDescription(String description);
	*/
	RoleCategory getCategory();
	RoleFunction setCategory(RoleCategory category);
	
	@Override RoleFunction setIdentifier(Object identifier);
	@Override RoleFunction setCode(String code);
	
	/**/
	
	String PROPERTY_NAME = "name";
	//String PROPERTY_DESCRIPTION = "description";
	String PROPERTY_CATEGORY = "category";
}
