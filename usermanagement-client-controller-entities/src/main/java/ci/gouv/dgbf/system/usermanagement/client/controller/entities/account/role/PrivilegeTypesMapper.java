package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.clazz.ClassHelper;
import org.cyk.utility.client.controller.data.AbstractDataCollectionMapperImpl;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.PrivilegeTypeDto;
import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.PrivilegeTypeDtoCollection;

@ApplicationScoped
public class PrivilegeTypesMapper extends AbstractDataCollectionMapperImpl<List<PrivilegeType>, PrivilegeType, PrivilegeTypeDtoCollection, PrivilegeTypeDto> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected Class<List<PrivilegeType>> __getSourceClass__() {
		return (Class<List<PrivilegeType>>) DependencyInjection.inject(ClassHelper.class).getByName(List.class.getName());
	}
	
}
