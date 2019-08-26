package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.MappingInstantiator;
import org.cyk.utility.client.controller.data.hierarchy.AbstractNodeMapperImpl;
import org.mapstruct.Mapper;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.PrivilegeDto;
import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.PrivilegeDtoCollection;

@Mapper(uses= {MappingInstantiator.class})
public abstract class PrivilegeMapper extends AbstractNodeMapperImpl<Privilege, PrivilegeDto, PrivilegeDtoCollection> {
	private static final long serialVersionUID = 1L;
    
}