package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import java.io.Serializable;

import javax.inject.Singleton;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.AbstractControllerEntityImpl;
import org.cyk.utility.client.controller.ControllerServiceProvider;
import org.cyk.utility.system.action.SystemAction;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;

@Singleton
public class UserAccountControllerImpl extends AbstractControllerEntityImpl<UserAccount> implements UserAccountController,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public ControllerServiceProvider<UserAccount> process(UserAccount userAccount, Properties properties) {
		SystemAction systemAction = (SystemAction) properties.getSystemAction();
		if("assignrolepostes".equals(systemAction.getIdentifier())) {
			update(userAccount,new Properties().setFields(UserAccount.PROPERTY_ROLE_POSTES));
		}
		return this;
	}
	
}
