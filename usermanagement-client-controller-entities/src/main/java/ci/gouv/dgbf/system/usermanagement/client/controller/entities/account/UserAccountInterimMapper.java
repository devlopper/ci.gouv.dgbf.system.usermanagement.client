package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.MappingInstantiator;
import org.cyk.utility.mapping.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.UserAccountInterimDto;

@Mapper(uses= {MappingInstantiator.class})
public abstract class UserAccountInterimMapper extends AbstractMapperSourceDestinationImpl<UserAccountInterim, UserAccountInterimDto> {
	private static final long serialVersionUID = 1L;
    	
}