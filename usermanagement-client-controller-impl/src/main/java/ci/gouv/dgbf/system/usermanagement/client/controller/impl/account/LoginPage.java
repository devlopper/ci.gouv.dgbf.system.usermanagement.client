package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.client.controller.component.window.WindowContainerManagedWindowBuilder;
import org.cyk.utility.client.controller.component.window.WindowContainerManagedWindowBuilderGetter;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.cyk.utility.system.action.SystemAction;
import org.cyk.utility.system.action.SystemActionCreate;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Account;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class LoginPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected WindowContainerManagedWindowBuilder __getWindowContainerManagedWindowBuilder__() {
		SystemAction systemAction = __inject__(SystemActionCreate.class);
		systemAction.setEntityClass(Account.class);
		WindowContainerManagedWindowBuilder windowContainerManagedWindowBuilder = __inject__(WindowContainerManagedWindowBuilderGetter.class)
				.setSystemAction(systemAction).execute().getOutput();
		windowContainerManagedWindowBuilder.getWindow(Boolean.TRUE).setTitleValue("Connection");
		return windowContainerManagedWindowBuilder;
	}
	
}
