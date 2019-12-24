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
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopeImpl;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopeTypeImpl;
import ci.gouv.dgbf.system.usermanagement.client.controller.impl.AbstractUserAccountBasedPageContainerManagedImplMonCompte;
import ci.gouv.dgbf.system.usermanagement.client.controller.impl.account.role.ScopesTab;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountScopeListPage extends AbstractUserAccountBasedPageContainerManagedImplMonCompte implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<ScopesTab> scopesTabs = new ArrayList<>();
	
	@Override
	protected void __listenPostConstructUserAccountIsNotNull__() {
		super.__listenPostConstructUserAccountIsNotNull__();	
		Collection<ScopeTypeImpl> scopeTypes = __inject__(ScopeTypeController.class).read(new Properties().setIsPageable(Boolean.FALSE));
		Collection<ScopeImpl> scopes = userAccount.getScopes();
		if(CollectionHelper.isNotEmpty(scopes)) {
			if(CollectionHelper.isNotEmpty(scopeTypes)) {
				for(ScopeTypeImpl index : scopeTypes) {
					ScopesTab scopesTab = new ScopesTab();
					scopesTab.setType(index);
					Collection<ScopeImpl> selectedScopes = null;
					if(CollectionHelper.isNotEmpty(userAccount.getScopes())) {
						selectedScopes = new ArrayList<>();
						for(ScopeImpl indexScope : userAccount.getScopes())
							if(indexScope.getType().equals(index))
								selectedScopes.add(indexScope);	
					}
					scopesTab.setCollection(selectedScopes);
					scopesTabs.add(scopesTab);
				}
			}
		}			
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Mes visibilités";
	}
	
	@Override
	protected Collection<String> __getReadLoggedInPropertiesFields__() {
		return List.of(UserAccount.PROPERTY_IDENTIFIER,UserAccount.PROPERTY_USER,UserAccount.PROPERTY_ACCOUNT,UserAccount.PROPERTY_SCOPES);
	}
	
}
