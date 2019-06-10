package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

public interface PosteLocation extends DataIdentifiedByString {

	PosteLocationType getType();
	PosteLocation setType(PosteLocationType type);
	
	@Override PosteLocation setIdentifier(String identifier);
	
	String PROPERTY_TYPE = "type";
	
}
