package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

public interface AdministrativeUnit extends DataIdentifiedByString {

	@Override AdministrativeUnit setIdentifier(String identifier);
	
}
