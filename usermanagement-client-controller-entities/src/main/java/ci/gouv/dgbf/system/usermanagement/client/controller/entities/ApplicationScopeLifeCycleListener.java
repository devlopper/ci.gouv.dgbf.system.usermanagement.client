package ci.gouv.dgbf.system.usermanagement.client.controller.entities;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.client.controller.AbstractApplicationScopeLifeCycleListenerEntities;
import org.cyk.utility.client.controller.component.input.choice.ChoicePropertyValueBuilder;
import org.cyk.utility.client.controller.component.menu.MenuBuilderMapGetter;
import org.cyk.utility.client.controller.data.DataFieldDescriptionsGetter;
import org.cyk.utility.instance.InstanceBuilder;

@ApplicationScoped
public class ApplicationScopeLifeCycleListener extends AbstractApplicationScopeLifeCycleListenerEntities implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void __initialize__(Object object) {
		super.__initialize__(object);
		__setQualifierClassTo__(ci.gouv.dgbf.system.usermanagement.server.annotation.System.class,InstanceBuilder.class, MenuBuilderMapGetter.class
				,DataFieldDescriptionsGetter.class,ChoicePropertyValueBuilder.class);
	}
	
	@Override
	public void __destroy__(Object object) {}
	
}