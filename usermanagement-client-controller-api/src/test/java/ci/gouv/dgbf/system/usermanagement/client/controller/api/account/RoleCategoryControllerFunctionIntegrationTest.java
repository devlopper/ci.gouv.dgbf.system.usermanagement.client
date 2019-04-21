package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.Serializable;
import java.util.stream.Collectors;

import org.cyk.utility.__kernel__.function.AbstractFunctionRunnableImpl;
import org.cyk.utility.__kernel__.function.FunctionRunnableMap;
import org.cyk.utility.client.controller.ControllerLayer;
import org.cyk.utility.client.controller.proxy.ProxyClassUniformResourceIdentifierStringProvider;
import org.cyk.utility.client.controller.proxy.ProxyClassUniformResourceIdentifierStringProviderImpl;
import org.cyk.utility.client.controller.test.arquillian.AbstractControllerArquillianIntegrationTestWithDefaultDeploymentAsSwram;
import org.junit.Test;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.ApplicationScopeLifeCycleListener;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.RoleCategory;

public class RoleCategoryControllerFunctionIntegrationTest extends AbstractControllerArquillianIntegrationTestWithDefaultDeploymentAsSwram {
	private static final long serialVersionUID = 1L;
	
	@Test
	public void readRoles() throws Exception{
		__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,10000,Boolean.TRUE);
		assertThat(__inject__(ControllerLayer.class).getInterfaceClassFromEntityClass(RoleCategory.class)).isEqualTo(RoleCategoryController.class);
		assertThat(__inject__(RoleCategoryController.class).read().stream().map(x -> x.getCode()).collect(Collectors.toList())).contains("ADMINISTRATIF","BUDGETAIRE");
		assertThat(__inject__(RoleCategoryController.class).readOneByBusinessIdentifier("ADMINISTRATIF")).isNotNull();
		assertThat(__inject__(RoleCategoryController.class).readOneByBusinessIdentifier("BUDGETAIRE")).isNotNull();
		assertThat(__inject__(RoleCategoryController.class).readOneByBusinessIdentifier("administratif")).isNull();
		assertThat(__inject__(RoleCategoryController.class).readOneByBusinessIdentifier("budgetaire")).isNull();
	}
	
	/**/
	
	public static class ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl extends AbstractFunctionRunnableImpl<ProxyClassUniformResourceIdentifierStringProvider> implements Serializable {
		private static final long serialVersionUID = 1L;
		
		public ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl() {
			setRunnable(new Runnable() {
				@Override
				public void run() {
					setOutput("http://localhost:8080/usermanagement/server/");
				}
			});
		}
		
	}
	
}
