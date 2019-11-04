package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.identifier.resource.ProxyGetter;
import org.cyk.utility.client.controller.AbstractControllerEntityImpl;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Account;
import ci.gouv.dgbf.system.usermanagement.server.representation.api.account.AccountRepresentation;

@ApplicationScoped
public class AccountControllerImpl extends AbstractControllerEntityImpl<Account> implements AccountController,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public AccountController sendUpdatePasswordEmailByPrincipalName(String principalName) {
		ProxyGetter.getInstance().get(AccountRepresentation.class).sendUpdatePasswordEmailByPrincipalName(principalName);
		return this;
	}
	
}
