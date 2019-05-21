package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCodedAndNamed;

public interface RolePoste extends DataIdentifiedByStringAndCodedAndNamed {

	RoleFunction getFunction();
	RolePoste setFunction(RoleFunction function);
	
	@Override RolePoste setIdentifier(String identifier);
	@Override RolePoste setCode(String code);
	@Override RolePoste setName(String name);
	
	/**/
	
	String PROPERTY_FUNCTION = "function";
}
