package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.client.controller.AbstractControllerEntityImpl;

import ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.UserAccountInterimModel;

@ApplicationScoped
public class UserAccountInterimModelControllerImpl extends AbstractControllerEntityImpl<UserAccountInterimModel> implements UserAccountInterimModelController,Serializable {
	private static final long serialVersionUID = 1L;
	
}
