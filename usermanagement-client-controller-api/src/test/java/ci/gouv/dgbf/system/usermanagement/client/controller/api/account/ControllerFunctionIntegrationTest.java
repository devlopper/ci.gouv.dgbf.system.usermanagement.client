package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.Serializable;
import java.util.stream.Collectors;

import org.cyk.utility.__kernel__.function.AbstractFunctionRunnableImpl;
import org.cyk.utility.__kernel__.function.FunctionRunnableMap;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.ControllerLayer;
import org.cyk.utility.client.controller.proxy.ProxyClassUniformResourceIdentifierStringProvider;
import org.cyk.utility.client.controller.proxy.ProxyClassUniformResourceIdentifierStringProviderImpl;
import org.cyk.utility.client.controller.test.TestControllerCreate;
import org.cyk.utility.client.controller.test.arquillian.AbstractControllerArquillianIntegrationTestWithDefaultDeploymentAsSwram;
import org.cyk.utility.random.RandomHelper;
import org.cyk.utility.time.TimeHelper;
import org.cyk.utility.value.ValueUsageType;
import org.junit.Test;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.ApplicationScopeLifeCycleListener;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Role;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.RoleCategory;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.RoleType;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;

public class ControllerFunctionIntegrationTest extends AbstractControllerArquillianIntegrationTestWithDefaultDeploymentAsSwram {
	private static final long serialVersionUID = 1L;
	
	@Test
	public void read_roleCategires() throws Exception{
		__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,10000,Boolean.TRUE);
		assertThat(__inject__(ControllerLayer.class).getInterfaceClassFromEntityClass(RoleCategory.class)).isEqualTo(RoleCategoryController.class);
		assertThat(__inject__(RoleCategoryController.class).read().stream().map(x -> x.getCode()).collect(Collectors.toList())).contains("ADMINISTRATIF","BUDGETAIRE");
		assertThat(__inject__(RoleCategoryController.class).readOneByBusinessIdentifier("ADMINISTRATIF")).isNotNull();
		assertThat(__inject__(RoleCategoryController.class).readOneByBusinessIdentifier("BUDGETAIRE")).isNotNull();
		assertThat(__inject__(RoleCategoryController.class).readOneByBusinessIdentifier("administratif")).isNull();
		assertThat(__inject__(RoleCategoryController.class).readOneByBusinessIdentifier("budgetaire")).isNull();
	}
	
	//@Test
	public void create_role() throws Exception{
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
	public void read_roles() throws Exception{
		__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,10000,Boolean.TRUE);
		assertThat(__inject__(RoleController.class).read().stream().map(x -> x.getCode()).collect(Collectors.toList())).contains("ADMINISTRATIF","BUDGETAIRE","AS","RBOP","DIRECTEUR","AS_MIN_21");
	}
	
	//@Test
	public void update_role() throws Exception{
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
	public void delete_role() throws Exception{
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
	
	@Test
	public void read_roleFunctions() throws Exception{
		__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,10000,Boolean.TRUE);
		assertThat(__inject__(RoleFunctionController.class).read().stream().map(x -> x.getCode()).collect(Collectors.toList())).contains("RP","DIRECTEUR");
	}

	@Test
	public void read_rolePostes() throws Exception{
		__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,10000,Boolean.TRUE);
		assertThat(__inject__(RolePosteController.class).read().stream().map(x -> x.getCode()).collect(Collectors.toList())).contains("AS_MIN_21","AV_MIN_21");
	}
	
	@Test
	public void read_services() throws Exception{
		__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,10000,Boolean.TRUE);
		assertThat(__inject__(ServiceController.class).read().stream().map(x -> x.getCode()).collect(Collectors.toList())).contains("WORKFLOW");
	}
	
	@Test
	public void create_userAccount() throws Exception{
		/*startServersZookeeperAndKafka();
		__inject__(TimeHelper.class).pause(1000l * 15);
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,10000,Boolean.TRUE);
		*/
		
		__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
		__inject__(TimeHelper.class).pause(1000l * 15);
		
		UserAccount userAccount = __inject__(UserAccount.class);
		userAccount.getUser(Boolean.TRUE).setFirstName("Zadi").setLastNames("Paul-François").setElectronicMailAddress("kycdev@gmail.com");
		userAccount.getAccount(Boolean.TRUE).setIdentifier(__getRandomCode__()).setPass("123");
		userAccount.addRoles(__inject__(Role.class).setCode("CE"));
		__inject__(UserAccountController.class).create(userAccount);
		
		__inject__(TimeHelper.class).pause(1000l * 25);
		/*
		stopServersKafkaAndZookeeper();	
		*/
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
