package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputString;
import org.cyk.utility.client.controller.component.annotation.InputStringLineMany;
import org.cyk.utility.client.controller.component.annotation.InputStringLineOne;
import org.cyk.utility.client.controller.data.AbstractDataImpl;

public class RolePosteImpl extends AbstractDataImpl implements RolePoste,Serializable {
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
	public RolePoste setName(String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public RolePoste setDescription(String description) {
		this.description = description;
		return this;
	}
	
	@Override
	public RolePoste setIdentifier(Object identifier) {
		return (RolePoste) super.setIdentifier(identifier);
	}
	
	@Override
	public RolePoste setCode(String code) {
		return (RolePoste) super.setCode(code);
	}
	
}
