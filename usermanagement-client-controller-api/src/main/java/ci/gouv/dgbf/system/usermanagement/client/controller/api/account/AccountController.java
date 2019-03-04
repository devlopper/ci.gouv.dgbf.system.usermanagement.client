package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import org.cyk.utility.client.controller.ControllerEntity;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Account;

public interface AccountController extends ControllerEntity<Account> {

	AccountController authenticate(Account account);
	
}
