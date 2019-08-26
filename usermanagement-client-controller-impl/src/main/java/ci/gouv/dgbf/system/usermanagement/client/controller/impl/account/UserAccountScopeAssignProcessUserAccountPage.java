package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.component.command.Commandable;
import org.cyk.utility.client.controller.component.command.CommandableBuilder;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.cyk.utility.collection.CollectionHelper;
import org.cyk.utility.system.action.SystemActionCustom;
import org.omnifaces.util.Faces;
import org.primefaces.event.TransferEvent;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.UserAccountController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.FunctionScopeController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.ScopeTypeController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.FunctionScope;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopeType;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountScopeAssignProcessUserAccountPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private UserAccount userAccount;
	private List<FunctionScopesTab> functionScopesTabs = new ArrayList<>();
	private Commandable saveCommandable;
	private String __fields__ = "user,account,functions,functionScopes";
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		userAccount = __inject__(UserAccountController.class).readBySystemIdentifier(Faces.getRequestParameter("identifier"),new Properties().setFields(__fields__));
		Collection<ScopeType> scopeTypes = __inject__(ScopeTypeController.class).read(new Properties().setIsPageable(Boolean.FALSE));
		Collection<FunctionScope> functionScopes = __inject__(FunctionScopeController.class).read(new Properties().setIsPageable(Boolean.FALSE));
		if(__inject__(CollectionHelper.class).isNotEmpty(functionScopes)) {
			if(__inject__(CollectionHelper.class).isNotEmpty(scopeTypes)) {
				for(ScopeType index : scopeTypes) {
					FunctionScopesTab functionScopesTab = new FunctionScopesTab();
					functionScopesTab.setType(index);
					Collection<FunctionScope> availableFunctionScopes = new ArrayList<>();
					for(FunctionScope indexFunctionScope : functionScopes)
						if(indexFunctionScope.getScope().getType().equals(index))
							availableFunctionScopes.add(indexFunctionScope);
					
					Collection<FunctionScope> selectedFunctionScopes = null;
					if(__inject__(CollectionHelper.class).isNotEmpty(userAccount.getFunctionScopes())) {
						selectedFunctionScopes = new ArrayList<>();
						for(FunctionScope indexFunctionScope : userAccount.getFunctionScopes())
							if(indexFunctionScope.getScope().getType().equals(index))
								selectedFunctionScopes.add(indexFunctionScope);	
					}
					functionScopesTab.setFunctionScopes(__injectPrimefacesHelper__().buildDualList(availableFunctionScopes, selectedFunctionScopes));
					functionScopesTab.setListener(new FunctionScopesTab.Listener() {
						@Override
						public void listenTransfer(TransferEvent event) {
							// TODO Auto-generated method stub
						}
					});
					
					functionScopesTabs.add(functionScopesTab);
				}
			}
		}
		
		CommandableBuilder saveCommandableBuilder = __inject__(CommandableBuilder.class);
		saveCommandableBuilder.setName("Enregistrer").setCommandFunctionActionClass(SystemActionCustom.class).addCommandFunctionTryRunRunnable(
			new Runnable() {
				@Override
				public void run() {
					save();
				}
			}
		);
		saveCommandable = saveCommandableBuilder.execute().getOutput();
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Affectation - Compte utilisateur : "+userAccount.getAccount().getIdentifier()+" - "+userAccount.getUser().getNames();
	}
	
	private void save() {
		userAccount.getFunctionScopes(Boolean.TRUE).clear();
		for(FunctionScopesTab index : functionScopesTabs) {
			if(index.getFunctionScopes().getTarget()!=null) {
				for(FunctionScope indexFunctionScope : index.getFunctionScopes().getTarget())
					userAccount.getFunctionScopes(Boolean.TRUE).add(indexFunctionScope);
			}
		}
		__inject__(UserAccountController.class).update(userAccount,new Properties().setFields("functionScopes"));
	}

}
