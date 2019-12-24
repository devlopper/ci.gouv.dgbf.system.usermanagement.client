package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.__kernel__.system.action.SystemActionCustom;
import org.cyk.utility.client.controller.component.command.Commandable;
import org.cyk.utility.client.controller.component.command.CommandableBuilder;
import org.cyk.utility.client.controller.component.window.WindowBuilder;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.omnifaces.util.Faces;
import org.primefaces.event.TransferEvent;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.UserAccountController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.ScopeController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.ScopeTypeController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopeImpl;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopeTypeImpl;
import ci.gouv.dgbf.system.usermanagement.client.controller.impl.account.role.ScopesTab;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountScopeAssignProcessUserAccountPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private UserAccount userAccount;
	private List<ScopesTab> scopesTabs = new ArrayList<>();
	private Commandable saveCommandable;
	private String __fields__ = "identifier,user,account,functions,scopes";
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		userAccount = __inject__(UserAccountController.class).readBySystemIdentifier(Faces.getRequestParameter("identifier"),new Properties().setFields(__fields__));
		Collection<ScopeTypeImpl> scopeTypes = __inject__(ScopeTypeController.class).read(new Properties().setIsPageable(Boolean.FALSE));
		Collection<ScopeImpl> scopes = __inject__(ScopeController.class).read(new Properties().setIsPageable(Boolean.FALSE));
		if(CollectionHelper.isNotEmpty(scopes)) {
			if(CollectionHelper.isNotEmpty(scopeTypes)) {
				for(ScopeTypeImpl index : scopeTypes) {
					ScopesTab scopesTab = new ScopesTab();
					scopesTab.setType(index);
					Collection<ScopeImpl> availableScopes = new ArrayList<>();
					for(ScopeImpl indexScope : scopes)
						if(indexScope.getType().equals(index))
							availableScopes.add(indexScope);
					
					Collection<ScopeImpl> selectedScopes = null;
					if(CollectionHelper.isNotEmpty(userAccount.getScopes())) {
						selectedScopes = new ArrayList<>();
						for(ScopeImpl indexScope : userAccount.getScopes())
							if(indexScope.getType().equals(index))
								selectedScopes.add(indexScope);	
					}
					scopesTab.setScopes(__injectPrimefacesHelper__().buildDualList(availableScopes, selectedScopes));
					scopesTab.setListener(new ScopesTab.Listener() {
						@Override
						public void listenTransfer(TransferEvent event) {
							// TODO Auto-generated method stub
						}
					});
					
					scopesTabs.add(scopesTab);
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
	
	@Override
	protected String __processWindowDialogOkCommandableGetUrl__(WindowBuilder window, CommandableBuilder commandable) {
		return null;
	}
	
	private void save() {
		userAccount.getScopes(Boolean.TRUE).clear();
		for(ScopesTab index : scopesTabs) {
			if(index.getScopes().getTarget()!=null) {
				for(ScopeImpl indexScope : index.getScopes().getTarget())
					userAccount.getScopes(Boolean.TRUE).add(indexScope);
			}
		}
		__inject__(UserAccountController.class).update(userAccount,new Properties().setFields("scopes"));
	}

}
