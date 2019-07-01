package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputString;
import org.cyk.utility.client.controller.component.annotation.InputStringLineOne;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringImpl;
import org.cyk.utility.string.StringHelper;

public class UserImpl extends AbstractDataIdentifiedByStringImpl implements User,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputString @InputStringLineOne @NotNull private String firstName;
	@Input @InputString @InputStringLineOne @NotNull private String lastNames;
	@Input @InputString @InputStringLineOne @NotNull private String electronicMailAddress;
	private String names;
	
	@Override
	public User setIdentifier(String identifier) {
		return (User) super.setIdentifier(identifier);
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
	public String getNames() {
		if(names == null) {
			names = firstName;
			if(Boolean.TRUE.equals(__inject__(StringHelper.class).isNotBlank(lastNames)))
				names += " " + lastNames; 
		}
		return names;
	}
	
	@Override
	public User setNames(String names) {
		this.names = names;
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
}
