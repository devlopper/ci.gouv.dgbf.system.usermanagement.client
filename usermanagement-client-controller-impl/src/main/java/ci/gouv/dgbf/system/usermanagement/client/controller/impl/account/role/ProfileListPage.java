package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account.role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.component.command.Commandable;
import org.cyk.utility.client.controller.component.command.CommandableBuilder;
import org.cyk.utility.client.controller.web.jsf.primefaces.AbstractPageContainerManagedImpl;
import org.cyk.utility.system.action.SystemActionCustom;
import org.primefaces.PrimeFaces;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.ProfileController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.role.ProfileType;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class ProfileListPage extends AbstractPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Profile> systemProfiles = new ArrayList<>();
	private List<Profile> userProfiles = new ArrayList<>();
	private Profile selectedProfile;
	private Commandable openCommandable;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		List<Profile> profiles = (List<Profile>) __inject__(ProfileController.class).read(new Properties().setIsPageable(Boolean.FALSE));
		for(Profile index : profiles)
			if(index.getType().getCode().equals(ProfileType.CODE_SYSTEM))
				systemProfiles.add(index);
			else
				userProfiles.add(index);
		
		CommandableBuilder openCommandableBuilder = __inject__(CommandableBuilder.class);
		openCommandableBuilder.setName("Détails").setCommandFunctionActionClass(SystemActionCustom.class).addCommandFunctionTryRunRunnable(
			new Runnable() {
				@Override
				public void run() {
					//save();
				}
			}
		);
		openCommandable = openCommandableBuilder.execute().getOutput();
	}
	
	public void selectProfile(Profile profile) {
		Map<String,Object> options = new HashMap<>();
        options.put("modal", true);
        options.put("width", 1000);
        options.put("height", 580);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        
        Map<String,List<String>> parameters = new HashMap<>();
        parameters.put("profile", Arrays.asList(profile.getIdentifier()));
         
        PrimeFaces.current().dialog().openDynamic("details", options, parameters);
	}
	
}
