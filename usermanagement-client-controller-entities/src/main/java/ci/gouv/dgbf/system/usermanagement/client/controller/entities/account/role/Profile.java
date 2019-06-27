package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCodedAndNamed;

public interface Profile extends DataIdentifiedByStringAndCodedAndNamed {

	@Override Profile setIdentifier(String identifier);
	@Override Profile setCode(String code);
	@Override Profile setName(String name);
	
}
