package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.AbstractControllerEntityImpl;
import org.cyk.utility.client.controller.ControllerServiceProvider;
import org.cyk.utility.system.action.SystemAction;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.server.Constant;

@ApplicationScoped
public class UserAccountControllerImpl extends AbstractControllerEntityImpl<UserAccount> implements UserAccountController,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public ControllerServiceProvider<UserAccount> process(UserAccount userAccount, Properties properties) {
		SystemAction systemAction = (SystemAction) properties.getSystemAction();
		if(Constant.SYSTEM_ACTION_IDENTIFIER_ASSIGN_PRIVILEGES.equals(systemAction.getIdentifier())) {
			update(userAccount,new Properties().setSystemAction(systemAction).setFields(UserAccount.PROPERTY_PROFILES));
		}else if(Constant.SYSTEM_ACTION_IDENTIFIER_ASSIGN_FUNCTION_SCOPES.equals(systemAction.getIdentifier())) {
			update(userAccount,new Properties().setSystemAction(systemAction).setFields(UserAccount.PROPERTY_FUNCTION_SCOPES));
		}
		return this;
	}
	
}
