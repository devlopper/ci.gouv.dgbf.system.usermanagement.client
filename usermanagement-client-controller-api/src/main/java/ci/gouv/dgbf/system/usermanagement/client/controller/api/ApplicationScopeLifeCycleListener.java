package ci.gouv.dgbf.system.usermanagement.client.controller.api;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.AbstractApplicationScopeLifeCycleListener;
import org.cyk.utility.instance.InstanceBuilder;
import org.cyk.utility.string.repository.StringRepositoryResourceBundle;
import org.cyk.utility.system.node.SystemNodeClient;

import ci.gouv.dgbf.system.usermanagement.server.annotation.UserManagement;

@ApplicationScoped
public class ApplicationScopeLifeCycleListener extends AbstractApplicationScopeLifeCycleListener implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void __initialize__(Object object) {
		__setQualifiersClasses__(InstanceBuilder.class, UserManagement.class);
		__inject__(SystemNodeClient.class).setName("SIIB");
		__inject__(StringRepositoryResourceBundle.class).addBundleAt("ci.gouv.dgbf.system.usermanagement.client.controller.entities.message",0);
		__inject__(org.cyk.utility.client.controller.ApplicationScopeLifeCycleListener.class).initialize(null);
		
	}
	
	@Override
	public void __destroy__(Object object) {}
	
	/**/
	
	public static final Integer LEVEL = new Integer(org.cyk.utility.client.controller.ApplicationScopeLifeCycleListener.LEVEL+100);
}
