package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.properties.Properties;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.ScopeTypeController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Scope;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopeType;
import ci.gouv.dgbf.system.usermanagement.client.controller.impl.AbstractPageContainerManagedImpl;
import ci.gouv.dgbf.system.usermanagement.client.controller.impl.account.role.ScopesTab;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountScopeListPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private UserAccount userAccount;
	private List<ScopesTab> scopesTabs = new ArrayList<>();
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		userAccount = readLoggedIn(new Properties().setFields("identifier,user,account,scopes"));
		if(userAccount == null) {
			
		}else {
			Collection<ScopeType> scopeTypes = __inject__(ScopeTypeController.class).read(new Properties().setIsPageable(Boolean.FALSE));
			Collection<Scope> scopes = userAccount.getScopes();
			if(CollectionHelper.isNotEmpty(scopes)) {
				if(CollectionHelper.isNotEmpty(scopeTypes)) {
					for(ScopeType index : scopeTypes) {
						ScopesTab scopesTab = new ScopesTab();
						scopesTab.setType(index);
						Collection<Scope> selectedScopes = null;
						if(CollectionHelper.isNotEmpty(userAccount.getScopes())) {
							selectedScopes = new ArrayList<>();
							for(Scope indexScope : userAccount.getScopes())
								if(indexScope.getType().equals(index))
									selectedScopes.add(indexScope);	
						}
						scopesTab.setCollection(selectedScopes);
						scopesTabs.add(scopesTab);
					}
				}
			}	
		}
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Mes visibilités";
	}
	
}
