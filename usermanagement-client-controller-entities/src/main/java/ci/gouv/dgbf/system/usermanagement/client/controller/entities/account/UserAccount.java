package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.util.Collection;
import java.util.List;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.RoleFunction;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.RolePoste;

public interface UserAccount extends DataIdentifiedByString {

	@Override UserAccount setIdentifier(Object identifier);
	
	User getUser();
	User getUser(Boolean injectIfNull);
	UserAccount setUser(User user);
	
	Account getAccount();
	Account getAccount(Boolean injectIfNull);
	UserAccount setAccount(Account account);
	
	List<RoleFunction> getFunctions();
	List<RoleFunction> getFunctions(Boolean injectIfNull);
	UserAccount setFunctions(List<RoleFunction> functions);
	UserAccount addFunctions(Collection<RoleFunction> functions);
	UserAccount addFunctions(RoleFunction...functions);
	
	List<RolePoste> getPostes();
	List<RolePoste> getPostes(Boolean injectIfNull);
	UserAccount setPostes(List<RolePoste> postes);
	UserAccount addPostes(Collection<RolePoste> postes);
	UserAccount addPostes(RolePoste...postes);
	
	List<Profile> getProfiles();
	List<Profile> getProfiles(Boolean injectIfNull);
	UserAccount setProfiles(List<Profile> profiles);
	UserAccount addProfiles(Collection<Profile> profiles);
	UserAccount addProfiles(Profile...profiles);
	
	/**/
	
	String PROPERTY_USER = "user";
	String PROPERTY_ACCOUNT = "account";
	String PROPERTY_ROLE_POSTES = "postes";
	String PROPERTY_PROFILES = "profiles";
}
