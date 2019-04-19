package ci.gouv.dgbf.system.usermanagement.client.controller.impl;

import java.io.Serializable;

import javax.faces.context.FacesContext;

import org.cyk.utility.__kernel__.function.AbstractFunctionRunnableImpl;
import org.cyk.utility.client.controller.component.menu.MenuBuilder;
import org.cyk.utility.client.controller.component.menu.MenuBuilderMap;
import org.cyk.utility.client.controller.component.menu.MenuBuilderMapGetter;
import org.cyk.utility.client.controller.component.menu.MenuItemBuilder;
import org.cyk.utility.client.controller.component.menu.MenuRenderTypeRowBar;
import org.cyk.utility.client.controller.icon.Icon;
import org.cyk.utility.scope.ScopeSession;
import org.cyk.utility.system.action.SystemActionCreate;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Role;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.RoleCategory;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.RoleType;
import ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.UserAccount;

public class MenuBuilderMapGetterFunctionRunnableImpl extends AbstractFunctionRunnableImpl<MenuBuilderMapGetter> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public MenuBuilderMapGetterFunctionRunnableImpl() {
		setRunnable(new Runnable() {
			@Override
			public void run() {
				Object principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
				MenuBuilder menuBuilder = __inject__(MenuBuilder.class).setRenderType(__inject__(MenuRenderTypeRowBar.class));
				if(principal == null) {
					menuBuilder.addItems(
							__inject__(MenuItemBuilder.class).setCommandableName("Compte utilisateur").setCommandableIcon(Icon.USER).addChild(
									__inject__(MenuItemBuilder.class).setCommandableName("Se connecter").setCommandableNavigationIdentifier("loginView")
									,__inject__(MenuItemBuilder.class).setCommandableName("Déverouiller mon compte")
									,__inject__(MenuItemBuilder.class).setCommandableName("Reinitialiser mon mot de passe")
							)
						);	
				}//else {
					menuBuilder.addItems(
							__inject__(MenuItemBuilder.class).setCommandableName("Paramétrage").setCommandableIcon(Icon.GEARS).addChild(
									__inject__(MenuItemBuilder.class).setCommandableName("Privilège").addChild(
											__inject__(MenuItemBuilder.class).setCommandableName("Visualiser des privilèges")
									)
									
									,__inject__(MenuItemBuilder.class).setCommandableName("Role").addEntitiesList(RoleType.class,Role.class,RoleCategory.class)
									,__inject__(MenuItemBuilder.class).setCommandableName("Fonction").addChild(
											__inject__(MenuItemBuilder.class).setCommandableName("Fonction")
									)
									,__inject__(MenuItemBuilder.class).setCommandableName("Profile").addChild(
											__inject__(MenuItemBuilder.class).setCommandableName("Type de profile")
											,__inject__(MenuItemBuilder.class).setCommandableName("Profile")
									)
									,__inject__(MenuItemBuilder.class).setCommandableName("Visibilité").addChild(
											__inject__(MenuItemBuilder.class).setCommandableName("Type de visibilité")
											,__inject__(MenuItemBuilder.class).setCommandableName("Ajouter une table de visibilité")
											,__inject__(MenuItemBuilder.class).setCommandableName("Visibilité")
									)
							)
							,__inject__(MenuItemBuilder.class).setCommandableName("Administration des comptes").setCommandableIcon(Icon.USERS).addChild(
									__inject__(MenuItemBuilder.class).setCommandableName("Créer un compte utilisateur").setCommandableIcon(Icon.PLUS)
									.setCommandableNavigationIdentifierBuilderSystemAction(__inject__(SystemActionCreate.class).setEntityClass(UserAccount.class))
									,__inject__(MenuItemBuilder.class).setCommandableName("Tester la connection à un compte").setCommandableIcon(Icon.FLASH)
									.setCommandableNavigationIdentifier("accountTestConnectionView")
									
							)		
						);	
				//}
				setOutput(__inject__(MenuBuilderMap.class).set(ScopeSession.class,menuBuilder));
			}
		});
	}
	
}