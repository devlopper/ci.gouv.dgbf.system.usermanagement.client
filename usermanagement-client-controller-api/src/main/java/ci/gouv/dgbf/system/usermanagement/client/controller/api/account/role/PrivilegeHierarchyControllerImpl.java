package ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.client.controller.AbstractControllerEntityImpl;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.PrivilegeHierarchy;

@ApplicationScoped
public class PrivilegeHierarchyControllerImpl extends AbstractControllerEntityImpl<PrivilegeHierarchy> implements PrivilegeHierarchyController,Serializable {
	private static final long serialVersionUID = 1L;
	
}
