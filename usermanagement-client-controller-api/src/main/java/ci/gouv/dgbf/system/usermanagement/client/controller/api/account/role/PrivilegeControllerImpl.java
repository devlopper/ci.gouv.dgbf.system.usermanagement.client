package ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.client.controller.AbstractControllerEntityImpl;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Privilege;

@ApplicationScoped
public class PrivilegeControllerImpl extends AbstractControllerEntityImpl<Privilege> implements PrivilegeController,Serializable {
	private static final long serialVersionUID = 1L;
	
}
