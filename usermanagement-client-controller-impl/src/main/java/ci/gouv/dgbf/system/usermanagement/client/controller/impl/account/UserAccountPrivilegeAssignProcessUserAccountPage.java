package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.component.command.Commandable;
import org.cyk.utility.client.controller.component.command.CommandableBuilder;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.cyk.utility.client.controller.web.jsf.primefaces.tag.InputTree;
import org.cyk.utility.collection.CollectionHelper;
import org.cyk.utility.server.persistence.query.filter.FilterDto;
import org.cyk.utility.system.action.SystemActionCustom;
import org.omnifaces.util.Faces;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.TreeNode;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.UserAccountController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.ProfileController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Privilege;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
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
	private InputTree inputTreePrivilege;
	
	private Commandable saveCommandable;
	private String __fields__ = "functions,profiles";
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		userAccount = __inject__(UserAccountController.class).readBySystemIdentifier(Faces.getRequestParameter("identifier"),new Properties().setFields(__fields__));
		if(__inject__(CollectionHelper.class).isEmpty(userAccount.getProfiles())) {
			
		}else {
			userProfile = __inject__(ProfileController.class).readBySystemIdentifier(__inject__(CollectionHelper.class).getFirst(userAccount.getProfiles()).getIdentifier()
					,new Properties().setFields("privileges"));
		}
		Collection<Profile> __systemProfiles__ = __inject__(ProfileController.class).read(new Properties()
				.setFilters(new FilterDto().setKlass(ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.role.Profile.class)
						.addField(ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.role.Profile.FIELD_TYPE, Arrays.asList(ProfileType.CODE_SYSTEM)))
				.setIsPageable(Boolean.FALSE));
		systemProfiles = __injectPrimefacesHelper__().buildDualList(__systemProfiles__, userAccount.getProfiles());
		
		inputTreePrivilege = new InputTree(__injectPrimefacesHelper__().buildTreeNode(Privilege.class, userProfile));
		
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
		/*
		Properties properties = new Properties();
		properties.setFields("functions,profiles,privileges");
		userAccount = __inject__(UserAccountController.class).readBySystemIdentifier(Faces.getRequestParameter("useraccount"),properties);
		privileges = (List<Privilege>) __inject__(PrivilegeController.class).read(new Properties().setIsPageable(Boolean.FALSE));
		privilegeHierarchies = (List<PrivilegeHierarchy>) __inject__(PrivilegeHierarchyController.class).read(new Properties().setIsPageable(Boolean.FALSE));
		
		profiles = new ArrayList<>();
		for(Profile index : __inject__(ProfileController.class).read(new Properties().setIsPageable(Boolean.FALSE))) {
			if(index.getType().getCode().equals(ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.role.ProfileType.CODE_SYSTEM))
				profiles.add(index);
		}
		
		selectedProfiles = null;
		selectedPrivileges = null;
		if(userAccount != null) {
			List<Privilege> userAccountPrivileges = new ArrayList<>();
			
			if(__inject__(CollectionHelper.class).isNotEmpty(profiles) && __inject__(CollectionHelper.class).isNotEmpty(userAccount.getProfiles())) {
				selectedProfiles = new ArrayList<>();
				for(Profile index : userAccount.getProfiles()) {
					if(__inject__(CollectionHelper.class).isNotEmpty(index.getPrivileges()))
						userAccountPrivileges.addAll(index.getPrivileges());
					for(Profile profile : profiles)
						if(profile.getIdentifier().equals(index.getIdentifier())) {
							selectedProfiles.add(profile);
							break;
						}
				}
			}
			
			if(__inject__(CollectionHelper.class).isNotEmpty(privileges) && __inject__(CollectionHelper.class).isNotEmpty(userAccountPrivileges)) {
				selectedPrivileges = new ArrayList<>();
				for(Privilege index : userAccountPrivileges) {
					for(Privilege privilege : privileges)
						if(privilege.getIdentifier().equals(index.getIdentifier())) {
							selectedPrivileges.add(privilege);
							break;
						}
				}
			}
			
			createTreeNode();
		}
		*/
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Compte utilisateur : "+userAccount.getAccount().getIdentifier()+" - "+userAccount.getUser().getNames();
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
			if(__inject__(CollectionHelper.class).isNotEmpty(index.getPrivileges()))
				privileges.addAll(index.getPrivileges());
		
		if(__inject__(CollectionHelper.class).isNotEmpty(privileges)) {
			__injectPrimefacesHelper__().setTreeNodesSelected(inputTreePrivilege.getRoot(), privileges,event.isAdd());
		}
    }  

	private void save() {
		userProfile.getPrivileges(Boolean.TRUE).clear();
		if(inputTreePrivilege.getSelected()!=null)
			for(TreeNode index : inputTreePrivilege.getSelected()) {
				userProfile.getPrivileges(Boolean.TRUE).add((Privilege) index.getData());
			}
		
		__inject__(ProfileController.class).update(userProfile,new Properties().setFields("privileges"));
	}

}
