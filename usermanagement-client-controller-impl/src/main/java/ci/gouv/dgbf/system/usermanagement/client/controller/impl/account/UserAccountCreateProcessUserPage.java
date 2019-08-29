package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.User;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountCreateProcessUserPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private User user;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		//users = (List<User>) __inject__(UserController.class).read(new Properties().setIsPageable(Boolean.FALSE));
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Création de compte utilisateur pour "+user.getNames();
	}
}
