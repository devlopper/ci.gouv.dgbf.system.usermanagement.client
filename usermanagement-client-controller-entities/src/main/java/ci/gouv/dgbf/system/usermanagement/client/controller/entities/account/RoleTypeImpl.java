package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputString;
import org.cyk.utility.client.controller.component.annotation.InputStringLineMany;
import org.cyk.utility.client.controller.component.annotation.InputStringLineOne;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedImpl;

public class RoleTypeImpl extends AbstractDataIdentifiedByStringAndCodedImpl implements RoleType,Serializable {
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
	public RoleType setName(String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public RoleType setDescription(String description) {
		this.description = description;
		return this;
	}
	
	@Override
	public RoleType setIdentifier(Object identifier) {
		return (RoleType) super.setIdentifier(identifier);
	}
	
	@Override
	public RoleType setCode(String code) {
		return (RoleType) super.setCode(code);
	}
	
}
