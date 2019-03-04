package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.Data;

public interface UserAccount extends Data {

	@Override UserAccount setIdentifier(Object identifier);
	@Override UserAccount setCode(String code);
	
	User getUser();
	UserAccount setUser(User user);
	
	Account getAccount();
	UserAccount setAccount(Account account);
	
	/**/
	
	String PROPERTY_USER = "user";
	String PROPERTY_ACCOUNT = "account";
	
}
