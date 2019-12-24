package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account.role;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.__kernel__.system.action.SystemActionCustom;
import org.cyk.utility.client.controller.component.command.Commandable;
import org.cyk.utility.client.controller.component.command.CommandableBuilder;
import org.cyk.utility.client.controller.component.window.WindowBuilder;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.cyk.utility.client.controller.web.jsf.primefaces.tag.PickList;
import org.cyk.utility.client.controller.web.jsf.primefaces.tag.TreeSelectionMode;
import org.omnifaces.util.Faces;
import org.primefaces.model.DualListModel;

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
	private DualListModel<Function> functions = new DualListModel<>();
	
	private Commandable saveCommandable;
	private String __fields__ = "identifier,code,name,functions,privileges";
	//private String __fields__ = "identifier,code,name";
	private PrivilegeTree privilegeTree;
	private PickList<Function> functionPickList;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		profile = __inject__(ProfileController.class).readBySystemIdentifier(Faces.getRequestParameter("identifier"),new Properties().setFields(__fields__));
		
		privilegeTree = new PrivilegeTree();
		privilegeTree.setRootLabel("Privilèges disponibles");
		privilegeTree.setSelectionLabel("Privilèges accordés");
		//privilegeTree.setInitialSelectedProfiles(Arrays.asList(profile));
		privilegeTree.setInitialSelectedNodes(profile.getPrivileges());
		privilegeTree.setSelectable(Boolean.TRUE);
		privilegeTree.setSelectionMode(TreeSelectionMode.REMOVE_ADD);
		
		functionPickList = new PickList<>(Function.class);
		functionPickList.setSelected(profile.getFunctions());
		
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
	protected void __initialise__() {
		super.__initialise__();
		//functions = __injectPrimefacesHelper__().buildDualList(__inject__(FunctionController.class).read(new Properties().setIsPageable(Boolean.FALSE)), profile.getFunctions());
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Définition des privilèges du profile : "+profile.getName();
	}
	
	@Override
	protected String __processWindowDialogOkCommandableGetUrl__(WindowBuilder window, CommandableBuilder commandable) {
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public void save() {
		profile.getFunctions(Boolean.TRUE).clear();
		if(functions.getTarget()!=null) {
			for(Function index : functions.getTarget())
				profile.getFunctions(Boolean.TRUE).add(index);
		}
		
		profile.setPrivileges((List<Privilege>) privilegeTree.getSelectedNodes());
		
		__inject__(ProfileController.class).update(profile,new Properties().setFields(__fields__));
	}

}
