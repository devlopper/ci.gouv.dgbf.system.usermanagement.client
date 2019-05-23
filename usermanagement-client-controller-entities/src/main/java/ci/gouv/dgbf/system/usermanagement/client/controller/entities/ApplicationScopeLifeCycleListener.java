package ci.gouv.dgbf.system.usermanagement.client.controller.entities;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.client.controller.AbstractApplicationScopeLifeCycleListenerEntities;
import org.cyk.utility.client.controller.component.menu.MenuBuilderMapGetter;
import org.cyk.utility.instance.InstanceBuilder;
import org.cyk.utility.system.node.SystemNodeClient;

@ApplicationScoped
public class ApplicationScopeLifeCycleListener extends AbstractApplicationScopeLifeCycleListenerEntities implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void __initialize__(Object object) {
		super.__initialize__(object);
		__inject__(SystemNodeClient.class).setName("SIIB");
		__setQualifierClassTo__(ci.gouv.dgbf.system.usermanagement.server.annotation.System.class,InstanceBuilder.class, MenuBuilderMapGetter.class);
	}
	
	@Override
	public void __destroy__(Object object) {}
	
}