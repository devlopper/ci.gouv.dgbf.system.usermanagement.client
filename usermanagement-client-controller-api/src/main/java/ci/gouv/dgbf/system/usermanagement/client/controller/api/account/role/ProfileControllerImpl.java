package ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.client.controller.AbstractControllerEntityImpl;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Function;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;

@ApplicationScoped
public class ProfileControllerImpl extends AbstractControllerEntityImpl<Profile> implements ProfileController,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public Collection<Profile> getByFunctions(Collection<Function> functions) {
		//ProfileRepresentation profileRepresentation = (ProfileRepresentation) __inject__(ProxyGetter.class).setClassUniformResourceIdentifierStringRequest(Properties.getFromPath(getProperties(), Properties.REQUEST))
		//.setClazz(ProfileDto.class).execute().getOutput();
		//profileRepresentation.getByFunctionCodes(functions);
		return null;
	}
	
}
