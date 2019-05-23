package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringImpl;

public class ServiceImpl extends AbstractDataIdentifiedByStringImpl implements Service,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public Service setIdentifier(Object identifier) {
		return (Service) super.setIdentifier(identifier);
	}
	
}
