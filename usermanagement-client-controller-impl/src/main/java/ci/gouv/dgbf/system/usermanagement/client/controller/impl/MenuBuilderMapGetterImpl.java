package ci.gouv.dgbf.system.usermanagement.client.controller.impl;

import java.io.Serializable;
import java.security.Principal;

import org.cyk.user.interface_.theme.web.jsf.primefaces.atlantis.DesktopDefaultImpl;
import org.cyk.utility.__kernel__.icon.Icon;
import org.cyk.utility.__kernel__.identifier.resource.UniformResourceIdentifierAsFunctionParameter;
import org.cyk.utility.__kernel__.identifier.resource.UniformResourceIdentifierHelper;
import org.cyk.utility.client.controller.component.menu.AbstractMenuBuilderMapGetterImpl;
import org.cyk.utility.client.controller.component.menu.MenuBuilder;
import org.cyk.utility.client.controller.component.menu.MenuItemBuilder;

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
	protected void ____execute____(MenuBuilder sessionMenuBuilder, Object request, Principal principal) throws Exception {
		sessionMenuBuilder.addItems(
				__inject__(MenuItemBuilder.class).setCommandableName("Gestion des privilèges").setCommandableIcon(Icon.SUITCASE)
					.listOrTree(Privilege.class,PrivilegeType.class)
				,__inject__(MenuItemBuilder.class).setCommandableName("Gestion des profiles").setCommandableIcon(Icon.FILE)
					.listOrTree(Profile.class,ProfileType.class,Function.class,FunctionType.class)
				,__inject__(MenuItemBuilder.class).setCommandableName("Gestion des visibilités").setCommandableIcon(Icon.EYE)
					.listOrTree(Scope.class,ScopeType.class)
				,__inject__(MenuItemBuilder.class).setCommandableName("Gestion des utilisateurs").setCommandableIcon(Icon.USERS).addChild(
						__inject__(MenuItemBuilder.class).setCommandableName("Création").setCommandableIcon(Icon.PLUS)
						.setCommandableNavigationIdentifier("userAccountCreateListUserView")
				)
				//.addEntitySelect(UserAccount.class, Constant.SYSTEM_ACTION_IDENTIFIER_ASSIGN_PRIVILEGES)
				//.addEntitySelect(UserAccount.class, Constant.SYSTEM_ACTION_IDENTIFIER_ASSIGN_FUNCTION_SCOPES)
				.addChild(__inject__(MenuItemBuilder.class).setCommandableName("Comptes utilisateurs").setCommandableNavigationIdentifier("userAccountListView"))
				.addChild(__inject__(MenuItemBuilder.class).setCommandableName("Assignations").setCommandableNavigationIdentifier("userAccountAssignPrivilegesListUserAccountView"))
				.addChild(__inject__(MenuItemBuilder.class).setCommandableName("Affectations").setCommandableNavigationIdentifier("userAccountAssignScopesListUserAccountView"))
						
				//.addEntitiesList(UserAccountInterim.class,UserAccountInterimModel.class)
				,__inject__(MenuItemBuilder.class).setCommandableName("Retour au portail").setCommandableIcon(Icon.FLASH)
				);	
	}
	
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
		
		//}
	}

	static {
		UniformResourceIdentifierAsFunctionParameter parameter;
		DesktopDefaultImpl.USER_MENU_UL_LIS.clear();
		
		parameter = new UniformResourceIdentifierAsFunctionParameter();
		parameter.getPath(Boolean.TRUE).setIdentifier("logoutView");		
		DesktopDefaultImpl.addUserMenuUlLi("Me déconnecter", UniformResourceIdentifierHelper.build(parameter),"fa fa-sign-out");
		
		parameter = new UniformResourceIdentifierAsFunctionParameter();
		parameter.getPath(Boolean.TRUE).setIdentifier("accountEditMyPassView");
		DesktopDefaultImpl.addUserMenuUlLi("Modifier mon mot de passe", UniformResourceIdentifierHelper.build(parameter),"fa fa-key");
		
		parameter = new UniformResourceIdentifierAsFunctionParameter();
		parameter.getPath(Boolean.TRUE).setIdentifier("userAccountEditMyProfile");
		DesktopDefaultImpl.addUserMenuUlLi("Modifier mon profile", UniformResourceIdentifierHelper.build(parameter),"fa fa-user");
		
		parameter = new UniformResourceIdentifierAsFunctionParameter();
		parameter.getPath(Boolean.TRUE).setIdentifier("userAccountEditMyPreferences");
		DesktopDefaultImpl.addUserMenuUlLi("Mes préférences", UniformResourceIdentifierHelper.build(parameter),"fa fa-cog");
		
		parameter = new UniformResourceIdentifierAsFunctionParameter();
		parameter.getPath(Boolean.TRUE).setIdentifier("userAccountEditMyNotation");
		DesktopDefaultImpl.addUserMenuUlLi("Noter le SIIBC", UniformResourceIdentifierHelper.build(parameter),"fa fa-pencil");
		
		parameter = new UniformResourceIdentifierAsFunctionParameter();
		parameter.getPath(Boolean.TRUE).setIdentifier("accountScopeListView");
		DesktopDefaultImpl.addUserMenuUlLi("Mes visibilités", UniformResourceIdentifierHelper.build(parameter),"fa fa-eye");
		
		DesktopDefaultImpl.addUserMenuUlLi("Demandes de compte utilisateur", null,"fa fa-file-text");
		DesktopDefaultImpl.addUserMenuUlLi("M'abonner à une publication", null,"fa fa-comments");
	}

}
