package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.Serializable;
import java.util.stream.Collectors;

import org.cyk.utility.__kernel__.function.AbstractFunctionRunnableImpl;
import org.cyk.utility.__kernel__.function.FunctionRunnableMap;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.proxy.ProxyClassUniformResourceIdentifierStringProvider;
import org.cyk.utility.client.controller.proxy.ProxyClassUniformResourceIdentifierStringProviderImpl;
import org.cyk.utility.client.controller.test.TestControllerCreate;
import org.cyk.utility.client.controller.test.arquillian.AbstractControllerArquillianIntegrationTestWithDefaultDeploymentAsSwram;
import org.cyk.utility.random.RandomHelper;
import org.cyk.utility.value.ValueUsageType;
import org.junit.Test;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.ApplicationScopeLifeCycleListener;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Role;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.RoleType;

public class RoleControllerFunctionIntegrationTest extends AbstractControllerArquillianIntegrationTestWithDefaultDeploymentAsSwram {
	private static final long serialVersionUID = 1L;
	
	/* Create */
	
	//@Test
	public void createOneRole() throws Exception{
		__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,100);
		
		String typeCode = __getRandomCode__();
		RoleType type = __inject__(RoleType.class).setCode(typeCode).setName(__getRandomCode__());
		__inject__(RoleTypeController.class).create(type);
		
		type = __inject__(RoleTypeController.class).readOneByBusinessIdentifier(typeCode);
		
		String roleCode = __getRandomCode__();
		Role role = __inject__(Role.class).setCode(roleCode).setName(__getRandomCode__()).setType(type);
		__inject__(TestControllerCreate.class).setIsCatchThrowable(Boolean.FALSE).addObjects(role).execute();
	}
	
	@Test
	public void readRoles() throws Exception{
		__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,10000,Boolean.TRUE);
		assertThat(__inject__(RoleController.class).read().stream().map(x -> x.getCode()).collect(Collectors.toList())).contains("ADMINISTRATIF","BUDGETAIRE","AS","RBOP","DIRECTEUR","AS_MIN_21");
	}
	
	//@Test
	public void updateOneRole() throws Exception{
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,100);
		
		String typeCode01 = __getRandomCode__();
		__inject__(RoleTypeController.class).create(__inject__(RoleType.class).setCode(typeCode01).setName(__getRandomCode__()));
		
		String typeCode02 = __getRandomCode__();
		__inject__(RoleTypeController.class).create(__inject__(RoleType.class).setCode(typeCode02).setName(__getRandomCode__()));
		
		String roleCode = __getRandomCode__();
		Role role = __inject__(Role.class).setCode(roleCode).setName("admin").setType(__inject__(RoleTypeController.class).readOneByBusinessIdentifier(typeCode01));
		__inject__(RoleController.class).create(role);
		
		role = __inject__(RoleController.class).readOneByBusinessIdentifier(roleCode);
		assertionHelper.assertEquals("admin", role.getName());
		assertionHelper.assertNotNull(role.getType());
		assertionHelper.assertEquals(typeCode01, role.getType().getCode());
		role.setName("administrateur");
		role.setType(__inject__(RoleTypeController.class).readOneByBusinessIdentifier(typeCode02));
		Properties properties = new Properties();
		properties.setFields("name,type");
		__inject__(RoleController.class).update(role,properties);
		
		role = __inject__(RoleController.class).readOneByBusinessIdentifier(roleCode);
		assertionHelper.assertEquals("administrateur", role.getName());
		assertionHelper.assertNotNull(role.getType());
		assertionHelper.assertEquals(typeCode02, role.getType().getCode());
	}
	
	//@Test
	public void deleteOneRole() throws Exception{
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,100);
		
		String code01 = __inject__(RandomHelper.class).getAlphabetic(3);
		String code02 = __inject__(RandomHelper.class).getAlphabetic(3);
		
		assertionHelper.assertNull(__inject__(RoleController.class).readOne(code01,ValueUsageType.BUSINESS));
		assertionHelper.assertNull(__inject__(RoleController.class).readOne(code02,ValueUsageType.BUSINESS));
		
		__inject__(RoleController.class).create(__inject__(Role.class).setCode(code01));
		__inject__(RoleController.class).create(__inject__(Role.class).setCode(code02));
		
		assertionHelper.assertNotNull(__inject__(RoleController.class).readOne(code01,ValueUsageType.BUSINESS));
		assertionHelper.assertNotNull(__inject__(RoleController.class).readOne(code02,ValueUsageType.BUSINESS));
		
		__inject__(RoleController.class).delete(__inject__(Role.class).setCode(code01));
		
		assertionHelper.assertNull(__inject__(RoleController.class).readOne(code01,ValueUsageType.BUSINESS));
		assertionHelper.assertNotNull(__inject__(RoleController.class).readOne(code02,ValueUsageType.BUSINESS));
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
