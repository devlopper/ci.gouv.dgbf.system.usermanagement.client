package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account.role;

import java.io.Serializable;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Scope;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopeType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ScopesTab implements Serializable {
	private static final long serialVersionUID = 1L;

	private ScopeType type;
	private DualListModel<Scope> scopes;
	private Listener listener;
	
	/**/
	
	public static interface Listener {
		public void listenTransfer(TransferEvent event);
	}
}
