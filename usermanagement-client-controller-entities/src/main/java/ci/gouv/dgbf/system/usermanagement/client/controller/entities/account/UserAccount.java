package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

public interface UserAccount extends DataIdentifiedByString {

	@Override UserAccount setIdentifier(Object identifier);
	
	User getUser();
	UserAccount setUser(User user);
	
	Account getAccount();
	UserAccount setAccount(Account account);
	
	/**/
	
	String PROPERTY_USER = "user";
	String PROPERTY_ACCOUNT = "account";
	
}
