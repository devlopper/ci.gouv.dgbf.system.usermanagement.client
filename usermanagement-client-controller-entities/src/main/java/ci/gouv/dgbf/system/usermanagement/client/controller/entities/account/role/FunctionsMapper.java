package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.klass.ClassHelper;
import org.cyk.utility.client.controller.data.AbstractDataCollectionMapperImpl;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.FunctionDto;
import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.FunctionDtoCollection;

@ApplicationScoped @Deprecated
public class FunctionsMapper extends AbstractDataCollectionMapperImpl<List<Function>, Function, FunctionDtoCollection, FunctionDto> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected Class<List<Function>> __getSourceClass__() {
		return (Class<List<Function>>) ClassHelper.getByName(List.class.getName());
	}
	
}
