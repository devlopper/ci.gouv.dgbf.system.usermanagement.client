package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputString;
import org.cyk.utility.client.controller.component.annotation.InputStringLineMany;
import org.cyk.utility.client.controller.component.annotation.InputStringLineOne;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedImpl;

public class RoleFunctionImpl extends AbstractDataIdentifiedByStringAndCodedImpl implements RoleFunction,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputString @InputStringLineOne @NotNull
	private String name;
	
	@Input @InputString @InputStringLineMany
	private String description;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public RoleFunction setName(String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public RoleFunction setDescription(String description) {
		this.description = description;
		return this;
	}
	
	@Override
	public RoleFunction setIdentifier(Object identifier) {
		return (RoleFunction) super.setIdentifier(identifier);
	}
	
	@Override
	public RoleFunction setCode(String code) {
		return (RoleFunction) super.setCode(code);
	}
	
}
