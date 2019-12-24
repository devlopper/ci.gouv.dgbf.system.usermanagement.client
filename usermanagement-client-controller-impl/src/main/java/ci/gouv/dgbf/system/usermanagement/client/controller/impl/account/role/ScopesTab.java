package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account.role;

import java.io.Serializable;
import java.util.Collection;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopeImpl;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopeTypeImpl;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ScopesTab implements Serializable {
	private static final long serialVersionUID = 1L;

	private ScopeTypeImpl type;
	private DualListModel<ScopeImpl> scopes;
	private Listener listener;
	private Collection<ScopeImpl> collection;
	
	/**/
	
	public static interface Listener {
		public void listenTransfer(TransferEvent event);
	}
}
