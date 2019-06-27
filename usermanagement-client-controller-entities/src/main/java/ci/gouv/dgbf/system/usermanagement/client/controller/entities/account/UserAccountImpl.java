package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputChoice;
import org.cyk.utility.client.controller.component.annotation.InputChoiceMany;
import org.cyk.utility.client.controller.component.annotation.InputChoiceManyAutoComplete;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOneCombo;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringImpl;
import org.cyk.utility.collection.CollectionHelper;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.RoleFunction;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.RolePoste;

public class UserAccountImpl extends AbstractDataIdentifiedByStringImpl implements UserAccount,Serializable {
	private static final long serialVersionUID = 1L;

	private User user;
	private Account account;
	
	@Input @InputChoice @InputChoiceMany @InputChoiceOneCombo
	private List<RoleFunction> functions;
	
	@Input @InputChoice @InputChoiceMany @InputChoiceOneCombo
	private List<Profile> profiles;
	
	@Input @InputChoice @InputChoiceMany @InputChoiceManyAutoComplete
	private List<RolePoste> postes;
	
	@Override
	public UserAccount setIdentifier(Object identifier) {
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
	public List<RolePoste> getPostes() {
		return postes;
	}
	
	@Override
	public UserAccount setPostes(List<RolePoste> postes) {
		this.postes = postes;
		return this;
	}
	
	@Override
	public List<RolePoste> getPostes(Boolean injectIfNull) {
		if(postes == null && Boolean.TRUE.equals(injectIfNull))
			postes = new ArrayList<>();
		return postes;
	}
	
	@Override
	public UserAccount addPostes(Collection<RolePoste> postes) {
		getPostes(Boolean.TRUE).addAll(postes);
		return this;
	}
	
	@Override
	public UserAccount addPostes(RolePoste... postes) {
		addPostes(__inject__(CollectionHelper.class).instanciate(postes));
		return this;
	}
	
	/**/
	
	@Override
	public List<RoleFunction> getFunctions() {
		return functions;
	}
	
	@Override
	public UserAccount setFunctions(List<RoleFunction> functions) {
		this.functions = functions;
		return this;
	}
	
	@Override
	public List<RoleFunction> getFunctions(Boolean injectIfNull) {
		if(functions == null && Boolean.TRUE.equals(injectIfNull))
			functions = new ArrayList<>();
		return functions;
	}
	
	@Override
	public UserAccount addFunctions(Collection<RoleFunction> functions) {
		getFunctions(Boolean.TRUE).addAll(functions);
		return this;
	}
	
	@Override
	public UserAccount addFunctions(RoleFunction... functions) {
		addFunctions(__inject__(CollectionHelper.class).instanciate(functions));
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
	
	/**/
	
	public static final String FIELD_FUNCTIONS = "functions";
	public static final String FIELD_PROFILES = "profiles";
	public static final String FIELD_ROLE_POSTES = "postes";
	
}
