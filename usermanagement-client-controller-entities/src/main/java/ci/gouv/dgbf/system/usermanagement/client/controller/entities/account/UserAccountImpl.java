package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputChoice;
import org.cyk.utility.client.controller.component.annotation.InputChoiceMany;
import org.cyk.utility.client.controller.component.annotation.InputChoiceManyAutoComplete;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringImpl;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.RolePoste;

public class UserAccountImpl extends AbstractDataIdentifiedByStringImpl implements UserAccount,Serializable {
	private static final long serialVersionUID = 1L;

	private User user;
	private Account account;
	
	@Input @InputChoice @InputChoiceMany @InputChoiceManyAutoComplete
	private List<RolePoste> rolePostes;
	
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
	public List<RolePoste> getRolePostes() {
		return rolePostes;
	}
	
	@Override
	public UserAccount setRolePostes(List<RolePoste> rolePostes) {
		this.rolePostes = rolePostes;
		return this;
	}
	
	@Override
	public List<RolePoste> getRolePostes(Boolean injectIfNull) {
		if(rolePostes == null)
			rolePostes = new ArrayList<>();
		return rolePostes;
		//return (List<RolePoste>) __getInjectIfNull__(FIELD_ROLE_POSTES, injectIfNull);
	}
	
	@Override
	public UserAccount addRolePostes(Collection<RolePoste> rolePostes) {
		getRolePostes(Boolean.TRUE).addAll(rolePostes);
		return this;
	}
	
	@Override
	public UserAccount addRolePostes(RolePoste... rolePostes) {
		//getRolePostes(Boolean.TRUE).add(rolePostes);
		return this;
	}
	
	/**/
	
	public static final String FIELD_ROLE_POSTES = "rolePostes";
	
}
