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
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.RoleCategory;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.RoleFunction;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.RolePoste;

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
							
							,*/__inject__(MenuItemBuilder.class).setCommandableName("Role").addEntitiesList(RoleCategory.class,RoleFunction.class,RolePoste.class)
							,__inject__(MenuItemBuilder.class).setCommandableName("Service").addEntitiesList(Service.class)
							/*,__inject__(MenuItemBuilder.class).setCommandableName("Fonction").addChild(
									__inject__(MenuItemBuilder.class).setCommandableName("Fonction")
							)*/
							/*,__inject__(MenuItemBuilder.class).setCommandableName("Profile").addChild(
									__inject__(MenuItemBuilder.class).setCommandableName("Type de profile")
									,__inject__(MenuItemBuilder.class).setCommandableName("Profile")
							)
							*/
							/*,__inject__(MenuItemBuilder.class).setCommandableName("Visibilité").addChild(
									__inject__(MenuItemBuilder.class).setCommandableName("Type de visibilité")
									,__inject__(MenuItemBuilder.class).setCommandableName("Ajouter une table de visibilité")
									,__inject__(MenuItemBuilder.class).setCommandableName("Visibilité")
							)
							*/
					)
					,__inject__(MenuItemBuilder.class).setCommandableName("Administration des comptes").setCommandableIcon(Icon.USERS).addChild(
							__inject__(MenuItemBuilder.class).setCommandableName("Créer un compte utilisateur").setCommandableIcon(Icon.PLUS)
							.setCommandableNavigationIdentifierBuilderSystemAction(__inject__(SystemActionCreate.class).setEntityClass(UserAccount.class))
							,__inject__(MenuItemBuilder.class).setCommandableName("Liste des comptes utilisateurs")
							.setCommandableNavigationIdentifierBuilderSystemAction(__inject__(SystemActionList.class).setEntityClass(UserAccount.class))
							
							/*,__inject__(MenuItemBuilder.class).setCommandableName("Assignation de profile à un compte utilisateur")
							.setCommandableNavigationIdentifier("userAccountAssignRolePostes")
							*/
							/*,__inject__(MenuItemBuilder.class).setCommandableName("Tester la connection à un compte").setCommandableIcon(Icon.FLASH)
							.setCommandableNavigationIdentifier("accountTestConnectionView")
							*/
							
					).addEntitySelect(UserAccount.class, "assignrolepostes")		
				);	
		//}
	}

	

}
