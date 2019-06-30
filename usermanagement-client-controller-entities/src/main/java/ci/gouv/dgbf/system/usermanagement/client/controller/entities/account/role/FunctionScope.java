package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCodedAndNamed;

public interface FunctionScope extends DataIdentifiedByStringAndCodedAndNamed {

	Function getFunction();
	FunctionScope setFunction(Function function);
	
	Scope getScope();
	FunctionScope setScope(Scope scope);
	
	@Override FunctionScope setIdentifier(String identifier);
	@Override FunctionScope setCode(String code);
	@Override FunctionScope setName(String name);
	
	/**/
	
	String PROPERTY_FUNCTION = "function";
	String PROPERTY_SCOPE = "scope";
	
}
