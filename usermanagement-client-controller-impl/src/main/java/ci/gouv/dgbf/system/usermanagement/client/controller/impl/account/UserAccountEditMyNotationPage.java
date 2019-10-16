package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.__kernel__.system.action.SystemActionCustom;
import org.cyk.utility.client.controller.component.command.Commandable;
import org.cyk.utility.client.controller.component.command.CommandableBuilder;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.UserAccountController;
import ci.gouv.dgbf.system.usermanagement.client.controller.impl.AbstractUserAccountBasedPageContainerManagedImpl;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountEditMyNotationPage extends AbstractUserAccountBasedPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull private Byte notation;
	private Commandable saveCommandable;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		notation = userAccount.getNotation();
		CommandableBuilder saveCommandableBuilder = __inject__(CommandableBuilder.class);
		saveCommandableBuilder.setName("Enregistrer").setCommandFunctionActionClass(SystemActionCustom.class).addCommandFunctionTryRunRunnable(
			new Runnable() {
				@Override
				public void run() {
					save();
				}
			}
		);
		saveCommandableBuilder.addUpdatables("panelGrid");
		saveCommandable = saveCommandableBuilder.execute().getOutput();
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Noter le SIIBC";
	}
	
	private void save() {
		userAccount.setNotation(notation);
		__inject__(UserAccountController.class).update(userAccount,new Properties().setFields("notation"));
	}
}
