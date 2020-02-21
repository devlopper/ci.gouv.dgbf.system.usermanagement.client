package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputBoolean;
import org.cyk.utility.client.controller.component.annotation.InputBooleanButton;
import org.cyk.utility.client.controller.component.annotation.InputChoice;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOne;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOneRadio;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedAndNamedImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class Function extends AbstractDataIdentifiedByStringAndCodedAndNamedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputChoice @InputChoiceOne @InputChoiceOneRadio
	private FunctionType type;
	
	@Input @InputBoolean @InputBooleanButton
	private Boolean isProfileCreatableOnCreate;
	
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
