package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputChoice;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOne;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOneCombo;
import org.cyk.utility.client.controller.component.annotation.InputString;
import org.cyk.utility.client.controller.component.annotation.InputStringLineMany;
import org.cyk.utility.client.controller.component.annotation.InputStringLineOne;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedImpl;

public class RoleImpl extends AbstractDataIdentifiedByStringAndCodedImpl implements Role,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputString @InputStringLineOne @NotNull
	private String name;
	
	@Input @InputString @InputStringLineMany
	private String description;
	
	@Input @InputChoice @InputChoiceOne @InputChoiceOneCombo @NotNull
	private RoleType type;
	
	@Override
	public RoleType getType() {
		return type;
	}

	@Override
	public Role setType(RoleType type) {
		this.type = type;
		return this;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public Role setName(String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public Role setDescription(String description) {
		this.description = description;
		return this;
	}
	
	@Override
	public Role setIdentifier(Object identifier) {
		return (Role) super.setIdentifier(identifier);
	}
	
	@Override
	public Role setCode(String code) {
		return (Role) super.setCode(code);
	}

}
