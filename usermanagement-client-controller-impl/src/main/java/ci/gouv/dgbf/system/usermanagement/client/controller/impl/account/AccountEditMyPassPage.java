package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.__kernel__.security.SecurityHelper;
import org.cyk.utility.__kernel__.system.action.SystemActionCustom;
import org.cyk.utility.client.controller.component.command.Commandable;
import org.cyk.utility.client.controller.component.command.CommandableBuilder;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.AccountController;
import ci.gouv.dgbf.system.usermanagement.client.controller.impl.AbstractUserAccountBasedPageContainerManagedImplMonCompte;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class AccountEditMyPassPage extends AbstractUserAccountBasedPageContainerManagedImplMonCompte implements Serializable {
	private static final long serialVersionUID = 1L;

	//@NotNull
	//private String actualPass,newPass,newPassConfirmation;
	private Commandable sendEmailCommandable;
	
	@Override
	protected void __listenPostConstructUserAccountIsNotNull__() {
		super.__listenPostConstructUserAccountIsNotNull__();
		CommandableBuilder commandableBuilder = __inject__(CommandableBuilder.class);
		commandableBuilder.setName("M'envoyer un mail").setCommandFunctionActionClass(SystemActionCustom.class).addCommandFunctionTryRunRunnable(
			new Runnable() {
				@Override
				public void run() {
					sendEmail();
				}
			}
		);
		sendEmailCommandable = commandableBuilder.execute().getOutput();
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Changer mon mot de passe";
	}

	private void sendEmail() {
		__inject__(AccountController.class).sendUpdatePasswordEmailByPrincipalName(SecurityHelper.getPrincipal().getName());
	}
}
