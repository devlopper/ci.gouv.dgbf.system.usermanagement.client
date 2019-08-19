package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.UserAccountController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountScopeAssignListUserAccountPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<UserAccount> userAccounts;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		userAccounts = (List<UserAccount>) __inject__(UserAccountController.class).read(new Properties().setIsPageable(Boolean.FALSE));
	}
	
	public void selectUserAccount(UserAccount userAccount) {
		__injectPrimefacesHelper__().openDialog("processuseraccount", userAccount.getIdentifier());
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Affectation de domaine de visibilité";
	}
}
