package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringImpl;

public class AdministrativeUnitImpl extends AbstractDataIdentifiedByStringImpl implements AdministrativeUnit,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public AdministrativeUnit setIdentifier(String identifier) {
		return (AdministrativeUnit) super.setIdentifier(identifier);
	}
	
}
