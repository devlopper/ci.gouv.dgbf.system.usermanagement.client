package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.omnifaces.util.Faces;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.UserAccountController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountReadPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private UserAccount userAccount;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		userAccount = __inject__(UserAccountController.class).readBySystemIdentifier(Faces.getRequestParameter("identifier")
				, new Properties().setFields("identifier,user,user.functions,account,profiles,profile.privileges,scopes"));
	}
	
	public void editIdentity() {
		
	}
	
	public void editPassword() {
		
	}
	
	public void editScopes() {
		__injectPrimefacesHelper__().openDialog("userAccountAssignScopesProcessUserAccountView", userAccount.getIdentifier());
	}
	
	public void editPrivileges() {
		__injectPrimefacesHelper__().openDialog("userAccountAssignPrivilegesProcessUserAccountView", userAccount.getIdentifier());
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Compte utilisateur : "+userAccount.getAccount().getIdentifier();
	}
	
}
