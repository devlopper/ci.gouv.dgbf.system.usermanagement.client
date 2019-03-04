package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import java.io.Serializable;

import javax.inject.Singleton;

import org.cyk.utility.client.controller.AbstractControllerEntityImpl;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;

@Singleton
public class UserAccountControllerImpl extends AbstractControllerEntityImpl<UserAccount> implements UserAccountController,Serializable {
	private static final long serialVersionUID = 1L;
	
}
