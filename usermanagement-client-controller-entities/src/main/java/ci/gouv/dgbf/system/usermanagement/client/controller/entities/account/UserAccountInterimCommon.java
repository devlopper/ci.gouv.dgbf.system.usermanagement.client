package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

public interface UserAccountInterimCommon extends DataIdentifiedByString {

	@Override UserAccountInterimCommon setIdentifier(String identifier);
	
	UserAccount getUserAccount();
	UserAccount getUserAccount(Boolean injectIfNull);
	UserAccountInterimCommon setUserAccount(UserAccount userAccount);
	
	UserAccount getInterim();
	UserAccount getInterim(Boolean injectIfNull);
	UserAccountInterimCommon setInterim(UserAccount interim);
	
	/**/
	
	String PROPERTY_USER_ACCOUNT = "userAccount";
	String PROPERTY_INTERIM = "interim";
	
}
