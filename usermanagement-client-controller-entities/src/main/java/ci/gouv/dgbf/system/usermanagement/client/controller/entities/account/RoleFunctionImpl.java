package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputChoice;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOne;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOneRadio;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedAndNamedImpl;

public class RoleFunctionImpl extends AbstractDataIdentifiedByStringAndCodedAndNamedImpl implements RoleFunction,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputChoice @InputChoiceOne @InputChoiceOneRadio
	private RoleCategory category;
	
	@Override
	public RoleCategory getCategory() {
		return category;
	}
	
	@Override
	public RoleFunction setCategory(RoleCategory category) {
		this.category = category;
		return this;
	}
	
	@Override
	public RoleFunction setIdentifier(String identifier) {
		return (RoleFunction) super.setIdentifier(identifier);
	}
	
	@Override
	public RoleFunction setCode(String code) {
		return (RoleFunction) super.setCode(code);
	}
	
	@Override
	public RoleFunction setName(String name) {
		return (RoleFunction) super.setName(name);
	}
}
