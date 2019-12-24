package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.MappingInstantiator;
import org.cyk.utility.__kernel__.mapping.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.ProfilePrivilegeDto;

@Mapper(uses= {MappingInstantiator.class})
public abstract class ProfilePrivilegeMapper extends AbstractMapperSourceDestinationImpl<ProfilePrivilege, ProfilePrivilegeDto> {
	private static final long serialVersionUID = 1L;
    
}