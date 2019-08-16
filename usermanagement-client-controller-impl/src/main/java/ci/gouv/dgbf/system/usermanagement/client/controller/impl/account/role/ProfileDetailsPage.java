package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account.role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.component.command.Commandable;
import org.cyk.utility.client.controller.component.command.CommandableBuilder;
import org.cyk.utility.client.controller.component.window.WindowBuilder;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.cyk.utility.collection.CollectionHelper;
import org.cyk.utility.system.action.SystemActionCustom;
import org.omnifaces.util.Faces;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.DualListModel;
import org.primefaces.model.TreeNode;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.FunctionController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.PrivilegeController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.PrivilegeHierarchyController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.ProfileController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Function;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Privilege;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.PrivilegeHierarchy;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class ProfileDetailsPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private Profile profile;
	private DualListModel<Function> functions = new DualListModel<>(new ArrayList<>(), new ArrayList<>());
	private List<Privilege> privileges = new ArrayList<>();
	private List<PrivilegeHierarchy> privilegeHierarchies;
	private TreeNode privilegesNodeRoot;
	private TreeNode[] privilegesNodesSelected;
	
	private Commandable saveCommandable;
	private String __fields__ = "functions,privileges";
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		this.profile = __inject__(ProfileController.class).readBySystemIdentifier(Faces.getRequestParameter("profile"),new Properties().setFields(__fields__));
		
		Collection<Function> __functions__ =  __inject__(FunctionController.class).read(new Properties().setIsPageable(Boolean.FALSE));
		if(__inject__(CollectionHelper.class).isNotEmpty(__functions__)) {
			for(Function index : __functions__) {
				Boolean isSelected = null;
				if(__inject__(CollectionHelper.class).isNotEmpty(profile.getFunctions())) {
					for(Function indexSub : profile.getFunctions()) {
						if(index.getIdentifier().equals(indexSub.getIdentifier())) {
							isSelected = Boolean.TRUE;
							break;
						}
					}
				}
				if(Boolean.TRUE.equals(isSelected))
					functions.getTarget().add(index);
				else
					functions.getSource().add(index);
			}
		}
		
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
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Profile : "+profile.getCode()+" - "+profile.getName();
	}
	
	@Override
	protected String __processWindowDialogOkCommandableGetUrl__(WindowBuilder window, CommandableBuilder commandable) {
		return null;
	}
	
	public void save() {
		profile.getFunctions(Boolean.TRUE).clear();
		if(functions.getTarget()!=null) {
			for(Function index : functions.getTarget())
				profile.getFunctions(Boolean.TRUE).add(index);
		}
		
		profile.getPrivileges(Boolean.TRUE).clear();
		if(privilegesNodesSelected!=null)
			for(TreeNode index : privilegesNodesSelected) {
				profile.getPrivileges(Boolean.TRUE).add((Privilege) index.getData());
			}
		
		__inject__(ProfileController.class).update(profile,new Properties().setFields(__fields__));
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
		if(__inject__(CollectionHelper.class).isNotEmpty(profile.getPrivileges())) {
			node.setSelected(profile.getPrivileges().contains(privilege));
			if(node.isSelected()) {
				while(parent != null) {
					parent.setExpanded(Boolean.TRUE);
					parent = parent.getParent();
				}
			}
		}				
		return node;
	}
}
