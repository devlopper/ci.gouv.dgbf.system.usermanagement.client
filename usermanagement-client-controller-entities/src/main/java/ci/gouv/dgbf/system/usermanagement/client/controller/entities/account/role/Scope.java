package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

public interface Scope extends DataIdentifiedByString {

	ScopeType getType();
	Scope setType(ScopeType type);
	
	@Override Scope setIdentifier(String identifier);
	
	String PROPERTY_TYPE = "type";
	
}
