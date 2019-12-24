package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.AbstractDataIdentifiableSystemStringIdentifiableBusinessStringNamableImpl;

public class ScopeTypeImpl extends AbstractDataIdentifiableSystemStringIdentifiableBusinessStringNamableImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public ScopeTypeImpl setIdentifier(String identifier) {
		return (ScopeTypeImpl) super.setIdentifier(identifier);
	}
	
	@Override
	public ScopeTypeImpl setCode(String code) {
		return (ScopeTypeImpl) super.setCode(code);
	}
	
	@Override
	public ScopeTypeImpl setName(String name) {
		return (ScopeTypeImpl) super.setName(name);
	}
}
