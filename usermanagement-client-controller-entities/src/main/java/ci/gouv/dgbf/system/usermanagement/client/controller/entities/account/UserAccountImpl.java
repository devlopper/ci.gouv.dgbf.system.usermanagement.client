package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputChoice;
import org.cyk.utility.client.controller.component.annotation.InputChoiceMany;
import org.cyk.utility.client.controller.component.annotation.InputChoiceManyAutoComplete;
import org.cyk.utility.client.controller.component.annotation.InputChoiceManyCheckBox;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringImpl;
import org.cyk.utility.collection.CollectionHelper;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Function;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.FunctionScope;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Scope;

public class UserAccountImpl extends AbstractDataIdentifiedByStringImpl implements UserAccount,Serializable {
	private static final long serialVersionUID = 1L;

	private User user;
	private Account account;
	
	@Input @InputChoice @InputChoiceMany @InputChoiceManyAutoComplete
	private List<Function> functions;
	
	@Input @InputChoice @InputChoiceMany @InputChoiceManyAutoComplete
	private List<Scope> scopes;
	
	@Input @InputChoice @InputChoiceMany @InputChoiceManyCheckBox
	private List<Profile> profiles;
	
	@Input @InputChoice @InputChoiceMany @InputChoiceManyAutoComplete
	private List<FunctionScope> functionScopes;
	
	@Override
	public UserAccount setIdentifier(String identifier) {
		return (UserAccount) super.setIdentifier(identifier);
	}

	@Override
	public User getUser() {
		return user;
	}
	
	@Override
	public User getUser(Boolean injectIfNull) {
		return (User) __getInjectIfNull__(PROPERTY_USER, injectIfNull);
	}

	@Override
	public UserAccount setUser(User user) {
		this.user = user;
		return this;
	}

	@Override
	public Account getAccount() {
		return account;
	}
	
	@Override
	public Account getAccount(Boolean injectIfNull) {
		return (Account) __getInjectIfNull__(PROPERTY_ACCOUNT, injectIfNull);
	}

	@Override
	public UserAccount setAccount(Account account) {
		this.account = account;
		return this;
	}
	
	@Override
	public List<Function> getFunctions() {
		return functions;
	}
	
	@Override
	public UserAccount setFunctions(List<Function> functions) {
		this.functions = functions;
		return this;
	}
	
	@Override
	public List<Function> getFunctions(Boolean injectIfNull) {
		if(functions == null && Boolean.TRUE.equals(injectIfNull))
			functions = new ArrayList<>();
		return functions;
	}
	
	@Override
	public UserAccount addFunctions(Collection<Function> functions) {
		getFunctions(Boolean.TRUE).addAll(functions);
		return this;
	}
	
	@Override
	public UserAccount addFunctions(Function... functions) {
		addFunctions(__inject__(CollectionHelper.class).instanciate(functions));
		return this;
	}
	
	@Override
	public List<Scope> getScopes() {
		return scopes;
	}
	
	@Override
	public UserAccount setScopes(List<Scope> scopes) {
		this.scopes = scopes;
		return this;
	}
	
	@Override
	public List<Scope> getScopes(Boolean injectIfNull) {
		if(scopes == null && Boolean.TRUE.equals(injectIfNull))
			scopes = new ArrayList<>();
		return scopes;
	}
	
	@Override
	public UserAccount addScopes(Collection<Scope> scopes) {
		getScopes(Boolean.TRUE).addAll(scopes);
		return this;
	}
	
	@Override
	public UserAccount addScopes(Scope... scopes) {
		addScopes(__inject__(CollectionHelper.class).instanciate(scopes));
		return this;
	}
	
	@Override
	public List<FunctionScope> getFunctionScopes() {
		return functionScopes;
	}
	
	@Override
	public UserAccount setFunctionScopes(List<FunctionScope> functionScopes) {
		this.functionScopes = functionScopes;
		return this;
	}
	
	@Override
	public List<FunctionScope> getFunctionScopes(Boolean injectIfNull) {
		if(functionScopes == null && Boolean.TRUE.equals(injectIfNull))
			functionScopes = new ArrayList<>();
		return functionScopes;
	}
	
	@Override
	public UserAccount addFunctionScopes(Collection<FunctionScope> functionScopes) {
		getFunctionScopes(Boolean.TRUE).addAll(functionScopes);
		return this;
	}
	
	@Override
	public UserAccount addFunctionScopes(FunctionScope... functionScopes) {
		addFunctionScopes(__inject__(CollectionHelper.class).instanciate(functionScopes));
		return this;
	}
	
	/**/
	
	@Override
	public List<Profile> getProfiles() {
		return profiles;
	}
	
	@Override
	public UserAccount setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
		return this;
	}
	
	@Override
	public List<Profile> getProfiles(Boolean injectIfNull) {
		if(profiles == null && Boolean.TRUE.equals(injectIfNull))
			profiles = new ArrayList<>();
		return profiles;
	}
	
	@Override
	public UserAccount addProfiles(Collection<Profile> profiles) {
		getProfiles(Boolean.TRUE).addAll(profiles);
		return this;
	}
	
	@Override
	public UserAccount addProfiles(Profile... profiles) {
		addProfiles(__inject__(CollectionHelper.class).instanciate(profiles));
		return this;
	}
		
}
