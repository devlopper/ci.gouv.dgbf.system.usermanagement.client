package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import ci.gouv.dgbf.system.usermanagement.client.controller.impl.AbstractUserAccountBasedPageContainerManagedImplMonCompte;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class AccountEditMyPassPage extends AbstractUserAccountBasedPageContainerManagedImplMonCompte implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	private String actualPass,newPass,newPassConfirmation;
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Changer mon mot de passe";
	}
	
}
