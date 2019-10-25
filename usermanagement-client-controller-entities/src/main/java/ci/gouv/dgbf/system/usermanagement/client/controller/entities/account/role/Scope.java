package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndLinkedByStringAndNamed;

public interface Scope extends DataIdentifiedByStringAndLinkedByStringAndNamed {

	ScopeType getType();
	Scope setType(ScopeType type);
	
	String getCode();
	Scope setCode(String code);
	
	@Override Scope setIdentifier(String identifier);
	
	String PROPERTY_CODE = "code";
	String PROPERTY_TYPE = "type";
	
}
