package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.MappingInstantiator;
import org.cyk.utility.mapping.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.FunctionScopesMapper;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.FunctionsMapper;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ProfilesMapper;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopesMapper;
import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.UserAccountInterimDto;

@Mapper(uses= {MappingInstantiator.class,FunctionsMapper.class,FunctionScopesMapper.class,ProfilesMapper.class,ScopesMapper.class})
public abstract class UserAccountInterimMapper extends AbstractMapperSourceDestinationImpl<UserAccountInterim, UserAccountInterimDto> {
	private static final long serialVersionUID = 1L;
    	
}