package ci.gouv.dgbf.system.usermanagement.client.controller.impl;

import java.io.Serializable;

import org.cyk.utility.__kernel__.properties.Properties;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.UserAccountController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;

public abstract class AbstractPageContainerManagedImpl extends org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	protected UserAccount readLoggedIn(Properties properties) {
		if(session == null)
			return null;
		return __inject__(UserAccountController.class).readLoggedIn(session,properties);
	}
	
	protected UserAccount readLoggedIn() {
		return readLoggedIn(null);
	}
	
}
