package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account.role;

import java.io.Serializable;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.FunctionScope;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ScopeTypeImpl;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FunctionScopesTab implements Serializable {
	private static final long serialVersionUID = 1L;

	private ScopeTypeImpl type;
	private DualListModel<FunctionScope> functionScopes;
	private Listener listener;
	
	/**/
	
	public static interface Listener {
		public void listenTransfer(TransferEvent event);
	}
}
