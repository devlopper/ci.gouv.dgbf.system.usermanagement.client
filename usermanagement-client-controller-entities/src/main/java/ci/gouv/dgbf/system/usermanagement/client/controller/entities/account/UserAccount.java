package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.util.Collection;
import java.util.List;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

public interface UserAccount extends DataIdentifiedByString {

	@Override UserAccount setIdentifier(Object identifier);
	
	User getUser();
	User getUser(Boolean injectIfNull);
	UserAccount setUser(User user);
	
	Account getAccount();
	Account getAccount(Boolean injectIfNull);
	UserAccount setAccount(Account account);
	
	List<RolePoste> getRolePostes();
	List<RolePoste> getRolePostes(Boolean injectIfNull);
	UserAccount setRolePostes(List<RolePoste> rolePostes);
	UserAccount addRolePostes(Collection<RolePoste> rolePostes);
	UserAccount addRolePostes(RolePoste...rolePostes);
	
	/**/
	
	String PROPERTY_USER = "user";
	String PROPERTY_ACCOUNT = "account";
	String PROPERTY_ROLE_POSTES = "rolePostes";
}
