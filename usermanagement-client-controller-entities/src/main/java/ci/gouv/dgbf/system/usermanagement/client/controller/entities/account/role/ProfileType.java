package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCodedAndNamed;

public interface ProfileType extends DataIdentifiedByStringAndCodedAndNamed {

	@Override ProfileType setIdentifier(Object identifier);
	@Override ProfileType setCode(String code);
	@Override ProfileType setName(String name);
}
