package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.clazz.ClassHelper;
import org.cyk.utility.client.controller.data.AbstractDataCollectionMapperImpl;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.PrivilegeDto;
import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.PrivilegeDtoCollection;

@ApplicationScoped
public class PrivilegesMapper extends AbstractDataCollectionMapperImpl<List<Privilege>, Privilege, PrivilegeDtoCollection, PrivilegeDto> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected Class<List<Privilege>> __getSourceClass__() {
		return (Class<List<Privilege>>) DependencyInjection.inject(ClassHelper.class).getByName(List.class.getName());
	}
	
}
