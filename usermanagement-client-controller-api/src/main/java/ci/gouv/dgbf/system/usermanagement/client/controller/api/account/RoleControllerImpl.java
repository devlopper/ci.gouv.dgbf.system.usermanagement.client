package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import java.io.Serializable;

import javax.inject.Singleton;

import org.cyk.utility.client.controller.AbstractControllerEntityImpl;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Role;

@Singleton
public class RoleControllerImpl extends AbstractControllerEntityImpl<Role> implements RoleController,Serializable {
	private static final long serialVersionUID = 1L;
	
}
