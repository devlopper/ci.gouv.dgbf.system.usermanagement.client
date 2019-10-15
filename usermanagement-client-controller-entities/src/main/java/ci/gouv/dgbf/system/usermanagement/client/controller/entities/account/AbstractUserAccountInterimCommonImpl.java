package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputChoice;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOne;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOneAutoComplete;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringImpl;

public abstract class AbstractUserAccountInterimCommonImpl extends AbstractDataIdentifiedByStringImpl implements UserAccountInterimCommon,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputChoice @InputChoiceOne @InputChoiceOneAutoComplete @NotNull
	private UserAccount userAccount;
	
	@Input @InputChoice @InputChoiceOne @InputChoiceOneAutoComplete @NotNull
	private UserAccount interim;
	
	@Override
	public UserAccountInterimCommon setIdentifier(String identifier) {
		return (UserAccountInterimCommon) super.setIdentifier(identifier);
	}

	@Override
	public UserAccount getUserAccount() {
		return userAccount;
	}
	
	@Override
	public UserAccount getUserAccount(Boolean injectIfNull) {
		if(userAccount == null && Boolean.TRUE.equals(injectIfNull))
			userAccount = __inject__(UserAccount.class);
		return userAccount;
	}

	@Override
	public UserAccountInterimCommon setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
		return this;
	}
	
	@Override
	public UserAccount getInterim() {
		return interim;
	}
	
	@Override
	public UserAccount getInterim(Boolean injectIfNull) {
		if(interim == null && Boolean.TRUE.equals(injectIfNull))
			interim = __inject__(UserAccount.class);
		return interim;
	}

	@Override
	public UserAccountInterimCommon setInterim(UserAccount interim) {
		this.interim = interim;
		return this;
	}
	
}
