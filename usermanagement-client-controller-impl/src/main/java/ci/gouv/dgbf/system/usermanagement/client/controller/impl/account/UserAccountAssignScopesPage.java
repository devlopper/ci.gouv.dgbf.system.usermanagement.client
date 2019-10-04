package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.primefaces.model.DualListModel;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.UserAccountController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.FunctionScopeController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.FunctionScope;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountAssignScopesPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<FunctionScope> functionScopes;
	private DualListModel<FunctionScope> functionScopesSections = new DualListModel<>();
	private DualListModel<FunctionScope> functionScopesUgps = new DualListModel<>();
	private DualListModel<FunctionScope> functionScopesUas = new DualListModel<>();
	private DualListModel<FunctionScope> functionScopesAbs = new DualListModel<>();
	private List<FunctionScope> selectedFunctionScopes;
	private List<UserAccount> userAccounts;
	private UserAccount selectedUserAccount;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		userAccounts = (List<UserAccount>) __inject__(UserAccountController.class).read(new Properties().setIsPageable(Boolean.FALSE));
		functionScopes = (List<FunctionScope>) __inject__(FunctionScopeController.class).read(new Properties().setIsPageable(Boolean.FALSE));
	}
	
	public void selectUserAccount(UserAccount userAccount) {
		Properties properties = new Properties();
		properties.setFields("functionScopes");
		this.selectedUserAccount = __inject__(UserAccountController.class).readBySystemIdentifier(userAccount.getIdentifier(), properties);
		selectedFunctionScopes = null;
		if(selectedUserAccount != null) {
			
			if(CollectionHelper.isNotEmpty(functionScopes)) {
				functionScopesSections = createDualList("SECTION");
				functionScopesUgps = createDualList("UGP");
				functionScopesUas = createDualList("UA");
				functionScopesAbs = createDualList("AB");
			}
		}
	}
	
	private DualListModel<FunctionScope> createDualList(String code) {
		List<FunctionScope> source = new ArrayList<>();
		for(FunctionScope index : functionScopes) {
			if(index.getScope().getType().getCode().equals(code))
				source.add(index);
		}
		List<FunctionScope> destination = new ArrayList<>();
		if(CollectionHelper.isNotEmpty(selectedUserAccount.getFunctionScopes()))
			for(FunctionScope index : selectedUserAccount.getFunctionScopes()) {
				if(index.getScope().getType().getCode().equals(code))
					destination.add(index);
			}
		return new DualListModel<>(source, destination);
	}
}
