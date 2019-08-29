package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.client.controller.AbstractControllerEntityImpl;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccountScope;

@ApplicationScoped
public class UserAccountScopeControllerImpl extends AbstractControllerEntityImpl<UserAccountScope> implements UserAccountScopeController,Serializable {
	private static final long serialVersionUID = 1L;
	
}
