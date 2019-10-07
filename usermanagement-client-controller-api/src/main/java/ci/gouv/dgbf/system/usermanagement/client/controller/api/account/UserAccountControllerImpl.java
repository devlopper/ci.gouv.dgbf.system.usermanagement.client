package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.__kernel__.session.Session;
import org.cyk.utility.__kernel__.session.SessionHelper;
import org.cyk.utility.__kernel__.string.StringHelper;
import org.cyk.utility.__kernel__.system.action.SystemAction;
import org.cyk.utility.client.controller.AbstractControllerEntityImpl;
import org.cyk.utility.client.controller.ControllerServiceProvider;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.server.Constant;

@ApplicationScoped
public class UserAccountControllerImpl extends AbstractControllerEntityImpl<UserAccount> implements UserAccountController,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public UserAccount readLoggedIn(Session session,Properties properties) {
		if(session == null)
			return null;
		String identifier = (String) session.getUserAttributeIdentifier();
		if(StringHelper.isBlank(identifier))
			return null;
		return readBySystemIdentifier(identifier,properties);
	}
	
	@Override
	public UserAccount readLoggedIn(Session session) {
		return readLoggedIn(session,null);
	}
	
	@Override
	public UserAccount readLoggedIn(Properties properties) {
		return readLoggedIn(SessionHelper.getAttributeSession(),properties);
	}
	
	@Override
	public UserAccount readLoggedIn() {
		return readLoggedIn(SessionHelper.getAttributeSession(),null);
	}
	
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
