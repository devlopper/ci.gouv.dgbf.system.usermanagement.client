package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.AbstractMapperSourceDestinationImpl;
import org.cyk.utility.client.controller.data.MappingInstantiator;
import org.mapstruct.Mapper;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.PrivilegeHierarchyDto;

@Mapper(uses= {MappingInstantiator.class,PrivilegeMapper.class})
public abstract class PrivilegeHierarchyMapper extends AbstractMapperSourceDestinationImpl<PrivilegeHierarchy, PrivilegeHierarchyDto> {
	private static final long serialVersionUID = 1L;
    	
}