package ci.gouv.dgbf.system.usermanagement.client.controller.impl;

import java.io.Serializable;
import java.util.List;

import org.cyk.utility.client.controller.component.window.WindowBuilder;

public abstract class AbstractUserAccountBasedPageContainerManagedImplMonCompte extends AbstractUserAccountBasedPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		if(userAccount != null)
			__listenPostConstructUserAccountIsNotNull__();
	}
	
	protected void __listenPostConstructUserAccountIsNotNull__() {}
	
	@Override
	protected WindowBuilder __getWindowBuilder__(List<String> subDurations) {
		if(userAccount == null)
			throw new RuntimeException("Le compte utilisateur lu est nul.");
		WindowBuilder windowBuilder = super.__getWindowBuilder__(subDurations);
		windowBuilder.getApplicationName(Boolean.TRUE).setValue("SIIBC > MON COMPTE");
		return windowBuilder;
	}
	
	@Override
	protected Object __getMenuBuilderMapKey__() {
		return MenuBuilderMapInstantiatorImpl.MY_ACCOUNT;
	}
}
