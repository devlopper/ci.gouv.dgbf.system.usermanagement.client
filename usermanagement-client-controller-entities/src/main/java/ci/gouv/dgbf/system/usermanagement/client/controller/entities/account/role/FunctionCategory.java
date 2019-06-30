package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCodedAndNamed;

public interface FunctionCategory extends DataIdentifiedByStringAndCodedAndNamed {

	@Override FunctionCategory setIdentifier(String identifier);
	@Override FunctionCategory setCode(String code);
	@Override FunctionCategory setName(String name);
	
}
