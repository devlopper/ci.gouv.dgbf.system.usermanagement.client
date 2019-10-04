package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.__kernel__.system.action.SystemActionCustom;
import org.cyk.utility.client.controller.component.command.Commandable;
import org.cyk.utility.client.controller.component.command.CommandableBuilder;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.primefaces.model.DualListModel;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.UserAccountController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.FunctionController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Account;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.User;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Function;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountCreatePage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private UserAccount userAccount;
	@NotNull
	private String firstName,lastNames,electronicMailAddress,userIdentifier,pass,passConfirmation;
	private DualListModel<Function> functions;
	private Commandable createCommandable;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		userAccount = __inject__(UserAccount.class);
		userAccount.setUser(__inject__(User.class));
		userAccount.setAccount(__inject__(Account.class));
		
		functions = __injectPrimefacesHelper__().buildDualList(__inject__(FunctionController.class).read(new Properties().setIsPageable(Boolean.FALSE)), null);
		
		CommandableBuilder saveCommandableBuilder = __inject__(CommandableBuilder.class);
		saveCommandableBuilder.setName("Créer").setCommandFunctionActionClass(SystemActionCustom.class).addCommandFunctionTryRunRunnable(
			new Runnable() {
				@Override
				public void run() {
					save();
				}
			}
		);
		createCommandable = saveCommandableBuilder.execute().getOutput();
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Identification et création de compte utilisateur";
	}
	
	public void save() {
		userAccount.getUser().setFirstName(firstName);
		userAccount.getUser().setLastNames(lastNames);
		userAccount.getUser().setElectronicMailAddress(electronicMailAddress);
		userAccount.getAccount().setIdentifier(userIdentifier);
		userAccount.getAccount().setPass(pass);
		userAccount.getAccount().setPassConfirmation(passConfirmation);
		userAccount.getFunctions(Boolean.TRUE).clear();
		if(functions.getTarget()!=null) {
			for(Function index : functions.getTarget())
				userAccount.getFunctions(Boolean.TRUE).add(index);
		}
		__inject__(UserAccountController.class).create(userAccount);
	}
}
