package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.clazz.ClassHelper;
import org.cyk.utility.client.controller.data.AbstractDataCollectionMapperImpl;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.ScopeDto;
import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.ScopeDtoCollection;

@ApplicationScoped
public class ScopesMapper extends AbstractDataCollectionMapperImpl<List<Scope>, Scope, ScopeDtoCollection, ScopeDto> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected Class<List<Scope>> __getSourceClass__() {
		return (Class<List<Scope>>) DependencyInjection.inject(ClassHelper.class).getByName(List.class.getName());
	}
	
}
