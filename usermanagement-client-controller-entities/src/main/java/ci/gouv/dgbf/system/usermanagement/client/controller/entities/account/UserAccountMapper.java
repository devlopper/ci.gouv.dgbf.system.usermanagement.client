package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.__kernel__.controller.AbstractMapperSourceDestinationImpl;
import org.cyk.utility.client.controller.data.MappingInstantiator;
import org.mapstruct.Mapper;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.UserAccountDto;

@Mapper(uses= {MappingInstantiator.class})
public abstract class UserAccountMapper extends AbstractMapperSourceDestinationImpl<UserAccount, UserAccountDto> {
	private static final long serialVersionUID = 1L;

}