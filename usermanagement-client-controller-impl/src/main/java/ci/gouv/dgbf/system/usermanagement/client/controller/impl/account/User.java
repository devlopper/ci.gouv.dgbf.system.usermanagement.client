package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.primefaces.model.DualListModel;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Function;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull private String firstName;
	@NotNull private String lastNames;
	@NotNull private String electronicMailAddress;
	
	private DualListModel<Function> functions;
	
}
