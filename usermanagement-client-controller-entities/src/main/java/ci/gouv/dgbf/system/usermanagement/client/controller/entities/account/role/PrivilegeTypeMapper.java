package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.MappingInstantiator;
import org.cyk.utility.client.controller.data.hierarchy.AbstractNodeMapperImpl;
import org.mapstruct.Mapper;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.PrivilegeTypeDto;
import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.PrivilegeTypeDtoCollection;

@Mapper(uses= {MappingInstantiator.class})
public abstract class PrivilegeTypeMapper extends AbstractNodeMapperImpl<PrivilegeType, PrivilegeTypeDto,PrivilegeTypeDtoCollection> {
	private static final long serialVersionUID = 1L;
    	
}