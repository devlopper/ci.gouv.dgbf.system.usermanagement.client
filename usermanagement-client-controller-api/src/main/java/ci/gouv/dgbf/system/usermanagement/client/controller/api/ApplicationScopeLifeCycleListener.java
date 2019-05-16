package ci.gouv.dgbf.system.usermanagement.client.controller.api;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.AbstractApplicationScopeLifeCycleListener;
import org.cyk.utility.__kernel__.annotation.Client;
import org.cyk.utility.__kernel__.annotation.Controller;
import org.cyk.utility.__kernel__.annotation.System;
import org.cyk.utility.instance.InstanceBuilder;
import org.cyk.utility.system.node.SystemNodeClient;

@ApplicationScoped
public class ApplicationScopeLifeCycleListener extends AbstractApplicationScopeLifeCycleListener implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void __initialize__(Object object) {
		__setQualifiersClasses__(InstanceBuilder.class, System.class,Client.class,Controller.class);
		__inject__(SystemNodeClient.class).setName("SIIB");
		__inject__(org.cyk.utility.client.controller.ApplicationScopeLifeCycleListener.class).initialize(null);
	}
	
	@Override
	public void __destroy__(Object object) {}
	
	/**/
	
	public static final Integer LEVEL = new Integer(org.cyk.utility.client.controller.ApplicationScopeLifeCycleListener.LEVEL+100);
}
