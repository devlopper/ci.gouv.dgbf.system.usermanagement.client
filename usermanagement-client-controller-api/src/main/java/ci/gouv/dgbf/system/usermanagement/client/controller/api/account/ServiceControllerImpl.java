package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.client.controller.AbstractControllerEntityImpl;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Service;

@ApplicationScoped
public class ServiceControllerImpl extends AbstractControllerEntityImpl<Service> implements ServiceController,Serializable {
	private static final long serialVersionUID = 1L;
	
}
