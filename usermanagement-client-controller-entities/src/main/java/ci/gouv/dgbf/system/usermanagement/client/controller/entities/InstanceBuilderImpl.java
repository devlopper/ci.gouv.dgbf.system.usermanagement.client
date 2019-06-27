package ci.gouv.dgbf.system.usermanagement.client.controller.entities;

import java.io.Serializable;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.AbstractInstanceBuilderImpl;
import org.cyk.utility.collection.CollectionHelper;
import org.cyk.utility.instance.InstanceHelper;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Account;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.User;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.RolePoste;
import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.AccountDto;
import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.UserAccountDto;
import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.UserDto;
import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.RolePosteDto;

@ci.gouv.dgbf.system.usermanagement.server.annotation.System
public class InstanceBuilderImpl extends AbstractInstanceBuilderImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void __copy__(Object source, Object destination, Properties properties) {
		if(source instanceof UserAccountDto && destination instanceof UserAccount) {
			UserAccountDto representation = (UserAccountDto) source;
			UserAccount data = (UserAccount) destination;
			data.setIdentifier(representation.getIdentifier());
			data.setUser(__inject__(InstanceHelper.class).buildOne(__inject__(User.class).getClass(), representation.getUser()));
			data.setAccount(__inject__(InstanceHelper.class).buildOne(__inject__(Account.class).getClass(), representation.getAccount()));
			if(representation.getPostes()!=null && representation.getPostes().getCollection()!=null) {
				Class<? extends RolePoste> klass = __inject__(RolePoste.class).getClass();
				for(RolePosteDto index : representation.getPostes().getCollection())
					data.getPostes(Boolean.TRUE).add(__inject__(InstanceHelper.class).buildOne(klass, index));	
			}
		}else if(source instanceof UserAccount && destination instanceof UserAccountDto) {
			UserAccount data = (UserAccount) source;
			UserAccountDto representation = (UserAccountDto) destination;
			representation.setIdentifier(data.getIdentifier());
			representation.setUser(__inject__(InstanceHelper.class).buildOne(UserDto.class, data.getUser()));			
			representation.setAccount(__inject__(InstanceHelper.class).buildOne(AccountDto.class, data.getAccount()));
			if(Boolean.TRUE.equals(__inject__(CollectionHelper.class).isNotEmpty(data.getPostes()))) {
				for(RolePoste index : data.getPostes())
					representation.getPostes(Boolean.TRUE).add(__inject__(InstanceHelper.class).buildOne(RolePosteDto.class, index));	
			}
		}/*else if(source instanceof UserDto && destination instanceof User) {
			UserDto representation = (UserDto) source;
			User data = (User) destination;
			data.setIdentifier(representation.getIdentifier());
		}/*else if(source instanceof User && destination instanceof UserDto) {
			User data = (User) source;
			UserDto representation = (UserDto) destination;
			representation.setElectronicMailAddress(data.getElectronicMailAddress());	
		}*/else
			super.__copy__(source, destination,properties);
	}
	
}
