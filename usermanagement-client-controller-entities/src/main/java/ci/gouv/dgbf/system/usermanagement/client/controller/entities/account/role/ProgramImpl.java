package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndLinkedByStringAndNamedImpl;

public class ProgramImpl extends AbstractDataIdentifiedByStringAndLinkedByStringAndNamedImpl implements Program,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public Program setIdentifier(String identifier) {
		return (Program) super.setIdentifier(identifier);
	}
	
}
