package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import javax.inject.Inject;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.client.controller.data.MappingInstantiator;
import org.cyk.utility.mapping.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.ProfilePrivilegeDto;

@Mapper(uses= {MappingInstantiator.class,FunctionsMapper.class,PrivilegesMapper.class})
public abstract class ProfilePrivilegeMapper extends AbstractMapperSourceDestinationImpl<ProfilePrivilege, ProfilePrivilegeDto> {
	private static final long serialVersionUID = 1L;
    
	@Inject
	private ProfileMapper profileMapper;
	
	@Inject
	private PrivilegeMapper privilegeMapper;
	
	@Override
	public ProfilePrivilege getSource(ProfilePrivilegeDto profilePrivilegeDto) {
		return DependencyInjection.inject(ProfilePrivilege.class)
				.setProfile(profileMapper.getSource(profilePrivilegeDto.getProfile()))
				.setPrivilege(privilegeMapper.getSource(profilePrivilegeDto.getPrivilege()))
				;
	}
	
	@Override
	public ProfilePrivilegeDto getDestination(ProfilePrivilege profilePrivilege) {
		return new ProfilePrivilegeDto()
				.setProfile(profileMapper.getDestination(profilePrivilege.getProfile()))
				.setPrivilege(privilegeMapper.getDestination(profilePrivilege.getPrivilege()))
				;
	}
	
	
}