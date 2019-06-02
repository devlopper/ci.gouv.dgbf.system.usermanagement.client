package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.component.input.InputBuilder;
import org.cyk.utility.client.controller.component.view.ViewBuilder;
import org.cyk.utility.client.controller.component.window.AbstractWindowContainerManagedWindowBuilderProcessDataImpl;
import org.cyk.utility.client.controller.data.Data;
import org.cyk.utility.client.controller.data.Form;
import org.cyk.utility.system.action.SystemAction;

import ci.gouv.dgbf.system.usermanagement.server.Constant;

public class UserAccountProcessWindowBuilderImpl extends AbstractWindowContainerManagedWindowBuilderProcessDataImpl implements UserAccountProcessWindowBuilder,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void __execute__(Form form,SystemAction systemAction, Data data, ViewBuilder viewBuilder) {
		if(Constant.SYSTEM_ACTION_IDENTIFIER_ASSIGN_ROLE_POSTES.equals(systemAction.getIdentifier())) {
			viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.FALSE, UserAccount.PROPERTY_ACCOUNT,User.PROPERTY_IDENTIFIER);
			
			viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.FALSE, UserAccount.PROPERTY_USER,User.PROPERTY_FIRST_NAME);
			viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.FALSE, UserAccount.PROPERTY_USER,User.PROPERTY_LAST_NAMES);
			viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.FALSE, UserAccount.PROPERTY_USER,User.PROPERTY_ELECTRONIC_MAIL_ADDRESS);
			
			InputBuilder<?, ?> inputBuilder = (InputBuilder<?, ?>) viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.TRUE, UserAccount.PROPERTY_ROLE_POSTES);
			inputBuilder.setIsNullable(Boolean.FALSE);
		}
	}

	@Override
	protected Object __readOne__(SystemAction systemAction,Class<?> klass, Object identifier, Properties properties) {
		if(properties == null)
			properties = new Properties();
		properties.setFields(UserAccount.PROPERTY_ROLE_POSTES);
		return super.__readOne__(systemAction,klass, identifier, properties);
	}
	
}
