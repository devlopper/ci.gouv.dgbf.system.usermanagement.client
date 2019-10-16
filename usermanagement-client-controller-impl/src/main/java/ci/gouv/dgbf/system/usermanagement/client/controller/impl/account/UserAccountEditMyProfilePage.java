package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Function;
import ci.gouv.dgbf.system.usermanagement.client.controller.impl.AbstractUserAccountBasedPageContainerManagedImpl;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountEditMyProfilePage extends AbstractUserAccountBasedPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private User user = new User();
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		user.setFirstName(userAccount.getUser().getFirstName());
		user.setLastNames(userAccount.getUser().getLastNames());
		user.setElectronicMailAddress(userAccount.getUser().getElectronicMailAddress());
		
		user.setFunctions(new DualListModel<Function>());
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Modifier mon profile";
	}
	
}
