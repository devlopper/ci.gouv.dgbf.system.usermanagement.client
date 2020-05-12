package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.__kernel__.controller.AbstractMapperSourceDestinationImpl;
import org.cyk.utility.client.controller.data.MappingInstantiator;
import org.mapstruct.Mapper;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.ProfileTypeDto;

@Mapper(uses= {MappingInstantiator.class})
public abstract class ProfileTypeMapper extends AbstractMapperSourceDestinationImpl<ProfileType, ProfileTypeDto> {
	private static final long serialVersionUID = 1L;
    	
}