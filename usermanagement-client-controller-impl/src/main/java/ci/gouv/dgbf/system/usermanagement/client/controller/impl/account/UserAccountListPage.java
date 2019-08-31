package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.cyk.utility.client.controller.web.jsf.primefaces.LazyDataModel;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountListPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private LazyDataModel<UserAccount> userAccounts = new LazyDataModel<>(UserAccount.class);
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Liste de compte utilisateur";
	}
	
}
