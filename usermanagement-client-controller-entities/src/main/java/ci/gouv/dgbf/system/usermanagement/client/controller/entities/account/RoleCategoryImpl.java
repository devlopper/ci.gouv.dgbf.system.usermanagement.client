package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputString;
import org.cyk.utility.client.controller.component.annotation.InputStringLineMany;
import org.cyk.utility.client.controller.component.annotation.InputStringLineOne;
import org.cyk.utility.client.controller.data.AbstractDataImpl;

public class RoleCategoryImpl extends AbstractDataImpl implements RoleCategory,Serializable {
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
	public RoleCategory setName(String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public RoleCategory setDescription(String description) {
		this.description = description;
		return this;
	}
	
	@Override
	public RoleCategory setIdentifier(Object identifier) {
		return (RoleCategory) super.setIdentifier(identifier);
	}
	
	@Override
	public RoleCategory setCode(String code) {
		return (RoleCategory) super.setCode(code);
	}
	
}
