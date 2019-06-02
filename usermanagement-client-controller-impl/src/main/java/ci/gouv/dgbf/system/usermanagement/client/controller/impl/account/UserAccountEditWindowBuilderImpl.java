package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.component.view.ViewBuilder;
import org.cyk.utility.client.controller.component.window.AbstractWindowContainerManagedWindowBuilderEditDataImpl;
import org.cyk.utility.client.controller.data.Data;
import org.cyk.utility.client.controller.data.Form;
import org.cyk.utility.system.action.SystemAction;
import org.cyk.utility.system.action.SystemActionCreate;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Account;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.User;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccountEditWindowBuilder;

public class UserAccountEditWindowBuilderImpl extends AbstractWindowContainerManagedWindowBuilderEditDataImpl implements UserAccountEditWindowBuilder, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __execute__(Form form,SystemAction systemAction,Data data,ViewBuilder viewBuilder) {
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_ACCOUNT,Account.PROPERTY_IDENTIFIER);
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_ACCOUNT,Account.PROPERTY_PASS);
		
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_USER,User.PROPERTY_FIRST_NAME);
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_USER,User.PROPERTY_LAST_NAMES);
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_USER,User.PROPERTY_ELECTRONIC_MAIL_ADDRESS);
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_ROLE_POSTES);
	}

	@Override
	protected Object __getEntity__(SystemAction systemAction) {
		UserAccount userAccount = (UserAccount) super.__getEntity__(systemAction);
		if(systemAction instanceof SystemActionCreate) {
			userAccount.setUser(__inject__(User.class));
			userAccount.setAccount(__inject__(Account.class));
		}
		return userAccount;
	}
	
	@Override
	protected Object __readOne__(SystemAction systemAction,Class<?> klass, Object identifier, Properties properties) {
		if(properties == null)
			properties = new Properties();
		properties.setFields(UserAccount.PROPERTY_ROLE_POSTES);
		return super.__readOne__(systemAction,klass, identifier, properties);
	}
	
}
