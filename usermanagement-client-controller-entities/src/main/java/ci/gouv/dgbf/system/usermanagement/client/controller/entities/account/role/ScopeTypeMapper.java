package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.__kernel__.controller.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.ScopeTypeDto;

@Mapper
public abstract class ScopeTypeMapper extends AbstractMapperSourceDestinationImpl<ScopeType, ScopeTypeDto> {
	private static final long serialVersionUID = 1L;
    	
}