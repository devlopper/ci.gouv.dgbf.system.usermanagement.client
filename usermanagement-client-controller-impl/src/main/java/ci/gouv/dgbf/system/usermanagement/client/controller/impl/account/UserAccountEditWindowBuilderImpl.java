package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.component.ComponentBuilder;
import org.cyk.utility.client.controller.component.input.InputBuilder;
import org.cyk.utility.client.controller.component.output.OutputStringTextBuilder;
import org.cyk.utility.client.controller.component.view.ViewBuilder;
import org.cyk.utility.client.controller.component.window.AbstractWindowContainerManagedWindowBuilderEditDataImpl;
import org.cyk.utility.client.controller.data.Data;
import org.cyk.utility.client.controller.data.Form;
import org.cyk.utility.system.action.SystemAction;
import org.cyk.utility.system.action.SystemActionCreate;
import org.cyk.utility.system.action.SystemActionRead;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Account;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.User;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccountEditWindowBuilder;

public class UserAccountEditWindowBuilderImpl extends AbstractWindowContainerManagedWindowBuilderEditDataImpl implements UserAccountEditWindowBuilder, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __execute__(Form form,SystemAction systemAction,Data data,ViewBuilder viewBuilder) {
		ComponentBuilder<?> componentBuilder = (ComponentBuilder<?>) viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_ACCOUNT
				,Account.PROPERTY_IDENTIFIER);
		if(componentBuilder instanceof InputBuilder) {
			InputBuilder<?, ?> inputBuilder = (InputBuilder<?, ?>) componentBuilder;
			inputBuilder.getLabel(Boolean.TRUE).setValue("Nom d'utilisateur");
			inputBuilder = (InputBuilder<?, ?>) viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_ACCOUNT,Account.PROPERTY_PASS);
			inputBuilder.getLabel(Boolean.TRUE).setValue("Mot de passe");	
		}else if(componentBuilder instanceof OutputStringTextBuilder) {
			OutputStringTextBuilder outputStringTextBuilder = (OutputStringTextBuilder) componentBuilder;
			//outputStringTextBuilder.getl
		}
		
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_USER,User.PROPERTY_FIRST_NAME);
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_USER,User.PROPERTY_LAST_NAMES);
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_USER,User.PROPERTY_ELECTRONIC_MAIL_ADDRESS);
		
		if(systemAction instanceof SystemActionRead) {
			viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_PROFILES);
			viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_FUNCTION_SCOPES);
		}
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
		if(systemAction instanceof SystemActionRead) {
			properties.setFields(UserAccount.PROPERTY_PROFILES+","+UserAccount.PROPERTY_FUNCTION_SCOPES);
		}
		return super.__readOne__(systemAction,klass, identifier, properties);
	}
	
}
