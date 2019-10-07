package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.__kernel__.session.Session;
import org.cyk.utility.client.controller.ControllerEntity;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;

public interface UserAccountController extends ControllerEntity<UserAccount> {

	UserAccount readLoggedIn(Session session,Properties properties);
	UserAccount readLoggedIn(Properties properties);
	UserAccount readLoggedIn(Session session);
	UserAccount readLoggedIn();
}
