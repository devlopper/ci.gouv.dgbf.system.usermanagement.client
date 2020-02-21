package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.__kernel__.mapping.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.ScopeDto;

@Mapper
public abstract class ScopeMapper extends AbstractMapperSourceDestinationImpl<Scope, ScopeDto> {
	private static final long serialVersionUID = 1L;
    	
}