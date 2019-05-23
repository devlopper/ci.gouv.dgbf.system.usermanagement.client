package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndLinkedByStringAndNamed;

public interface Program extends DataIdentifiedByStringAndLinkedByStringAndNamed {

	@Override Program setIdentifier(String identifier);
	
}
