package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedAndNamedImpl;

public class FunctionCategoryImpl extends AbstractDataIdentifiedByStringAndCodedAndNamedImpl implements FunctionCategory,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public FunctionCategory setIdentifier(String identifier) {
		return (FunctionCategory) super.setIdentifier(identifier);
	}
	
	@Override
	public FunctionCategory setCode(String code) {
		return (FunctionCategory) super.setCode(code);
	}
	
	@Override
	public FunctionCategory setName(String name) {
		return (FunctionCategory) super.setName(name);
	}
}
