package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.AbstractMapperSourceDestinationImpl;
import org.cyk.utility.client.controller.data.MappingInstantiator;
import org.mapstruct.Mapper;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.PrivilegeDto;

@Mapper(uses= {MappingInstantiator.class,PrivilegeTypeMapper.class})
public abstract class PrivilegeMapper extends AbstractMapperSourceDestinationImpl<Privilege, PrivilegeDto> {
	private static final long serialVersionUID = 1L;
    
}