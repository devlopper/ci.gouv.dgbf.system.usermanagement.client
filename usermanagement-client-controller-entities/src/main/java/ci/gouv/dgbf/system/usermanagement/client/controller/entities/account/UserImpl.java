package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputString;
import org.cyk.utility.client.controller.component.annotation.InputStringLineOne;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedImpl;

public class UserImpl extends AbstractDataIdentifiedByStringAndCodedImpl implements User,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputString @InputStringLineOne @NotNull private String firstName;
	@Input @InputString @InputStringLineOne @NotNull private String lastNames;
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
	public String getFirstName() {
		return firstName;
	}
	
	@Override
	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	@Override
	public String getLastNames() {
		return lastNames;
	}
	
	@Override
	public User setLastNames(String lastNames) {
		this.lastNames = lastNames;
		return this;
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
