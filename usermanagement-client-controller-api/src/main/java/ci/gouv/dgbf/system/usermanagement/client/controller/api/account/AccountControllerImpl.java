package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import java.io.Serializable;

import javax.inject.Singleton;

import org.cyk.utility.client.controller.AbstractControllerEntityImpl;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Account;

@Singleton
public class AccountControllerImpl extends AbstractControllerEntityImpl<Account> implements AccountController,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public AccountController authenticate(Account account) {
		//__inject__(Acco, annotationLiterals)
		return this;
	}
	
}
