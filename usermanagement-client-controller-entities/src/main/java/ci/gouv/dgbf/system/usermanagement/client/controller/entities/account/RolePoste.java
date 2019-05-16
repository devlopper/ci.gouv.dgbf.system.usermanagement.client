package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCoded;

public interface RolePoste extends DataIdentifiedByStringAndCoded {

	String getName();
	RolePoste setName(String name);
	/*
	String getDescription();
	RolePoste setDescription(String description);
	*/
	
	RoleFunction getFunction();
	RolePoste setFunction(RoleFunction function);
	
	@Override RolePoste setIdentifier(Object identifier);
	@Override RolePoste setCode(String code);
	
	/**/
	
	String PROPERTY_NAME = "name";
	//String PROPERTY_DESCRIPTION = "description";
	String PROPERTY_FUNCTION = "function";
}
