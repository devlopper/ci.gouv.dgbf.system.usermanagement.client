package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputString;
import org.cyk.utility.client.controller.component.annotation.InputStringLineOne;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedImpl;

public class AccountImpl extends AbstractDataIdentifiedByStringAndCodedImpl implements Account,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputString @InputStringLineOne @NotNull private String pass;
	
	@Override
	public Account setIdentifier(Object identifier) {
		return (Account) super.setIdentifier(identifier);
	}
	
	@Override
	public Account setCode(String code) {
		return (Account) super.setCode(code);
	}

	@Override
	public String getPass() {
		return pass;
	}

	@Override
	public Account setPass(String pass) {
		this.pass = pass;
		return this;
	}
	
}
