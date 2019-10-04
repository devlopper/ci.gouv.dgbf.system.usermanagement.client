package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.klass.ClassHelper;
import org.cyk.utility.client.controller.data.AbstractDataCollectionMapperImpl;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.ScopeDto;
import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.ScopeDtoCollection;

@ApplicationScoped @Deprecated
public class ScopesMapper extends AbstractDataCollectionMapperImpl<List<Scope>, Scope, ScopeDtoCollection, ScopeDto> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected Class<List<Scope>> __getSourceClass__() {
		return (Class<List<Scope>>) ClassHelper.getByName(List.class.getName());
	}
	
}
