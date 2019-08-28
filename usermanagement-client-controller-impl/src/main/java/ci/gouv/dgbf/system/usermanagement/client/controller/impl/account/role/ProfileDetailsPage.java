package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account.role;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.component.command.Commandable;
import org.cyk.utility.client.controller.component.command.CommandableBuilder;
import org.cyk.utility.client.controller.component.window.WindowBuilder;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.cyk.utility.client.controller.web.jsf.primefaces.tag.InputTree;
import org.cyk.utility.client.controller.web.jsf.primefaces.tag.Tree;
import org.cyk.utility.client.controller.web.jsf.primefaces.tag.TreeSelectionMode;
import org.cyk.utility.system.action.SystemActionCustom;
import org.omnifaces.util.Faces;
import org.primefaces.model.DualListModel;
import org.primefaces.model.TreeNode;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.FunctionController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.ProfileController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Function;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Privilege;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class ProfileDetailsPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private Profile profile;
	private DualListModel<Function> functions;
	private InputTree inputTreePrivilege;

	private Commandable saveCommandable;
	private String __fields__ = "identifier,functions,privileges";
	private Tree<Privilege> privilegeTree;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		profile = __inject__(ProfileController.class).readBySystemIdentifier(Faces.getRequestParameter("identifier"),new Properties().setFields(__fields__));
		functions = __injectPrimefacesHelper__().buildDualList(__inject__(FunctionController.class).read(new Properties().setIsPageable(Boolean.FALSE))
				, profile.getFunctions());

		privilegeTree = new Tree<Privilege>();
		privilegeTree.setNodeClass(Privilege.class);
		privilegeTree.setRootLabel("Privilèges disponibles");
		privilegeTree.setSelectionLabel("Privilèges accordés");
		privilegeTree.setSelectedNodes(profile.getPrivileges());
		privilegeTree.setSelectable(Boolean.TRUE);
		privilegeTree.setSelectionMode(TreeSelectionMode.REMOVE_ADD);
		privilegeTree.initialise();
		
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
		/*
		if(inputTreePrivilege.getSelected()!=null)
			for(TreeNode index : inputTreePrivilege.getSelected()) {
				profile.getPrivileges(Boolean.TRUE).add((Privilege) index.getData());
			}
		*/
		profile.setPrivileges((List<Privilege>) privilegeTree.getSelectedNodes());
		
		__inject__(ProfileController.class).update(profile,new Properties().setFields(__fields__));
	}

}
