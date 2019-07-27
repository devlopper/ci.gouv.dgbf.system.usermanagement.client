package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedAndNamedImpl;

public class FunctionTypeImpl extends AbstractDataIdentifiedByStringAndCodedAndNamedImpl implements FunctionType,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public FunctionType setIdentifier(String identifier) {
		return (FunctionType) super.setIdentifier(identifier);
	}
	
	@Override
	public FunctionType setCode(String code) {
		return (FunctionType) super.setCode(code);
	}
	
	@Override
	public FunctionType setName(String name) {
		return (FunctionType) super.setName(name);
	}
}
