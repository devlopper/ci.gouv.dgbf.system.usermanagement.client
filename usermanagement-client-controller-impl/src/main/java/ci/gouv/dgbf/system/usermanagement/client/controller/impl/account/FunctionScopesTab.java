package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.FunctionScope;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopeType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class FunctionScopesTab implements Serializable {
	private static final long serialVersionUID = 1L;

	private ScopeType type;
	private DualListModel<FunctionScope> functionScopes;
	private Listener listener;
	
	/**/
	
	public static interface Listener {
		public void listenTransfer(TransferEvent event);
	}
}
