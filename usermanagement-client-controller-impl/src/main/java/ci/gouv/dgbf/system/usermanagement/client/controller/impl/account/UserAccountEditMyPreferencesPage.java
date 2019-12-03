package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.__kernel__.system.action.SystemActionCustom;
import org.cyk.utility.client.controller.component.command.Commandable;
import org.cyk.utility.client.controller.component.command.CommandableBuilder;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.UserAccountController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.impl.AbstractUserAccountBasedPageContainerManagedImplMonCompte;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountEditMyPreferencesPage extends AbstractUserAccountBasedPageContainerManagedImplMonCompte implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<SelectItem> colors;
	private String color;
	private Commandable saveCommandable;
	
	@Override
	protected void __listenPostConstructUserAccountIsNotNull__() {
		super.__listenPostConstructUserAccountIsNotNull__();
		color = userAccount.getColor();
		colors = new ArrayList<>();
		colors.add(new SelectItem("orange", "Orange"));
		colors.add(new SelectItem("blue", "Bleu"));
		colors.add(new SelectItem("light-blue", "Bleu ciel"));
		colors.add(new SelectItem("green", "Vert"));
		
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
		return "Mes préférences";
	}
	
	private void save() {
		userAccount.setColor(color);
		__inject__(UserAccountController.class).update(userAccount,new Properties().setFields(UserAccount.PROPERTY_COLOR));
		session.getUserInterface(Boolean.TRUE).getTheme(Boolean.TRUE).setColor(userAccount.getColor());
	}
	
}
