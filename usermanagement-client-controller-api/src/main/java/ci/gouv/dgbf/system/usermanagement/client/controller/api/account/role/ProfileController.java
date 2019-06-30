package ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role;

import java.util.Collection;

import org.cyk.utility.client.controller.ControllerEntity;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Function;

public interface ProfileController extends ControllerEntity<Profile> {

	Collection<Profile> getByFunctions(Collection<Function> functions);
	
}
