package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

public interface Service extends DataIdentifiedByString {

	@Override Service setIdentifier(Object identifier);
	
}
