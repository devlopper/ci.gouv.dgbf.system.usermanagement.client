package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.function.AbstractFunctionRunnableImpl;
import org.cyk.utility.__kernel__.function.FunctionRunnableMap;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.proxy.ProxyClassUniformResourceIdentifierStringProvider;
import org.cyk.utility.client.controller.proxy.ProxyClassUniformResourceIdentifierStringProviderImpl;
import org.cyk.utility.client.controller.test.TestControllerCreate;
import org.cyk.utility.client.controller.test.arquillian.AbstractControllerArquillianIntegrationTestWithDefaultDeployment;
import org.cyk.utility.request.RequestGetter;
import org.junit.Test;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.ApplicationScopeLifeCycleListener;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.PosteLocationController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.PosteLocationTypeController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.RoleCategoryController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.RoleFunctionController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.RolePosteController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccountInterim;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.PosteLocation;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.PosteLocationType;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.RoleCategory;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.RoleFunction;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.RolePoste;

public class ControllerFunctionIntegrationTest extends AbstractControllerArquillianIntegrationTestWithDefaultDeployment {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __listenBefore__() {
		super.__listenBefore__();
		System.out.println("ControllerFunctionIntegrationTest.__listenBefore__()");
	}
	
	@Override
	protected void __listenBeforeCallCountIsZero__() throws Exception {
		super.__listenBeforeCallCountIsZero__();
		System.out.println("ControllerFunctionIntegrationTest.__listenBeforeCallCountIsZero__() INITIALISATION ");
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,10000,Boolean.TRUE);
		__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
		DependencyInjection.setQualifierClass(RequestGetter.class, org.cyk.utility.__kernel__.annotation.Test.class);
	}
	
	private void __setup__() {
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,10000,Boolean.TRUE);
		__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
		DependencyInjection.setQualifierClass(RequestGetter.class, org.cyk.utility.__kernel__.annotation.Test.class);
	}
	
	@Test
	public void create_roleCategories() throws Exception{
		__setup__();
		__inject__(TestControllerCreate.class).addObjects(__inject__(RoleCategory.class).setCode(__getRandomCode__())
				.setName(__getRandomName__())).execute();
	}
	
	@Test
	public void create_roleFunctions() throws Exception{
		__setup__();
		RoleCategory category = __inject__(RoleCategory.class).setCode(__getRandomCode__()).setName(__getRandomName__());
		__inject__(TestControllerCreate.class).addObjectsToBeCreatedArray(category).addObjects(__inject__(RoleFunction.class).setCode(__getRandomCode__())
				.setName(__getRandomName__()).setCategory(category)).execute();
	}

	@Test
	public void create_rolePostes() throws Exception{
		__setup__();
		PosteLocationType locationType = __inject__(PosteLocationType.class).setCode(__getRandomCode__()).setName(__getRandomName__());
		PosteLocation location = __inject__(PosteLocation.class).setIdentifier(__getRandomCode__()).setType(locationType);
		RoleCategory category = __inject__(RoleCategory.class).setCode(__getRandomCode__()).setName(__getRandomName__());
		RoleFunction function = __inject__(RoleFunction.class).setCode(__getRandomCode__()).setName(__getRandomName__()).setCategory(category);
		__inject__(TestControllerCreate.class).addObjectsToBeCreatedArray(locationType,location,category,function).addObjects(__inject__(RolePoste.class).setFunction(function).setLocation(location)).execute();
	}
	
	@Test
	public void create_userAccount() throws Exception{
		__setup__();
		PosteLocationType locationType = __inject__(PosteLocationType.class).setCode("MINISTERE").setName("Ministère");
		PosteLocation location = __inject__(PosteLocation.class).setIdentifier("21").setType(locationType);
		RoleCategory category = __inject__(RoleCategory.class).setCode(__getRandomCode__()).setName(__getRandomName__());
		RoleFunction function = __inject__(RoleFunction.class).setCode("ASSISTANT_SAISIE").setName(__getRandomName__()).setCategory(category);
		RolePoste poste = __inject__(RolePoste.class).setFunction(function).setLocation(location);
		
		UserAccount userAccount = __inject__(UserAccount.class);
		userAccount.getUser(Boolean.TRUE).setFirstName("Zadi").setLastNames("Paul-François").setElectronicMailAddress(__getRandomElectronicMailAddress__());
		userAccount.getAccount(Boolean.TRUE).setIdentifier(__getRandomCode__()).setPass("123");
		userAccount.addRolePostes(__inject__(RolePoste.class).setCode("ASSISTANT_SAISIE_MINISTERE_21"));
		__inject__(TestControllerCreate.class).addObjectsToBeCreatedArray(locationType,location,category,function,poste).addObjects(userAccount).addTryEndRunnables(new Runnable() {
			@Override
			public void run() {
				UserAccount userAccount01 = (UserAccount) __inject__(UserAccountController.class).readOne(userAccount.getIdentifier());
				assertThat(userAccount01).as("user account is null").isNotNull();
				assertThat(userAccount01.getRolePostes()).as("user account roles collection is not null").isNull();
				
				userAccount01 = (UserAccount) __inject__(UserAccountController.class).readOne(userAccount.getIdentifier(),new Properties().setFields(UserAccount.PROPERTY_ROLE_POSTES));
				assertThat(userAccount01).as("user account is null").isNotNull();
				assertThat(userAccount01.getRolePostes()).as("user account roles collection is null").isNotNull();
				assertThat(userAccount01.getRolePostes()).as("user account roles collection is empty").isNotEmpty();
				assertThat(userAccount01.getRolePostes().stream().map(RolePoste::getCode).collect(Collectors.toList())).contains("ASSISTANT_SAISIE_MINISTERE_21");
			}
		}).execute();
	}
	
	@Test
	public void update_userAccount() throws Exception{
		__setup__();
		PosteLocationType locationType = __inject__(PosteLocationType.class).setCode("MINISTERE").setName("Ministère");
		__inject__(PosteLocationTypeController.class).create(locationType);
		PosteLocation location = __inject__(PosteLocation.class).setIdentifier("21").setType(locationType);
		__inject__(PosteLocationController.class).create(location);
		RoleCategory category = __inject__(RoleCategory.class).setCode(__getRandomCode__()).setName(__getRandomName__());
		__inject__(RoleCategoryController.class).create(category);
		RoleFunction function = __inject__(RoleFunction.class).setCode("CONTROLEUR_FINANCIER").setName(__getRandomName__()).setCategory(category);
		__inject__(RoleFunctionController.class).create(function);
		RolePoste poste = __inject__(RolePoste.class).setFunction(function).setLocation(location);
		__inject__(RolePosteController.class).create(poste);
		
		UserAccount userAccount = __inject__(UserAccount.class);
		userAccount.getUser(Boolean.TRUE).setFirstName("Zadi").setLastNames("Paul-François").setElectronicMailAddress(__getRandomElectronicMailAddress__());
		userAccount.getAccount(Boolean.TRUE).setIdentifier(__getRandomCode__()).setPass("123");
		userAccount.addRolePostes(poste);
		
		__inject__(UserAccountController.class).create(userAccount);
		
		userAccount = __inject__(UserAccountController.class).readOne(userAccount.getIdentifier(), new Properties().setFields(UserAccount.PROPERTY_ROLE_POSTES));
		assertThat(userAccount).isNotNull();
		assertThat(userAccount.getRolePostes()).isNotNull();
		assertThat(userAccount.getRolePostes()).isNotEmpty();
		assertThat(userAccount.getRolePostes().stream().map(RolePoste::getCode).collect(Collectors.toList())).contains("CONTROLEUR_FINANCIER_MINISTERE_21");
		
		function = __inject__(RoleFunction.class).setCode("ASSISTANT_SAISIE").setName(__getRandomName__()).setCategory(category);
		__inject__(RoleFunctionController.class).create(function);
		poste = __inject__(RolePoste.class).setFunction(function).setLocation(location);
		__inject__(RolePosteController.class).create(poste);
		
		userAccount.addRolePostes(poste);
		__inject__(UserAccountController.class).update(userAccount,new Properties().setFields(UserAccount.PROPERTY_ROLE_POSTES));
		
		userAccount = __inject__(UserAccountController.class).readOne(userAccount.getIdentifier(), new Properties().setFields(UserAccount.PROPERTY_ROLE_POSTES));
		assertThat(userAccount).isNotNull();
		assertThat(userAccount.getRolePostes()).isNotNull();
		assertThat(userAccount.getRolePostes()).isNotEmpty();
		assertThat(userAccount.getRolePostes().stream().map(RolePoste::getCode).collect(Collectors.toList())).contains("CONTROLEUR_FINANCIER_MINISTERE_21"
				,"ASSISTANT_SAISIE_MINISTERE_21");
		
		__inject__(UserAccountController.class).delete(userAccount);
		__inject__(RolePosteController.class).deleteAll();
		__inject__(RoleFunctionController.class).deleteAll();
		__inject__(PosteLocationController.class).deleteAll();
		__inject__(PosteLocationTypeController.class).deleteAll();
	}
	
	@Test
	public void create_userAccountInterim() throws Exception{
		__setup__();
		UserAccount userAccount = __inject__(UserAccount.class);
		userAccount.getUser(Boolean.TRUE).setFirstName("Zadi").setLastNames("Paul-François").setElectronicMailAddress(__getRandomElectronicMailAddress__());
		userAccount.getAccount(Boolean.TRUE).setIdentifier(__getRandomCode__()).setPass("123");
		
		UserAccount interim = __inject__(UserAccount.class);
		interim.getUser(Boolean.TRUE).setFirstName("Mel").setLastNames("Theo").setElectronicMailAddress(__getRandomElectronicMailAddress__());
		interim.getAccount(Boolean.TRUE).setIdentifier(__getRandomCode__()).setPass("123");
		
		UserAccountInterim userAccountInterim = __inject__(UserAccountInterim.class);
		userAccountInterim.setUserAccount(userAccount);
		userAccountInterim.setInterim(interim);
		userAccountInterim.setFromDate(LocalDateTime.of(2000, 1, 1,0,0)).setToDate(LocalDateTime.of(2000, 2, 1,0,0));
		
		__inject__(TestControllerCreate.class).setName("Create UserAccountInterim").addObjectsToBeCreatedArray(userAccount,interim).addObjects(userAccountInterim).execute();
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
