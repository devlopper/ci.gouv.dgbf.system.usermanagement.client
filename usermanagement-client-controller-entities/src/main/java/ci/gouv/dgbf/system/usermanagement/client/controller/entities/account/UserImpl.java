package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputString;
import org.cyk.utility.client.controller.component.annotation.InputStringLineOne;
import org.cyk.utility.client.controller.data.AbstractDataImpl;

public class UserImpl extends AbstractDataImpl implements User,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputString @InputStringLineOne @NotNull private String electronicMailAddress;
	private UserNaturalPerson person;
	
	@Override
	public User setIdentifier(Object identifier) {
		return (User) super.setIdentifier(identifier);
	}
	
	@Override
	public User setCode(String code) {
		return (User) super.setCode(code);
	}

	@Override
	public String getElectronicMailAddress() {
		return electronicMailAddress;
	}

	@Override
	public User setElectronicMailAddress(String electronicMailAddress) {
		this.electronicMailAddress = electronicMailAddress;
		return this;
	}

	@Override
	public UserNaturalPerson getPerson() {
		return person;
	}

	@Override
	public User setPerson(UserNaturalPerson person) {
		this.person = person;
		return this;
	}
	
}
