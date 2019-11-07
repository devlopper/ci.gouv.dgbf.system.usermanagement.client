package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.cyk.utility.__kernel__.string.StringHelper;
import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputChoice;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOne;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOneCombo;
import org.cyk.utility.client.controller.component.annotation.InputString;
import org.cyk.utility.client.controller.component.annotation.InputStringLineOne;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndLinkedByStringAndNamedImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class ScopeImpl extends AbstractDataIdentifiedByStringAndLinkedByStringAndNamedImpl implements Scope,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter @Accessors(chain=true)
	@NotNull
	@Input @InputChoice @InputChoiceOne @InputChoiceOneCombo
	private ScopeType type;
	
	@Getter @Setter @Accessors(chain=true) 
	@NotNull
	@Input @InputString @InputStringLineOne	
	private String code;
	
	@Override
	public Scope setIdentifier(String identifier) {
		return (Scope) super.setIdentifier(identifier);
	}
	
	@Override
	public String getCodeAndName() {
		String name = getName();
		if(StringHelper.isBlank(name))
			return getCode();
		return getCode()+" "+name;
	}
}
