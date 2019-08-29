package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.User;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountCreateListUserPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<User> users;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		//users = (List<User>) __inject__(UserController.class).read(new Properties().setIsPageable(Boolean.FALSE));
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Liste des demandes de création de compte utilisateur";
	}
}
