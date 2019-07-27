package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.MappingInstantiator;
import org.cyk.utility.mapping.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.FunctionTypeDto;

@Mapper(uses= {MappingInstantiator.class})
public abstract class FunctionTypeMapper extends AbstractMapperSourceDestinationImpl<FunctionType, FunctionTypeDto> {
	private static final long serialVersionUID = 1L;
	
}