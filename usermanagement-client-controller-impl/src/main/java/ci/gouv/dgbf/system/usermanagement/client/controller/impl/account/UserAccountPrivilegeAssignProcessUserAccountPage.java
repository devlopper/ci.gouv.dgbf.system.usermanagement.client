package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.component.command.Commandable;
import org.cyk.utility.client.controller.component.command.CommandableBuilder;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.cyk.utility.client.controller.web.jsf.primefaces.PrimefacesHelper;
import org.cyk.utility.collection.CollectionHelper;
import org.cyk.utility.server.persistence.query.filter.FilterDto;
import org.cyk.utility.system.action.SystemActionCustom;
import org.omnifaces.util.Faces;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.DualListModel;
import org.primefaces.model.TreeNode;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.UserAccountController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.PrivilegeController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.PrivilegeHierarchyController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.ProfileController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Privilege;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.PrivilegeHierarchy;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.role.ProfileType;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountPrivilegeAssignProcessUserAccountPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private UserAccount userAccount;
	private List<Profile> selectedProfiles;
	private DualListModel<Profile> profiles;
	private List<Privilege> privileges;
	private List<PrivilegeHierarchy> privilegeHierarchies;
	private List<Privilege> selectedPrivileges;
	private TreeNode privilegesNodeRoot;
	private TreeNode[] privilegesNodesSelected;
	
	private Commandable saveCommandable;
	private String __fields__ = "functions,profiles,privileges";
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		this.userAccount = __inject__(UserAccountController.class).readBySystemIdentifier(Faces.getRequestParameter("identifier"),new Properties().setFields(__fields__));
		Collection<Profile> __profiles__ = __inject__(ProfileController.class).read(new Properties()
				.setFilters(new FilterDto().setKlass(ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.role.Profile.class)
						.addField(ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.role.Profile.FIELD_TYPE, Arrays.asList(ProfileType.CODE_SYSTEM)))
				.setIsPageable(Boolean.FALSE));
		profiles = __inject__(PrimefacesHelper.class).buildDualList(__profiles__, userAccount.getProfiles());
		
		privileges = (List<Privilege>) __inject__(PrivilegeController.class).read(new Properties().setIsPageable(Boolean.FALSE));
		privilegeHierarchies = (List<PrivilegeHierarchy>) __inject__(PrivilegeHierarchyController.class).read(new Properties().setIsPageable(Boolean.FALSE));
		createTreeNode();
		privilegesNodeRoot.setExpanded(Boolean.TRUE);	
		
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

	private void save() {
		
	}
	
	private void createTreeNode() {
		privilegesNodeRoot = new DefaultTreeNode();
		privilegesNodeRoot.setExpanded(Boolean.TRUE);
		if(__inject__(CollectionHelper.class).isNotEmpty(privileges))
			for(Privilege index : privileges) {
				Boolean hasParent = Boolean.FALSE;
				for(PrivilegeHierarchy privilegeHierarchy : privilegeHierarchies) {
					if(privilegeHierarchy.getChild().getIdentifier().equals(index.getIdentifier())) {
						hasParent = Boolean.TRUE;
						break;
					}
				}
				if(!hasParent) {
					TreeNode node = instantiateTreeNode(index, privilegesNodeRoot);
					createTreeNode(index,node);
				}
			}
	}
	
	private void createTreeNode(Privilege privilege,TreeNode root) {
		//Find children
		for(Privilege index : privileges) {
			for(PrivilegeHierarchy privilegeHierarchy : privilegeHierarchies) {
				if(privilegeHierarchy.getParent().getIdentifier().equals(privilege.getIdentifier()) && privilegeHierarchy.getChild().getIdentifier().equals(index.getIdentifier())) {
					TreeNode node = instantiateTreeNode(index, root);		
					createTreeNode(index,node);
					break;
				}
			}
		}
	}
	
	private TreeNode instantiateTreeNode(Privilege privilege,TreeNode parent) {
		TreeNode node = new DefaultTreeNode(privilege.getType().getCode(),privilege, parent);
		//mark as selected if it belongs to profile
		/*
		if(__inject__(CollectionHelper.class).isNotEmpty(userAccount.getPrivileges())) {
			node.setSelected(userAccount.getPrivileges().contains(privilege));
			if(node.isSelected()) {
				while(parent != null) {
					parent.setExpanded(Boolean.TRUE);
					parent = parent.getParent();
				}
			}
		}
		*/
		return node;
	}
}
