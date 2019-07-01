package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.util.Collection;
import java.util.List;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCodedAndNamed;

public interface Profile extends DataIdentifiedByStringAndCodedAndNamed {

	@Override Profile setIdentifier(String identifier);
	@Override Profile setCode(String code);
	@Override Profile setName(String name);
	
	List<Function> getFunctions();
	List<Function> getFunctions(Boolean injectIfNull);
	Profile setFunctions(List<Function> functions);
	Profile addFunctions(Collection<Function> functions);
	Profile addFunctions(Function...functions);
	Profile addFunctionsByCodes(Collection<String> codes);
	Profile addFunctionsByCodes(String...codes);
	
	String PROPERTY_FUNCTIONS = "functions";
}
