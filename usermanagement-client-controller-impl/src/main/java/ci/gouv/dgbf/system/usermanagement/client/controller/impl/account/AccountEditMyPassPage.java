package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.impl.AbstractPageContainerManagedImpl;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class AccountEditMyPassPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private UserAccount userAccount;
	@NotNull
	private String actualPass,newPass,newPassConfirmation;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		userAccount = readLoggedIn();
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Changer mon mot de passe";
	}
	
}
