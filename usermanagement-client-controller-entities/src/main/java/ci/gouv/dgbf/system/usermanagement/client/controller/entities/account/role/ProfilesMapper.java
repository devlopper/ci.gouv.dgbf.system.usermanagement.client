package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.klass.ClassHelper;
import org.cyk.utility.client.controller.data.AbstractDataCollectionMapperImpl;

import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.ProfileDto;
import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.ProfileDtoCollection;

@ApplicationScoped @Deprecated
public class ProfilesMapper extends AbstractDataCollectionMapperImpl<List<Profile>, Profile, ProfileDtoCollection, ProfileDto> {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected Class<List<Profile>> __getSourceClass__() {
		return (Class<List<Profile>>) ClassHelper.getByName(List.class.getName());
	}
	
}
