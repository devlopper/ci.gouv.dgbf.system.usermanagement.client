package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCodedAndNamed;

public interface PosteLocationType extends DataIdentifiedByStringAndCodedAndNamed {

	@Override PosteLocationType setIdentifier(String identifier);
	@Override PosteLocationType setCode(String code);
	@Override PosteLocationType setName(String name);
	
}
