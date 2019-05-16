package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;
import java.util.Collection;

import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringImpl;

public class UserAccountImpl extends AbstractDataIdentifiedByStringImpl implements UserAccount,Serializable {
	private static final long serialVersionUID = 1L;

	private User user;
	private Account account;
	private Roles roles;
	
	@Override
	public UserAccount setIdentifier(Object identifier) {
		return (UserAccount) super.setIdentifier(identifier);
	}

	@Override
	public User getUser() {
		return user;
	}
	
	@Override
	public User getUser(Boolean injectIfNull) {
		return (User) __getInjectIfNull__(PROPERTY_USER, injectIfNull);
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
	public Account getAccount(Boolean injectIfNull) {
		return (Account) __getInjectIfNull__(PROPERTY_ACCOUNT, injectIfNull);
	}

	@Override
	public UserAccount setAccount(Account account) {
		this.account = account;
		return this;
	}
	
	@Override
	public Roles getRoles() {
		return roles;
	}
	
	@Override
	public UserAccount setRoles(Roles roles) {
		this.roles = roles;
		return this;
	}
	
	@Override
	public Roles getRoles(Boolean injectIfNull) {
		return (Roles) __getInjectIfNull__(FIELD_ROLES, injectIfNull);
	}
	
	@Override
	public UserAccount addRoles(Collection<Role> roles) {
		getRoles(Boolean.TRUE).add(roles);
		return this;
	}
	
	@Override
	public UserAccount addRoles(Role... roles) {
		getRoles(Boolean.TRUE).add(roles);
		return this;
	}
	
	/**/
	
	public static final String FIELD_ROLES = "roles";
	
}
