package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.__kernel__.system.action.SystemActionCustom;
import org.cyk.utility.client.controller.component.command.Commandable;
import org.cyk.utility.client.controller.component.command.CommandableBuilder;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.UserAccountController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.FunctionController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.impl.AbstractUserAccountBasedPageContainerManagedImpl;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountEditMyProfilePage extends AbstractUserAccountBasedPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private User user = new User();
	private Commandable saveCommandable;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		user.setFirstName(userAccount.getUser().getFirstName());
		user.setLastNames(userAccount.getUser().getLastNames());
		user.setElectronicMailAddress(userAccount.getUser().getElectronicMailAddress());
		user.setFunctions(__injectPrimefacesHelper__().buildDualList(__inject__(FunctionController.class).read(new Properties().setIsPageable(Boolean.FALSE))
				, userAccount.getFunctions()));
		
		CommandableBuilder saveCommandableBuilder = __inject__(CommandableBuilder.class);
		saveCommandableBuilder.setName("Enregistrer").setCommandFunctionActionClass(SystemActionCustom.class).addCommandFunctionTryRunRunnable(
			new Runnable() {
				@Override
				public void run() {
					save();
				}
			}
		);
		saveCommandableBuilder.addUpdatables("outputPanel");
		saveCommandable = saveCommandableBuilder.execute().getOutput();
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Modifier mon profile";
	}
	
	@Override
	protected Collection<String> __getReadLoggedInPropertiesFields__() {
		return List.of(UserAccount.PROPERTY_IDENTIFIER,UserAccount.PROPERTY_USER,UserAccount.PROPERTY_FUNCTIONS);
	}
	
	private void save() {
		userAccount.getUser().setFirstName(user.getFirstName());
		userAccount.getUser().setLastNames(user.getLastNames());
		userAccount.getUser().setElectronicMailAddress(user.getElectronicMailAddress());
		userAccount.getUser().setFunctions(user.getFunctions().getTarget());
		__inject__(UserAccountController.class).update(userAccount,new Properties()
				.setFields(
						UserAccount.PROPERTY_USER+"."+ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.User.PROPERTY_FIRST_NAME
						+","+UserAccount.PROPERTY_USER+"."+ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.User.PROPERTY_LAST_NAMES
						+","+UserAccount.PROPERTY_USER+"."+ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.User.PROPERTY_ELECTRONIC_MAIL_ADDRESS
						+","+UserAccount.PROPERTY_USER+"."+ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.User.PROPERTY_FUNCTIONS));
	}
}
