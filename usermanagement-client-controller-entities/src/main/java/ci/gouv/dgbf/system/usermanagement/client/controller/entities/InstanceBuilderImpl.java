package ci.gouv.dgbf.system.usermanagement.client.controller.entities;

import java.io.Serializable;

import org.cyk.utility.client.controller.AbstractInstanceBuilderImpl;

@ci.gouv.dgbf.system.usermanagement.server.annotation.System @Deprecated
public class InstanceBuilderImpl extends AbstractInstanceBuilderImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * @Override protected void __copy__(Object source, Object destination,
	 * Properties properties) { if(source instanceof UserAccountDto && destination
	 * instanceof UserAccount) { UserAccountDto representation = (UserAccountDto)
	 * source; UserAccount data = (UserAccount) destination;
	 * data.setIdentifier(representation.getIdentifier());
	 * data.setUser(InstanceHelper.buildOne(__inject__(User.class).getClass(),
	 * representation.getUser()));
	 * data.setAccount(InstanceHelper.buildOne(__inject__(Account.class).getClass(),
	 * representation.getAccount())); if(representation.getFunctionScopes()!=null &&
	 * representation.getFunctionScopes()!=null) { Class<? extends FunctionScope>
	 * klass = __inject__(FunctionScope.class).getClass(); for(FunctionScopeDto
	 * index : representation.getFunctionScopes())
	 * data.getFunctionScopes(Boolean.TRUE).add(InstanceHelper.buildOne(klass,
	 * index)); } if(representation.getProfiles()!=null &&
	 * representation.getProfiles()!=null) { Class<? extends Profile> klass =
	 * __inject__(Profile.class).getClass(); for(ProfileDto index :
	 * representation.getProfiles())
	 * data.getProfiles(Boolean.TRUE).add(InstanceHelper.buildOne(klass, index)); }
	 * }else if(source instanceof UserAccount && destination instanceof
	 * UserAccountDto) { UserAccount data = (UserAccount) source; UserAccountDto
	 * representation = (UserAccountDto) destination;
	 * representation.setIdentifier(data.getIdentifier());
	 * representation.setUser(InstanceHelper.buildOne(UserDto.class,
	 * data.getUser()));
	 * representation.setAccount(InstanceHelper.buildOne(AccountDto.class,
	 * data.getAccount()));
	 * if(CollectionHelper.isNotEmpty(data.getFunctionScopes())) { for(FunctionScope
	 * index : data.getFunctionScopes())
	 * representation.getFunctionScopes(Boolean.TRUE).add(InstanceHelper.buildOne(
	 * FunctionScopeDto.class, index)); }
	 * if(CollectionHelper.isNotEmpty(data.getProfiles())) { for(Profile index :
	 * data.getProfiles())
	 * representation.getProfiles(Boolean.TRUE).add(InstanceHelper.buildOne(
	 * ProfileDto.class, index)); } }else if(source instanceof ProfileDto &&
	 * destination instanceof Profile) { ProfileDto representation = (ProfileDto)
	 * source; Profile data = (Profile) destination;
	 * data.setIdentifier(representation.getIdentifier());
	 * data.setCode(representation.getCode());
	 * data.setName(representation.getName());
	 * if(representation.getFunctions()!=null &&
	 * representation.getFunctions()!=null) { Class<? extends Function> klass =
	 * __inject__(Function.class).getClass(); for(FunctionDto index :
	 * representation.getFunctions())
	 * data.getFunctions(Boolean.TRUE).add(InstanceHelper.buildOne(klass, index)); }
	 * }else if(source instanceof Profile && destination instanceof ProfileDto) {
	 * Profile data = (Profile) source; ProfileDto representation = (ProfileDto)
	 * destination; representation.setIdentifier(data.getIdentifier());
	 * representation.setCode(data.getCode());
	 * representation.setName(data.getName());
	 * if(CollectionHelper.isNotEmpty(data.getFunctions())) { for(Function index :
	 * data.getFunctions())
	 * representation.getFunctions(Boolean.TRUE).add(InstanceHelper.buildOne(
	 * FunctionDto.class, index)); } }else super.__copy__(source,
	 * destination,properties);
	 * 
	 * 
	 * }
	 */
	
}
