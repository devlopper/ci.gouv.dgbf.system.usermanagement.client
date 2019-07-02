package ci.gouv.dgbf.system.usermanagement.client.controller.impl;

import java.io.Serializable;
import java.security.Principal;

import org.cyk.utility.client.controller.component.menu.AbstractMenuBuilderMapGetterImpl;
import org.cyk.utility.client.controller.component.menu.MenuBuilder;
import org.cyk.utility.client.controller.component.menu.MenuItemBuilder;
import org.cyk.utility.client.controller.icon.Icon;
import org.cyk.utility.system.action.SystemActionCreate;
import org.cyk.utility.system.action.SystemActionList;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Service;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccountInterim;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccountInterimModel;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Function;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.FunctionCategory;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.FunctionScope;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Scope;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopeType;
import ci.gouv.dgbf.system.usermanagement.server.Constant;

@ci.gouv.dgbf.system.usermanagement.server.annotation.System
public class MenuBuilderMapGetterImpl extends AbstractMenuBuilderMapGetterImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void ____executePrincipalIsNotNull____(MenuBuilder sessionMenuBuilder, Object request, Principal principal) throws Exception {
		
	}

	@Override
	protected void ____executePrincipalIsNull____(MenuBuilder sessionMenuBuilder, Object request) throws Exception {
		if(sessionMenuBuilder == null) {
			/*menuBuilder.addItems(
					__inject__(MenuItemBuilder.class).setCommandableName("Compte utilisateur").setCommandableIcon(Icon.USER).addChild(
							__inject__(MenuItemBuilder.class).setCommandableName("Se connecter").setCommandableNavigationIdentifier("loginView")
							,__inject__(MenuItemBuilder.class).setCommandableName("Déverouiller mon compte")
							,__inject__(MenuItemBuilder.class).setCommandableName("Reinitialiser mon mot de passe")
					)
				);	*/
		}//else {
		sessionMenuBuilder.addItems(
					__inject__(MenuItemBuilder.class).setCommandableName("Paramétrage").setCommandableIcon(Icon.GEARS).addChild(
							/*__inject__(MenuItemBuilder.class).setCommandableName("Privilège").addChild(
									__inject__(MenuItemBuilder.class).setCommandableName("Visualiser des privilèges")
							)
							
							,*/__inject__(MenuItemBuilder.class).setCommandableName("Gestion des profiles").addEntitiesList(Profile.class,Function.class,FunctionScope.class,FunctionCategory.class
									,Scope.class,ScopeType.class)
							,__inject__(MenuItemBuilder.class).setCommandableName("Service").addEntitiesList(Service.class)
					)
					,__inject__(MenuItemBuilder.class).setCommandableName("Administration des comptes").setCommandableIcon(Icon.USERS).addChild(
							__inject__(MenuItemBuilder.class).setCommandableName("Créer un compte utilisateur").setCommandableIcon(Icon.PLUS)
							.setCommandableNavigationIdentifierBuilderSystemAction(__inject__(SystemActionCreate.class).setEntityClass(UserAccount.class))
							,__inject__(MenuItemBuilder.class).setCommandableName("Liste des comptes utilisateurs")
							.setCommandableNavigationIdentifierBuilderSystemAction(__inject__(SystemActionList.class).setEntityClass(UserAccount.class))
					)
					.addEntitySelect(UserAccount.class, Constant.SYSTEM_ACTION_IDENTIFIER_ASSIGN_PROFILES)
					.addEntitySelect(UserAccount.class, Constant.SYSTEM_ACTION_IDENTIFIER_ASSIGN_FUNCTION_SCOPES)
					.addEntitiesList(UserAccountInterim.class,UserAccountInterimModel.class)
				);	
		//}
	}

	

}
