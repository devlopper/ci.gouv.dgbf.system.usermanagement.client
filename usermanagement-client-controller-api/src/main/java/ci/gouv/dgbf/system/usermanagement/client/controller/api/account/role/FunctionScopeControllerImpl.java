package ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.client.controller.AbstractControllerEntityImpl;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.FunctionScope;

@ApplicationScoped
public class FunctionScopeControllerImpl extends AbstractControllerEntityImpl<FunctionScope> implements FunctionScopeController,Serializable {
	private static final long serialVersionUID = 1L;
	
}