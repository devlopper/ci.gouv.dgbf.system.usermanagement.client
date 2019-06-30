package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCodedAndNamed;

public interface Function extends DataIdentifiedByStringAndCodedAndNamed {

	FunctionCategory getCategory();
	Function setCategory(FunctionCategory category);
	
	@Override Function setIdentifier(String identifier);
	@Override Function setCode(String code);
	@Override Function setName(String name);
	
	/**/
	
	String PROPERTY_CATEGORY = "category";
}
