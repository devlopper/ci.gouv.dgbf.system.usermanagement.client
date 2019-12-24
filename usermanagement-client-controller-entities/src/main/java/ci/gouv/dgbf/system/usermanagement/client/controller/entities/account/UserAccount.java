package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.util.Collection;
import java.util.List;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Function;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.FunctionScope;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopeImpl;

public interface UserAccount extends DataIdentifiedByString {

	@Override UserAccount setIdentifier(String identifier);
	
	User getUser();
	User getUser(Boolean injectIfNull);
	UserAccount setUser(User user);
	
	Account getAccount();
	Account getAccount(Boolean injectIfNull);
	UserAccount setAccount(Account account);
	
	Byte getNotation();
	UserAccount setNotation(Byte notation);
	
	String getColor();
	UserAccount setColor(String color);
	
	List<ScopeImpl> getScopes();
	List<ScopeImpl> getScopes(Boolean injectIfNull);
	UserAccount setScopes(List<ScopeImpl> scopes);
	UserAccount addScopes(Collection<ScopeImpl> scopes);
	UserAccount addScopes(ScopeImpl...scopes);
	
	List<Function> getFunctions();
	List<Function> getFunctions(Boolean injectIfNull);
	UserAccount setFunctions(List<Function> functions);
	UserAccount addFunctions(Collection<Function> functions);
	UserAccount addFunctions(Function...functions);
	
	List<FunctionScope> getFunctionScopes();
	List<FunctionScope> getFunctionScopes(Boolean injectIfNull);
	UserAccount setFunctionScopes(List<FunctionScope> functionScopes);
	UserAccount addFunctionScopes(Collection<FunctionScope> functionScopes);
	UserAccount addFunctionScopes(FunctionScope...functionScopes);
	
	List<Profile> getProfiles();
	List<Profile> getProfiles(Boolean injectIfNull);
	UserAccount setProfiles(List<Profile> profiles);
	UserAccount addProfiles(Collection<Profile> profiles);
	UserAccount addProfiles(Profile...profiles);
	
	/**/
	
	String PROPERTY_USER = "user";
	String PROPERTY_ACCOUNT = "account";
	String PROPERTY_FUNCTIONS = "functions";
	String PROPERTY_SCOPES = "scopes";
	String PROPERTY_FUNCTION_SCOPES = "functionScopes";
	String PROPERTY_PROFILES = "profiles";
	String PROPERTY_COLOR = "color";
	String PROPERTY_NOTATION = "notation";
}
