package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.component.view.ViewBuilder;
import org.cyk.utility.client.controller.component.window.AbstractWindowContainerManagedWindowBuilderProcessDataImpl;
import org.cyk.utility.client.controller.data.Data;
import org.cyk.utility.client.controller.data.Form;
import org.cyk.utility.system.action.SystemAction;

public class UserAccountProcessWindowBuilderImpl extends AbstractWindowContainerManagedWindowBuilderProcessDataImpl implements UserAccountProcessWindowBuilder,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void __execute__(Form form, Data data,SystemAction systemAction, ViewBuilder viewBuilder) {
		System.out.println(ToStringBuilder.reflectionToString(data));
		viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.FALSE, UserAccount.PROPERTY_IDENTIFIER);
		
		viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.FALSE, UserAccount.PROPERTY_ACCOUNT,User.PROPERTY_IDENTIFIER);
		
		viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.FALSE, UserAccount.PROPERTY_USER,User.PROPERTY_FIRST_NAME);
		viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.FALSE, UserAccount.PROPERTY_USER,User.PROPERTY_LAST_NAMES);
		viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.FALSE, UserAccount.PROPERTY_USER,User.PROPERTY_ELECTRONIC_MAIL_ADDRESS);
		
		viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.TRUE, UserAccount.PROPERTY_ROLE_POSTES);
	}

	@Override
	protected Object __readOne__(Class<?> klass, Object identifier, Properties properties) {
		if(properties == null)
			properties = new Properties();
		properties.setFields(UserAccount.PROPERTY_ROLE_POSTES);
		return super.__readOne__(klass, identifier, properties);
	}
	
}
