package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputBoolean;
import org.cyk.utility.client.controller.component.annotation.InputBooleanButton;
import org.cyk.utility.client.controller.component.annotation.InputChoice;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOne;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOneRadio;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedAndNamedImpl;

public class FunctionImpl extends AbstractDataIdentifiedByStringAndCodedAndNamedImpl implements Function,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputChoice @InputChoiceOne @InputChoiceOneRadio
	private FunctionType type;
	
	@Input @InputBoolean @InputBooleanButton
	private Boolean isProfileCreatableOnCreate;
	
	@Override
	public FunctionType getType() {
		return type;
	}
	
	@Override
	public Function setType(FunctionType type) {
		this.type = type;
		return this;
	}
	
	@Override
	public Boolean getIsProfileCreatableOnCreate() {
		return isProfileCreatableOnCreate;
	}
	
	@Override
	public Function setIsProfileCreatableOnCreate(Boolean isProfileCreatableOnCreate) {
		this.isProfileCreatableOnCreate = isProfileCreatableOnCreate;
		return this;
	}
	
	@Override
	public Function setIdentifier(String identifier) {
		return (Function) super.setIdentifier(identifier);
	}
	
	@Override
	public Function setCode(String code) {
		return (Function) super.setCode(code);
	}
	
	@Override
	public Function setName(String name) {
		return (Function) super.setName(name);
	}
}
