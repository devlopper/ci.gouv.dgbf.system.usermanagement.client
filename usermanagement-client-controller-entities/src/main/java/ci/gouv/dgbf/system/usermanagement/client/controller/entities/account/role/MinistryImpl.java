package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringImpl;

public class MinistryImpl extends AbstractDataIdentifiedByStringImpl implements Ministry,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public Ministry setIdentifier(String identifier) {
		return (Ministry) super.setIdentifier(identifier);
	}
	
}
