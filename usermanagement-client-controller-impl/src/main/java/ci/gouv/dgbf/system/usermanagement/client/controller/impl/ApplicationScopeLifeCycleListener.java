package ci.gouv.dgbf.system.usermanagement.client.controller.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.AbstractApplicationScopeLifeCycleListener;
import org.cyk.utility.__kernel__.function.FunctionRunnableMap;
import org.cyk.utility.client.controller.component.command.CommandFunctionImpl;
import org.cyk.utility.client.controller.component.menu.MenuBuilderMapGetterImpl;
import org.cyk.utility.client.controller.component.theme.ThemeClassGetterImpl;
import org.cyk.utility.identifier.resource.UniformResourceIdentifierParameterValueMatrix;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Role;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.RoleType;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;

@ApplicationScoped
public class ApplicationScopeLifeCycleListener extends AbstractApplicationScopeLifeCycleListener implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void __initialize__(Object object) {
		__inject__(FunctionRunnableMap.class).set(MenuBuilderMapGetterImpl.class, MenuBuilderMapGetterFunctionRunnableImpl.class,LEVEL);
		__inject__(FunctionRunnableMap.class).set(ThemeClassGetterImpl.class, ThemeClassGetterFunctionRunnableImpl.class,LEVEL);
		__inject__(FunctionRunnableMap.class).set(CommandFunctionImpl.class, CommandFunctionFunctionRunnableImpl.class,LEVEL);
	
		__inject__(UniformResourceIdentifierParameterValueMatrix.class).setClass(Role.class);
		__inject__(UniformResourceIdentifierParameterValueMatrix.class).setClass(RoleType.class);
		__inject__(UniformResourceIdentifierParameterValueMatrix.class).setClass(UserAccount.class);
	}
	
	@Override
	public void __destroy__(Object object) {}
	
	/**/
	
	public static final Integer LEVEL = new Integer(ci.gouv.dgbf.system.usermanagement.client.controller.api.ApplicationScopeLifeCycleListener.LEVEL+1);
}
