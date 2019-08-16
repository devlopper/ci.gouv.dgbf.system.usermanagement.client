package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.primefaces.PrimeFaces;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.UserAccountController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountPrivilegeAssignListUserAccountPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<UserAccount> userAccounts;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		userAccounts = (List<UserAccount>) __inject__(UserAccountController.class).read(new Properties().setIsPageable(Boolean.FALSE));
	}
	
	public void selectUserAccount(UserAccount userAccount) {
		Map<String,Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("width", 1000);
        options.put("height", 580);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        
        Map<String,List<String>> parameters = new HashMap<>();
        parameters.put("identifier", Arrays.asList(userAccount.getIdentifier()));
         
        PrimeFaces.current().dialog().openDynamic("processuseraccount", options, parameters);
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Assignation de privilège";
	}
}
