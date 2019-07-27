package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCodedAndNamed;

public interface FunctionType extends DataIdentifiedByStringAndCodedAndNamed {

	@Override FunctionType setIdentifier(String identifier);
	@Override FunctionType setCode(String code);
	@Override FunctionType setName(String name);
	
}
