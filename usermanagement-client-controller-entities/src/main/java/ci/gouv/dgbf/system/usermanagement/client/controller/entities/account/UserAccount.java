package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.util.Collection;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

public interface UserAccount extends DataIdentifiedByString {

	@Override UserAccount setIdentifier(Object identifier);
	
	User getUser();
	User getUser(Boolean injectIfNull);
	UserAccount setUser(User user);
	
	Account getAccount();
	Account getAccount(Boolean injectIfNull);
	UserAccount setAccount(Account account);
	
	Roles getRoles();
	Roles getRoles(Boolean injectIfNull);
	UserAccount setRoles(Roles roles);
	UserAccount addRoles(Collection<Role> roles);
	UserAccount addRoles(Role...roles);
	
	/**/
	
	String PROPERTY_USER = "user";
	String PROPERTY_ACCOUNT = "account";
	String PROPERTY_ROLES = "roles";
}
