package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.AbstractDataImpl;

public class UserAccountImpl extends AbstractDataImpl implements UserAccount,Serializable {
	private static final long serialVersionUID = 1L;

	private User user;
	private Account account;
	
	@Override
	public UserAccount setIdentifier(Object identifier) {
		return (UserAccount) super.setIdentifier(identifier);
	}
	
	@Override
	public UserAccount setCode(String code) {
		return (UserAccount) super.setCode(code);
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public UserAccount setUser(User user) {
		this.user = user;
		return this;
	}

	@Override
	public Account getAccount() {
		return account;
	}

	@Override
	public UserAccount setAccount(Account account) {
		this.account = account;
		return this;
	}
	
}
