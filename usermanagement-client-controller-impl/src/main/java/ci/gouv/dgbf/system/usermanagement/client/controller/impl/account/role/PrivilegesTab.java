package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account.role;

import java.io.Serializable;
import java.util.ArrayList;

import org.primefaces.model.DualListModel;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Privilege;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.PrivilegeType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class PrivilegesTab implements Serializable {
	private static final long serialVersionUID = 1L;

	private PrivilegeType type;
	private DualListModel<Privilege> privileges = new DualListModel<>(new ArrayList<>(), new ArrayList<>());
}
