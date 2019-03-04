package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputString;
import org.cyk.utility.client.controller.component.annotation.InputStringLineOne;
import org.cyk.utility.client.controller.data.AbstractDataImpl;

public class UserNaturalPersonImpl extends AbstractDataImpl implements UserNaturalPerson,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputString @InputStringLineOne @NotNull private String firstName;
	@Input @InputString @InputStringLineOne @NotNull private String lastNames;
	
	@Override
	public UserNaturalPerson setIdentifier(Object identifier) {
		return (UserNaturalPerson) super.setIdentifier(identifier);
	}
	
	@Override
	public UserNaturalPerson setCode(String code) {
		return (UserNaturalPerson) super.setCode(code);
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public UserNaturalPerson setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	@Override
	public String getLastNames() {
		return lastNames;
	}

	@Override
	public UserNaturalPerson setLastName(String lastNames) {
		this.lastNames = lastNames;
		return this;
	}

	
	
}
