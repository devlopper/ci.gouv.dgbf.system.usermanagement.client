package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.cyk.utility.__kernel__.function.AbstractFunctionRunnableImpl;
import org.cyk.utility.__kernel__.function.FunctionRunnableMap;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.proxy.ProxyClassUniformResourceIdentifierStringProvider;
import org.cyk.utility.client.controller.proxy.ProxyClassUniformResourceIdentifierStringProviderImpl;
import org.cyk.utility.client.controller.test.TestControllerCreate;
import org.cyk.utility.client.controller.test.arquillian.AbstractControllerArquillianIntegrationTestWithDefaultDeployment;
import org.junit.Test;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.ApplicationScopeLifeCycleListener;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.FunctionCategoryController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.FunctionController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.FunctionScopeController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.ProfileController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.ProfileFunctionController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.ScopeController;
import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.ScopeTypeController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccountInterim;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Function;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.FunctionCategory;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.FunctionScope;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ProfileFunction;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Scope;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopeType;

public class ControllerIntegrationTest extends AbstractControllerArquillianIntegrationTestWithDefaultDeployment {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __listenBefore__() {
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,10000,Boolean.TRUE);
		__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);	
		super.__listenBefore__();
	}
	
	@Test
	public void create_roleCategories() throws Exception{
		__inject__(TestControllerCreate.class).addObjects(__inject__(FunctionCategory.class).setCode(__getRandomCode__())
				.setName(__getRandomName__())).execute();
	}
	
	@Test
	public void create_roleFunctions() throws Exception{
		FunctionCategory category = __inject__(FunctionCategory.class).setCode(__getRandomCode__()).setName(__getRandomName__());
		__inject__(TestControllerCreate.class).addObjectsToBeCreatedArray(category).addObjects(__inject__(Function.class).setCode(__getRandomCode__())
				.setName(__getRandomName__()).setCategory(category)).execute();
	}

	@Test
	public void create_rolePostes() throws Exception{
		ScopeType scopeType = __inject__(ScopeType.class).setCode(__getRandomCode__()).setName(__getRandomName__());
		Scope scope = __inject__(Scope.class).setIdentifier(__getRandomCode__()).setType(scopeType);
		FunctionCategory category = __inject__(FunctionCategory.class).setCode(__getRandomCode__()).setName(__getRandomName__());
		Function function = __inject__(Function.class).setCode(__getRandomCode__()).setName(__getRandomName__()).setCategory(category);
		__inject__(TestControllerCreate.class).addObjectsToBeCreatedArray(scopeType,scope,category,function).addObjects(__inject__(FunctionScope.class).setFunction(function).setScope(scope)).execute();
	}
	
	@Test
	public void create_profile() throws Exception{
		Profile profile = __inject__(Profile.class).setCode(__getRandomCode__()).setName(__getRandomName__());
		__inject__(TestControllerCreate.class).addObjects(profile).execute();
	}
	
	@Test
	public void create_profileRoleFunction() throws Exception{
		Profile profile = __inject__(Profile.class).setCode(__getRandomCode__()).setName(__getRandomName__());
		FunctionCategory category = __inject__(FunctionCategory.class).setCode(__getRandomCode__()).setName(__getRandomName__());
		Function function = __inject__(Function.class).setCode(__getRandomCode__()).setName(__getRandomName__()).setCategory(category);
		__inject__(TestControllerCreate.class).addObjectsToBeCreatedArray(profile,category,function).addObjects(__inject__(ProfileFunction.class)
				.setProfile(profile).setFunction(function)).execute();
	}
	
	@Test
	public void create_profile_withFunctions() throws Exception {
		FunctionCategory category = __inject__(FunctionCategory.class).setCode("c01").setName(__getRandomName__());
		__inject__(FunctionCategoryController.class).create(category);
		__inject__(FunctionController.class).create(__inject__(Function.class).setCode("f01").setName(__getRandomName__()).setCategory(__inject__(FunctionCategory.class).setCode("c01")));
		__inject__(FunctionController.class).create(__inject__(Function.class).setCode("f02").setName(__getRandomName__()).setCategory(__inject__(FunctionCategory.class).setCode("c01")));
		__inject__(FunctionController.class).create(__inject__(Function.class).setCode("f03").setName(__getRandomName__()).setCategory(__inject__(FunctionCategory.class).setCode("c01")));
		assertThat(__inject__(ProfileFunctionController.class).count(null)).isEqualTo(0l);
		__inject__(ProfileController.class).create(__inject__(Profile.class).setCode("p01").setName(__getRandomName__()).addFunctionsByCodes("f01","f03"));
		assertThat(__inject__(ProfileFunctionController.class).count(null)).isEqualTo(2l);
		__inject__(ProfileController.class).create(__inject__(Profile.class).setCode("p02").setName(__getRandomName__()).addFunctionsByCodes("f01","f02","f03"));
		assertThat(__inject__(ProfileFunctionController.class).count(null)).isEqualTo(5l);
		__inject__(ProfileController.class).update(__inject__(Profile.class).setCode("p02").setName(__getRandomName__()).addFunctionsByCodes("f02"),
				new Properties().setFields(Profile.PROPERTY_FUNCTIONS));
		assertThat(__inject__(ProfileFunctionController.class).count(null)).isEqualTo(3l);
		__inject__(ProfileController.class).delete(__inject__(Profile.class).setCode("p01"));
		assertThat(__inject__(ProfileFunctionController.class).count(null)).isEqualTo(1l);
	}
	
	@Test
	public void create_userAccount() throws Exception{
		ScopeType scopeType = __inject__(ScopeType.class).setCode("MINISTERE").setName("Ministère");
		Scope scope = __inject__(Scope.class).setIdentifier("21").setType(scopeType);
		FunctionCategory category = __inject__(FunctionCategory.class).setCode(__getRandomCode__()).setName(__getRandomName__());
		Function function = __inject__(Function.class).setCode("ASSISTANT_SAISIE").setName(__getRandomName__()).setCategory(category);
		FunctionScope poste = __inject__(FunctionScope.class).setFunction(function).setScope(scope);
		Profile profile = __inject__(Profile.class).setCode("p001").setName(__getRandomName__());
		
		UserAccount userAccount = __inject__(UserAccount.class);
		userAccount.getUser(Boolean.TRUE).setFirstName("Zadi").setLastNames("Paul-François").setElectronicMailAddress(__getRandomElectronicMailAddress__());
		userAccount.getAccount(Boolean.TRUE).setIdentifier(__getRandomCode__()).setPass("123");
		userAccount.addFunctionScopes(__inject__(FunctionScope.class).setCode("ASSISTANT_SAISIE_MINISTERE_21")).addProfiles(__inject__(Profile.class).setCode("p001").setName(__getRandomName__()));
		__inject__(TestControllerCreate.class).addObjectsToBeCreatedArray(scopeType,scope,category,function,poste,profile).addObjects(userAccount).addTryEndRunnables(new Runnable() {
			@Override
			public void run() {
				UserAccount userAccount01 = (UserAccount) __inject__(UserAccountController.class).readOne(userAccount.getIdentifier());
				assertThat(userAccount01).as("user account is null").isNotNull();
				assertThat(userAccount01.getFunctionScopes()).as("user account roles collection is not null").isNull();
				
				userAccount01 = (UserAccount) __inject__(UserAccountController.class).readOne(userAccount.getIdentifier(),new Properties()
						.setFields(UserAccount.PROPERTY_FUNCTION_SCOPES+","+UserAccount.PROPERTY_PROFILES));
				assertThat(userAccount01).as("user account is null").isNotNull();
				assertThat(userAccount01.getFunctionScopes()).as("user account roles collection is null").isNotNull();
				assertThat(userAccount01.getFunctionScopes()).as("user account roles collection is empty").isNotEmpty();
				assertThat(userAccount01.getFunctionScopes().stream().map(FunctionScope::getCode).collect(Collectors.toList())).contains("ASSISTANT_SAISIE_MINISTERE_21");
				assertThat(userAccount01.getProfiles()).as("user account profiles collection is null").isNotNull();
				assertThat(userAccount01.getProfiles()).as("user account profiles collection is empty").isNotEmpty();
				assertThat(userAccount01.getProfiles().stream().map(Profile::getCode).collect(Collectors.toList())).contains("p001");
			}
		}).execute();
	}
	
	@Test
	public void update_userAccount() throws Exception{
		assertThat(__inject__(UserAccountFunctionScopeController.class).count()).isEqualTo(0l);
		ScopeType scopeType = __inject__(ScopeType.class).setCode("MINISTERE").setName("Ministère");
		__inject__(ScopeTypeController.class).create(scopeType);
		Scope scope = __inject__(Scope.class).setIdentifier("21").setType(scopeType);
		__inject__(ScopeController.class).create(scope);
		FunctionCategory category = __inject__(FunctionCategory.class).setCode(__getRandomCode__()).setName(__getRandomName__());
		__inject__(FunctionCategoryController.class).create(category);
		Function function = __inject__(Function.class).setCode("CONTROLEUR_FINANCIER").setName(__getRandomName__()).setCategory(category);
		__inject__(FunctionController.class).create(function);
		FunctionScope functionScope = __inject__(FunctionScope.class).setFunction(function).setScope(scope);
		__inject__(FunctionScopeController.class).create(functionScope);
		UserAccount userAccount = __inject__(UserAccount.class);
		userAccount.getUser(Boolean.TRUE).setFirstName("Zadi").setLastNames("Paul-François").setElectronicMailAddress(__getRandomElectronicMailAddress__());
		userAccount.getAccount(Boolean.TRUE).setIdentifier(__getRandomCode__()).setPass("123");
		userAccount.addFunctionScopes(functionScope);
		
		__inject__(UserAccountController.class).create(userAccount);
		
		assertThat(__inject__(UserAccountFunctionScopeController.class).count()).isEqualTo(1l);
		userAccount = __inject__(UserAccountController.class).readOne(userAccount.getIdentifier(), new Properties().setFields(UserAccount.PROPERTY_FUNCTION_SCOPES));
		assertThat(userAccount).isNotNull();
		assertThat(userAccount.getFunctionScopes()).isNotNull();
		assertThat(userAccount.getFunctionScopes()).isNotEmpty();
		assertThat(userAccount.getFunctionScopes().stream().map(FunctionScope::getCode).collect(Collectors.toList())).contains("CONTROLEUR_FINANCIER_MINISTERE_21");
		
		function = __inject__(Function.class).setCode("ASSISTANT_SAISIE").setName(__getRandomName__()).setCategory(category);
		__inject__(FunctionController.class).create(function);
		functionScope = __inject__(FunctionScope.class).setFunction(function).setScope(scope);
		__inject__(FunctionScopeController.class).create(functionScope);
		
		userAccount.addFunctionScopes(functionScope);
		assertThat(userAccount.getFunctionScopes().stream().map(FunctionScope::getCode).collect(Collectors.toList())).contains("CONTROLEUR_FINANCIER_MINISTERE_21"
				,"ASSISTANT_SAISIE_MINISTERE_21");
		__inject__(UserAccountController.class).update(userAccount,new Properties().setFields(UserAccount.PROPERTY_FUNCTION_SCOPES));
		
		assertThat(__inject__(UserAccountFunctionScopeController.class).count()).isEqualTo(2l);
		userAccount = __inject__(UserAccountController.class).readOne(userAccount.getIdentifier(), new Properties().setFields(UserAccount.PROPERTY_FUNCTION_SCOPES));
		assertThat(userAccount).isNotNull();
		assertThat(userAccount.getFunctionScopes()).isNotNull();
		assertThat(userAccount.getFunctionScopes()).isNotEmpty();
		assertThat(userAccount.getFunctionScopes().stream().map(FunctionScope::getCode).collect(Collectors.toList())).contains("CONTROLEUR_FINANCIER_MINISTERE_21"
				,"ASSISTANT_SAISIE_MINISTERE_21");
	}
	
	@Test
	public void create_userAccountInterim() throws Exception{
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
