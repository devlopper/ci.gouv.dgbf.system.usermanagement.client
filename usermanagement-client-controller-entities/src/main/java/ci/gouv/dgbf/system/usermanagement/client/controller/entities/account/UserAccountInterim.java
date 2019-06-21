package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.time.LocalDateTime;

public interface UserAccountInterim extends UserAccountInterimCommon {

	@Override UserAccountInterim setIdentifier(String identifier);
	
	UserAccountInterim setUserAccount(UserAccount userAccount);
	
	UserAccountInterim setInterim(UserAccount interim);
	
	LocalDateTime getFromDate();
	UserAccountInterim setFromDate(LocalDateTime fromDate);
	
	LocalDateTime getToDate();
	UserAccountInterim setToDate(LocalDateTime toDate);
	
	/**/
	
	String PROPERTY_FROM_DATE = "fromDate";
	String PROPERTY_TO_DATE = "toDate";
	
}
