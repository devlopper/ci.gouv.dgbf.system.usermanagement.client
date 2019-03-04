package ci.gouv.dgbf.system.usermanagement.client.controller.impl;

import java.io.Serializable;

import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractCommandFunctionFunctionRunnableImpl;
import org.cyk.utility.system.action.SystemAction;
import org.cyk.utility.system.action.SystemActionCreate;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Account;

public class CommandFunctionFunctionRunnableImpl extends AbstractCommandFunctionFunctionRunnableImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __act__(SystemAction action, Object data) {
		if(data instanceof Account && action instanceof SystemActionCreate) {
			
		}else
			super.__act__(action, data);
	}
	
}