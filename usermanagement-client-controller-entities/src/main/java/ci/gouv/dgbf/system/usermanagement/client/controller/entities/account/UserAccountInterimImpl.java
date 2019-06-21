package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputDateTime;

public class UserAccountInterimImpl extends AbstractUserAccountInterimCommonImpl implements UserAccountInterim,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputDateTime
	private LocalDateTime fromDate;
	
	@Input @InputDateTime
	private LocalDateTime toDate;
	
	@Override
	public UserAccountInterim setIdentifier(String identifier) {
		return (UserAccountInterim) super.setIdentifier(identifier);
	}
	
	@Override
	public LocalDateTime getFromDate() {
		return fromDate;
	}
	
	@Override
	public UserAccountInterim setFromDate(LocalDateTime fromDate) {
		this.fromDate = fromDate;
		return this;
	}
	
	@Override
	public LocalDateTime getToDate() {
		return toDate;
	}
	
	@Override
	public UserAccountInterim setToDate(LocalDateTime toDate) {
		this.toDate = toDate;
		return this;
	}
	
	
	@Override
	public UserAccountInterim setUserAccount(UserAccount userAccount) {
		return (UserAccountInterim) super.setUserAccount(userAccount);
	}
	
	@Override
	public UserAccountInterim setInterim(UserAccount interim) {
		return (UserAccountInterim) super.setInterim(interim);
	}
	
}
