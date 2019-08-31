package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndLinkedByStringAndNamed;

public interface Scope extends DataIdentifiedByStringAndLinkedByStringAndNamed {

	ScopeType getType();
	Scope setType(ScopeType type);
	
	@Override Scope setIdentifier(String identifier);
	
	String PROPERTY_TYPE = "type";
	
}
