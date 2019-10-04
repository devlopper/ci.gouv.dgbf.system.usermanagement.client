package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.cyk.utility.client.controller.web.jsf.primefaces.tag.Tree;
import org.cyk.utility.client.controller.web.jsf.primefaces.tag.TreeSelectionMode;
import org.cyk.utility.server.persistence.query.filter.FilterDto;
import org.omnifaces.util.Faces;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.UserAccountController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.ProfileController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.ProfilePrivilegeController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Privilege;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ProfilePrivilege;
import ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.role.ProfileType;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountPrivilegeAssignProcessUserAccountPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private UserAccount userAccount;
	/*
	 * User profile derived from user account to be updated
	 */
	private Profile userProfile;
	private DualListModel<Profile> systemProfiles;
	
	private Commandable saveCommandable;
	private String __fields__ = "identifier,user,account,functions,profiles";
	
	private Tree privilegeTree;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		userAccount = __inject__(UserAccountController.class).readBySystemIdentifier(Faces.getRequestParameter("identifier"),new Properties().setFields(__fields__));
		if(CollectionHelper.isEmpty(userAccount.getProfiles())) {
			
		}else {
			userProfile = __inject__(ProfileController.class).readBySystemIdentifier(CollectionHelper.getFirst(userAccount.getProfiles()).getIdentifier()
					,new Properties().setFields("identifier,privileges"));
		}
		Collection<Profile> __systemProfiles__ = __inject__(ProfileController.class).read(new Properties()
				.setFilters(new FilterDto().useKlass(ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.role.Profile.class)
						.addField(ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.role.Profile.FIELD_TYPE, Arrays.asList(ProfileType.CODE_SYSTEM)))
				.setIsPageable(Boolean.FALSE));
		
		Collection<Profile> selectedSystemProfiles = new ArrayList<>();
		if(CollectionHelper.isNotEmpty(userProfile.getPrivileges())) {
			//Find system profiles from user profile privileges
			//FIXME we do it like that for now for presentation. do it better
			
			Collection<ProfilePrivilege> profilePrivileges = __inject__(ProfilePrivilegeController.class).read(new Properties().setIsPageable(Boolean.FALSE));
			if(CollectionHelper.isNotEmpty(profilePrivileges)) {
				for(Privilege privilege : userProfile.getPrivileges()) {
					for(ProfilePrivilege profilePrivilege : profilePrivileges) {
						if(privilege.equals(profilePrivilege.getPrivilege()) && profilePrivilege.getProfile().getType().getCode().equals(ProfileType.CODE_SYSTEM)) {
							selectedSystemProfiles.add(profilePrivilege.getProfile());
						}
					}	
				}
			}
			
		}
		
		systemProfiles = __injectPrimefacesHelper__().buildDualList(__systemProfiles__, selectedSystemProfiles);
		
		privilegeTree = new Tree();
		privilegeTree.setNodeClass(Privilege.class);
		privilegeTree.setRootLabel("Privilèges disponibles");
		privilegeTree.setInitialSelectedNodes(userProfile.getPrivileges());
		privilegeTree.setSelectionLabel("Privilèges accordés");
		privilegeTree.setSelectable(Boolean.TRUE);
		privilegeTree.setSelectionMode(TreeSelectionMode.REMOVE_ADD);
		
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
		return "Assignation - Compte utilisateur : "+userAccount.getAccount().getIdentifier()+" - "+userAccount.getUser().getNames();
	}
	
	@Override
	protected String __processWindowDialogOkCommandableGetUrl__(WindowBuilder window, CommandableBuilder commandable) {
		return null;
	}
	
	public void onTransfer(TransferEvent event) {
		/*
		Collection<Profile> profiles = __inject__(ProfileController.class).readBySystemIdentifiers(
				event.getItems().stream().map(x -> ((Profile)x).getIdentifier()).collect(Collectors.toList()),new Properties()
				.setFields("privileges").setIsPageable(Boolean.FALSE));
		*/
		
		Collection<Profile> profiles = new ArrayList<>();
		for(Object item : event.getItems()) {
			profiles.add(__inject__(ProfileController.class).readBySystemIdentifier( ((Profile)item).getIdentifier() ,new Properties().setFields("privileges")));
		}
		
		Collection<Privilege> privileges = new ArrayList<>();
		for(Profile index : profiles)
			if(CollectionHelper.isNotEmpty(index.getPrivileges()))
				privileges.addAll(index.getPrivileges());
		
		if(CollectionHelper.isNotEmpty(privileges)) {
			if(event.isAdd())
				privilegeTree.select(privileges);
			else
				privilegeTree.deselect(privileges);
		}
    }  

	@SuppressWarnings("unchecked")
	private void save() {
		userProfile.setPrivileges((List<Privilege>) privilegeTree.getSelectedNodes());
		__inject__(ProfileController.class).update(userProfile,new Properties().setFields("privileges"));
	}

}
