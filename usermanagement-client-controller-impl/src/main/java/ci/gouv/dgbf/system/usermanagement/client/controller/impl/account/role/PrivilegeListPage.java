package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account.role;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.cyk.utility.client.controller.web.jsf.primefaces.tag.Tree;
import org.cyk.utility.client.controller.web.jsf.primefaces.tag.TreeSelectionMode;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.PrivilegeController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Privilege;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class PrivilegeListPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private Tree<Privilege> tree;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		//tree = new Tree<Privilege>(__inject__(PrivilegeController.class));
		/*tree.setRootLabel("Privilèges");
		tree.setSelectionLabel("Privilèges accordés");
		tree.setSelectable(Boolean.TRUE);
		tree.setSelectionMode(TreeSelectionMode.REMOVE_ADD);
		*/
		tree.initialise();
	}
	
}
