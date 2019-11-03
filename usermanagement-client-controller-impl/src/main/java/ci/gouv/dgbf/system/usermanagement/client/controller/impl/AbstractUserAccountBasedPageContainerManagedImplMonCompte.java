package ci.gouv.dgbf.system.usermanagement.client.controller.impl;

import java.io.Serializable;
import java.util.List;

import org.cyk.utility.client.controller.component.window.WindowBuilder;

public abstract class AbstractUserAccountBasedPageContainerManagedImplMonCompte extends AbstractUserAccountBasedPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected WindowBuilder __getWindowBuilder__(List<String> subDurations) {
		WindowBuilder windowBuilder = super.__getWindowBuilder__(subDurations);
		windowBuilder.getApplicationName(Boolean.TRUE).setValue("SIIBC > MON COMPTE");
		return windowBuilder;
	}
	
}
