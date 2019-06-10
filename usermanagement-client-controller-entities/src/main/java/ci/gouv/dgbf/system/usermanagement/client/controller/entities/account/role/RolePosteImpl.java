package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputChoice;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOne;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOneAutoComplete;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOneCombo;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedAndNamedImpl;

public class RolePosteImpl extends AbstractDataIdentifiedByStringAndCodedAndNamedImpl implements RolePoste,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputChoice @InputChoiceOne @InputChoiceOneCombo
	@NotNull
	private RoleFunction function;
	
	@Input @InputChoice @InputChoiceOne @InputChoiceOneAutoComplete
	private PosteLocation location;
	
	@Override
	public RoleFunction getFunction() {
		return function;
	}
	@Override
	public RolePoste setFunction(RoleFunction function) {
		this.function = function;
		return this;
	}
	
	@Override
	public PosteLocation getLocation() {
		return location;
	}
	
	@Override
	public RolePoste setLocation(PosteLocation location) {
		this.location = location;
		return this;
	}
	
	@Override
	public RolePoste setIdentifier(String identifier) {
		return (RolePoste) super.setIdentifier(identifier);
	}
	
	@Override
	public RolePoste setCode(String code) {
		return (RolePoste) super.setCode(code);
	}
	
	@Override
	public RolePoste setName(String name) {
		return (RolePoste) super.setName(name);
	}
}
