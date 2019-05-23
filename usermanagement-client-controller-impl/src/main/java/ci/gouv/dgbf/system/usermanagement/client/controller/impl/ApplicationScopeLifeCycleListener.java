package ci.gouv.dgbf.system.usermanagement.client.controller.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.AbstractApplicationScopeLifeCycleListener;
import org.cyk.utility.__kernel__.function.FunctionRunnableMap;
import org.cyk.utility.client.controller.component.command.CommandFunctionImpl;

@ApplicationScoped
public class ApplicationScopeLifeCycleListener extends AbstractApplicationScopeLifeCycleListener implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void __initialize__(Object object) {
		__inject__(ci.gouv.dgbf.system.usermanagement.client.controller.api.ApplicationScopeLifeCycleListener.class).initialize(null);
		
		__inject__(FunctionRunnableMap.class).set(CommandFunctionImpl.class, CommandFunctionFunctionRunnableImpl.class,LEVEL);
	}
	
	@Override
	public void __destroy__(Object object) {}
	
	/**/
	
	public static final Integer LEVEL = new Integer(ci.gouv.dgbf.system.usermanagement.client.controller.api.ApplicationScopeLifeCycleListener.LEVEL+1);
}
