package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.client.controller.AbstractControllerEntityImpl;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccountFunctionScope;

@ApplicationScoped
public class UserAccountFunctionScopeControllerImpl extends AbstractControllerEntityImpl<UserAccountFunctionScope> implements UserAccountFunctionScopeController,Serializable {
	private static final long serialVersionUID = 1L;
	
}
