package ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.AbstractControllerEntityImpl;
import org.cyk.utility.client.controller.proxy.ProxyGetter;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.RoleFunction;
import ci.gouv.dgbf.system.usermanagement.server.representation.api.account.role.ProfileRepresentation;
import ci.gouv.dgbf.system.usermanagement.server.representation.entities.account.role.ProfileDto;

@ApplicationScoped
public class ProfileControllerImpl extends AbstractControllerEntityImpl<Profile> implements ProfileController,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public Collection<Profile> getByFunctions(Collection<RoleFunction> functions) {
		ProfileRepresentation profileRepresentation = (ProfileRepresentation) __inject__(ProxyGetter.class).setClassUniformResourceIdentifierStringRequest(Properties.getFromPath(getProperties(), Properties.REQUEST))
		.setClazz(ProfileDto.class).execute().getOutput();
		//profileRepresentation.getByFunctionCodes(functions);
		return null;
	}
	
}
