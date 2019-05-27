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
import org.junit.Test;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.ApplicationScopeLifeCycleListener;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.RoleCategoryController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.RoleFunctionController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.RolePosteController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.RoleCategory;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.RolePoste;

public class ControllerFunctionIntegrationTest extends AbstractControllerArquillianIntegrationTestWithDefaultDeploymentAsSwram {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __listenBeforeCallCountIsZero__() throws Exception {
		super.__listenBeforeCallCountIsZero__();
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,10000,Boolean.TRUE);
		__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
	}
	
	@Test
	public void read_roleCategories() throws Exception{
		//__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,10000,Boolean.TRUE);
		assertThat(__inject__(ControllerLayer.class).getInterfaceClassFromEntityClass(RoleCategory.class)).isEqualTo(RoleCategoryController.class);
		assertThat(__inject__(RoleCategoryController.class).read(new Properties().setIsPageable(Boolean.FALSE))
					.stream().map(x -> x.getCode()).collect(Collectors.toList())).contains("ADMINISTRATIF","BUDGETAIRE");
		assertThat(__inject__(RoleCategoryController.class).readOneByBusinessIdentifier("ADMINISTRATIF")).isNotNull();
		assertThat(__inject__(RoleCategoryController.class).readOneByBusinessIdentifier("BUDGETAIRE")).isNotNull();
		assertThat(__inject__(RoleCategoryController.class).readOneByBusinessIdentifier("administratif")).isNull();
		assertThat(__inject__(RoleCategoryController.class).readOneByBusinessIdentifier("budgetaire")).isNull();
	}
	
	@Test
	public void count_roleCategories() throws Exception{
		Long count = (Long) __inject__(RoleCategoryController.class).count();
		assertThat(count).isEqualTo(2);
	}
	
	@Test
	public void read_roleFunctions() throws Exception{
		//__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
		//__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,10000,Boolean.TRUE);
		assertThat(__inject__(RoleFunctionController.class).read(new Properties().setIsPageable(Boolean.FALSE))
				.stream().map(x -> x.getCode()).collect(Collectors.toList())).contains("ASSISTANT","DIRECTEUR");
	}

	@Test
	public void read_rolePostes() throws Exception{
		//__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
		//__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,10000,Boolean.TRUE);
		assertThat(__inject__(RolePosteController.class).read(new Properties().setIsPageable(Boolean.FALSE))
				.stream().map(x -> x.getCode()).collect(Collectors.toList())).contains("ASSISTANT_SAISIE_MINISTERE_21","AGENT_VERIFICATEUR_MINISTERE_21");
	}
	
	@Test
	public void create_userAccount() throws Exception{
		/*startServersZookeeperAndKafka();
		__inject__(TimeHelper.class).pause(1000l * 15);
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,10000,Boolean.TRUE);
		*/
		
		//__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
		//__inject__(TimeHelper.class).pause(1000l * 15);
		
		UserAccount userAccount = __inject__(UserAccount.class);
		userAccount.getUser(Boolean.TRUE).setFirstName("Zadi").setLastNames("Paul-François").setElectronicMailAddress("kycdev@gmail.com");
		userAccount.getAccount(Boolean.TRUE).setIdentifier(__getRandomCode__()).setPass("123");
		userAccount.addRolePostes(__inject__(RolePoste.class).setCode("ASSISTANT_SAISIE_MINISTERE_21"));
		__inject__(TestControllerCreate.class).addObjects(userAccount);
		
		//__inject__(TimeHelper.class).pause(1000l * 25);
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
