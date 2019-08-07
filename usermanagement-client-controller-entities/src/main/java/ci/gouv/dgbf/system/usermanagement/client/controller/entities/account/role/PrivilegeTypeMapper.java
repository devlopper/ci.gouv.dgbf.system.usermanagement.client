package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.MappingInstantiator;
import org.cyk.utility.mapping.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.PrivilegeTypeDto;

@Mapper(uses= {MappingInstantiator.class})
public abstract class PrivilegeTypeMapper extends AbstractMapperSourceDestinationImpl<PrivilegeType, PrivilegeTypeDto> {
	private static final long serialVersionUID = 1L;
    	
}