package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCoded;

public interface Service extends DataIdentifiedByStringAndCoded {

	String getName();
	Service setName(String name);
	
	String getDescription();
	Service setDescription(String description);
	
	String getUniformResourceLocator();
	Service setUniformResourceLocator(String uniformResourceLocator);
	
	@Override Service setIdentifier(Object identifier);
	@Override Service setCode(String code);
	
	/**/
	
	String PROPERTY_NAME = "name";
	String PROPERTY_DESCRIPTION = "description";
	String PROPERTY_UNIFORM_RESOURCE_LOCATOR = "uniformResourceLocator";
}
