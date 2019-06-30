package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;
import java.util.Collection;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.component.input.InputBuilder;
import org.cyk.utility.client.controller.component.input.choice.InputChoiceBuilder;
import org.cyk.utility.client.controller.component.view.ViewBuilder;
import org.cyk.utility.client.controller.component.window.AbstractWindowContainerManagedWindowBuilderEditDataImpl;
import org.cyk.utility.client.controller.data.Data;
import org.cyk.utility.client.controller.data.Form;
import org.cyk.utility.client.controller.event.EventName;
import org.cyk.utility.collection.CollectionHelper;
import org.cyk.utility.system.action.SystemAction;
import org.cyk.utility.system.action.SystemActionCreate;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Account;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.User;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccountEditWindowBuilder;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Function;

public class UserAccountEditWindowBuilderImpl extends AbstractWindowContainerManagedWindowBuilderEditDataImpl implements UserAccountEditWindowBuilder, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __execute__(Form form,SystemAction systemAction,Data data,ViewBuilder viewBuilder) {
		InputBuilder<?, ?> inputBuilder = (InputBuilder<?, ?>) viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_ACCOUNT
				,Account.PROPERTY_IDENTIFIER);
		inputBuilder.getLabel(Boolean.TRUE).setValue("Nom d'utilisateur");
		inputBuilder = (InputBuilder<?, ?>) viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_ACCOUNT,Account.PROPERTY_PASS);
		inputBuilder.getLabel(Boolean.TRUE).setValue("Mot de passe");
		
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_USER,User.PROPERTY_FIRST_NAME);
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_USER,User.PROPERTY_LAST_NAMES);
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_USER,User.PROPERTY_ELECTRONIC_MAIL_ADDRESS);
		InputChoiceBuilder<?, ?> functions = (InputChoiceBuilder<?, ?>) viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_FUNCTIONS);
		InputChoiceBuilder<?, ?> profiles = (InputChoiceBuilder<?, ?>) viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_PROFILES);
		profiles.setIsGetChoices(Boolean.FALSE);
		functions.addEvent(EventName.CHANGE, new Runnable() {
			@Override
			public void run() {
				@SuppressWarnings("unchecked")
				Collection<Function> values = (Collection<Function>) functions.getComponent().getValue();
				Collection<Profile> f;
				profiles.getComponent().addChoices(__inject__(CollectionHelper.class).cast(Object.class, values));
			}
		},profiles);
		
		//viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_POSTES);
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
		properties.setFields(UserAccount.PROPERTY_FUNCTION_SCOPES+","+UserAccount.PROPERTY_PROFILES);
		return super.__readOne__(systemAction,klass, identifier, properties);
	}
	
}
