package ci.gouv.dgbf.system.usermanagement.client.controller.impl;

import java.io.Serializable;
import java.security.Principal;

import org.cyk.utility.__kernel__.icon.Icon;
import org.cyk.utility.client.controller.component.menu.AbstractMenuBuilderMapInstantiatorImpl;
import org.cyk.utility.client.controller.component.menu.MenuBuilder;
import org.cyk.utility.client.controller.component.menu.MenuItemBuilder;
import org.cyk.utility.client.controller.session.SessionAttributeEnumeration;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Function;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.FunctionType;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Privilege;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.PrivilegeType;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ProfileType;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopeImpl;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopeTypeImpl;

@ci.gouv.dgbf.system.usermanagement.server.annotation.System
public class MenuBuilderMapInstantiatorImpl extends AbstractMenuBuilderMapInstantiatorImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void __instantiateSessionMenuBuilderItems__(Object key, MenuBuilder sessionMenuBuilder, Object request,Principal principal) {
		if(SessionAttributeEnumeration.MENU_BUILDER_MAP.equals(key)) {
			sessionMenuBuilder.addItems(
					__inject__(MenuItemBuilder.class).setCommandableName("Gestion des privilèges").setCommandableIcon(Icon.SUITCASE)
						.listOrTree(Privilege.class,PrivilegeType.class)
					,__inject__(MenuItemBuilder.class).setCommandableName("Gestion des profiles").setCommandableIcon(Icon.FILE)
						.listOrTree(Profile.class,ProfileType.class,Function.class,FunctionType.class)
					,__inject__(MenuItemBuilder.class).setCommandableName("Gestion des visibilités").setCommandableIcon(Icon.EYE)
						.listOrTree(ScopeImpl.class,ScopeTypeImpl.class)
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
					,__inject__(MenuItemBuilder.class).setCommandableName("Retour au portail").setCommandableIcon(Icon.FLASH).addChild(
							__inject__(MenuItemBuilder.class).setCommandableName("Retour")
							.setCommandableNavigationValue("http://10.3.4.20:30300/sib/portail/")
							)
					);	
		}else if(MY_ACCOUNT.equals(key)) {
			sessionMenuBuilder.addItems(
					__inject__(MenuItemBuilder.class).setCommandableName("Mon compte").setCommandableIcon(Icon.SUITCASE)
						.addChild(
								__inject__(MenuItemBuilder.class).setCommandableName("Modifier mon mot de passe").setCommandableNavigationIdentifier("accountEditMyPassView")
								,__inject__(MenuItemBuilder.class).setCommandableName("Modifier mon profile").setCommandableNavigationIdentifier("userAccountEditMyProfile")
								)
					
					);	
		}
	}
	
	public static final String MY_ACCOUNT = "moncompte";
	
	static {
		/*
		UniformResourceIdentifierAsFunctionParameter parameter;
		DesktopDefault.USER_MENU_UL_LIS.clear();
		
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
		*/
	}

}
