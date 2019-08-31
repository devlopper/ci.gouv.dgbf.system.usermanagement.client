package ci.gouv.dgbf.system.usermanagement.client.controller.impl;

import java.io.Serializable;
import java.security.Principal;

import org.cyk.utility.client.controller.component.menu.AbstractMenuBuilderMapGetterImpl;
import org.cyk.utility.client.controller.component.menu.MenuBuilder;
import org.cyk.utility.client.controller.component.menu.MenuItemBuilder;
import org.cyk.utility.client.controller.icon.Icon;
import org.cyk.utility.system.action.SystemActionCreate;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Function;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.FunctionType;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Privilege;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.PrivilegeType;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ProfileType;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Scope;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopeType;

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
				__inject__(MenuItemBuilder.class).setCommandableName("Gestion des privilèges").setCommandableIcon(Icon.QUESTION)
					.addEntitiesList(Privilege.class,PrivilegeType.class)
				,__inject__(MenuItemBuilder.class).setCommandableName("Gestion des profiles").setCommandableIcon(Icon.FILE)
					.addEntitiesList(Profile.class,ProfileType.class,Function.class,FunctionType.class)
				,__inject__(MenuItemBuilder.class).setCommandableName("Gestion des visibilités").setCommandableIcon(Icon.EYE)
					.addEntitiesList(/*FunctionScope.class,*/Scope.class,ScopeType.class)
				,__inject__(MenuItemBuilder.class).setCommandableName("Gestion des utilisateurs").setCommandableIcon(Icon.USERS).addChild(
						__inject__(MenuItemBuilder.class).setCommandableName("Création").setCommandableIcon(Icon.PLUS)
						.setCommandableNavigationIdentifier("userAccountCreateListUserView")
						//,__inject__(MenuItemBuilder.class).setCommandableName("Liste des utilisateurs")
						//.setCommandableNavigationIdentifierBuilderSystemAction(__inject__(SystemActionList.class).setEntityClass(UserAccount.class))
				)
				//.addEntitySelect(UserAccount.class, Constant.SYSTEM_ACTION_IDENTIFIER_ASSIGN_PRIVILEGES)
				//.addEntitySelect(UserAccount.class, Constant.SYSTEM_ACTION_IDENTIFIER_ASSIGN_FUNCTION_SCOPES)
				.addChild(__inject__(MenuItemBuilder.class).setCommandableName("Comptes utilisateurs").setCommandableNavigationIdentifier("userAccountListView"))
				.addChild(__inject__(MenuItemBuilder.class).setCommandableName("Assignations").setCommandableNavigationIdentifier("userAccountAssignPrivilegesListUserAccountView"))
				.addChild(__inject__(MenuItemBuilder.class).setCommandableName("Affectations").setCommandableNavigationIdentifier("userAccountAssignScopesListUserAccountView"))
						
				//.addEntitiesList(UserAccountInterim.class,UserAccountInterimModel.class)
				,__inject__(MenuItemBuilder.class).setCommandableName("Retour au portail").setCommandableIcon(Icon.FLASH)
				);	
		//}
	}

	

}
