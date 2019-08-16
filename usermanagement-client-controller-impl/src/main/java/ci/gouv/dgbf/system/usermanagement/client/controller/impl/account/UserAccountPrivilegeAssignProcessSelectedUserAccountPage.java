package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.cyk.utility.collection.CollectionHelper;
import org.omnifaces.util.Faces;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.UserAccountController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.PrivilegeController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.PrivilegeHierarchyController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.ProfileController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Privilege;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.PrivilegeHierarchy;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountPrivilegeAssignProcessSelectedUserAccountPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private UserAccount userAccount;
	private List<Profile> selectedProfiles;
	private List<Profile> profiles;
	private List<Privilege> privileges;
	private List<PrivilegeHierarchy> privilegeHierarchies;
	private List<Privilege> selectedPrivileges;
	private TreeNode treeNodeRoot;
	private TreeNode[] selectedNodes;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		Properties properties = new Properties();
		properties.setFields("functions,profiles,privileges");
		userAccount = __inject__(UserAccountController.class).readBySystemIdentifier(Faces.getRequestParameter("useraccount"),properties);
		privileges = (List<Privilege>) __inject__(PrivilegeController.class).read(new Properties().setIsPageable(Boolean.FALSE)/*.setFields("parents,children")*/);
		privilegeHierarchies = (List<PrivilegeHierarchy>) __inject__(PrivilegeHierarchyController.class).read(new Properties().setIsPageable(Boolean.FALSE)/*.setFields("parents,children")*/);
		/*FilterDto filter = new FilterDto().setKlass(ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.role.Profile.class)
				.addField(ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.role.Profile.FIELD_TYPE
						,Arrays.asList(ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.role.ProfileType.CODE_SYSTEM));
		*/
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
	}

	private void createTreeNode() {
		treeNodeRoot = new DefaultTreeNode();
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
					TreeNode node = new DefaultTreeNode(index.getType().getCode(),index, treeNodeRoot);
					createTreeNode(index,node);
				}
			}
	}
	
	private void createTreeNode(Privilege privilege,TreeNode root) {
		//Find children
		for(Privilege index : privileges) {
			for(PrivilegeHierarchy privilegeHierarchy : privilegeHierarchies) {
				if(privilegeHierarchy.getParent().getIdentifier().equals(privilege.getIdentifier()) && privilegeHierarchy.getChild().getIdentifier().equals(index.getIdentifier())) {
					TreeNode node = new DefaultTreeNode(index.getType().getCode(),index, root);
					createTreeNode(index,node);
					break;
				}
			}
		}
	}
}
