package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.klass.ClassHelper;
import org.cyk.utility.client.controller.data.AbstractDataCollectionMapperImpl;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.FunctionScopeDto;
import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.FunctionScopeDtoCollection;

@ApplicationScoped @Deprecated
public class FunctionScopesMapper extends AbstractDataCollectionMapperImpl<List<FunctionScope>, FunctionScope, FunctionScopeDtoCollection, FunctionScopeDto> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected Class<List<FunctionScope>> __getSourceClass__() {
		return (Class<List<FunctionScope>>) ClassHelper.getByName(List.class.getName());
	}
	
}
