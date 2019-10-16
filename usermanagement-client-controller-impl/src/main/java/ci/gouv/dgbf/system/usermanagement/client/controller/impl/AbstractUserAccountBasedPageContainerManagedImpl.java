package ci.gouv.dgbf.system.usermanagement.client.controller.impl;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class AbstractUserAccountBasedPageContainerManagedImpl extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	protected UserAccount userAccount;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		userAccount = readLoggedIn();
	}
	
}
