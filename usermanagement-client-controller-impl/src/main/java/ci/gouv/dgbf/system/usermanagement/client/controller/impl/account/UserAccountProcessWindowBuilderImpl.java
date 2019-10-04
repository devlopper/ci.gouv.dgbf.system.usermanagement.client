package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.__kernel__.system.action.SystemAction;
import org.cyk.utility.client.controller.component.input.InputBuilder;
import org.cyk.utility.client.controller.component.input.choice.ChoicesLayoutResponsive;
import org.cyk.utility.client.controller.component.input.choice.InputChoiceBuilder;
import org.cyk.utility.client.controller.component.view.ViewBuilder;
import org.cyk.utility.client.controller.component.window.AbstractWindowContainerManagedWindowBuilderProcessDataImpl;
import org.cyk.utility.client.controller.data.Data;
import org.cyk.utility.client.controller.data.Form;
import org.cyk.utility.client.controller.event.EventName;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.ProfileFunctionController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.User;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccountProcessWindowBuilder;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Function;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ProfileFunction;
import ci.gouv.dgbf.system.usermanagement.server.Constant;

public class UserAccountProcessWindowBuilderImpl extends AbstractWindowContainerManagedWindowBuilderProcessDataImpl implements UserAccountProcessWindowBuilder,Serializable {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void __execute__(Form form,SystemAction systemAction, Data data, ViewBuilder viewBuilder) {
		if(Constant.SYSTEM_ACTION_IDENTIFIER_ASSIGN_PRIVILEGES.equals(systemAction.getIdentifier()) || Constant.SYSTEM_ACTION_IDENTIFIER_ASSIGN_FUNCTION_SCOPES
				.equals(systemAction.getIdentifier())) {
			if(Constant.SYSTEM_ACTION_IDENTIFIER_ASSIGN_PRIVILEGES.equals(systemAction.getIdentifier())) {
				viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.FALSE, UserAccount.PROPERTY_ACCOUNT,User.PROPERTY_IDENTIFIER);
				
				viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.FALSE, UserAccount.PROPERTY_USER,User.PROPERTY_FIRST_NAME);
				viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.FALSE, UserAccount.PROPERTY_USER,User.PROPERTY_LAST_NAMES);
				viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.FALSE, UserAccount.PROPERTY_USER,User.PROPERTY_ELECTRONIC_MAIL_ADDRESS);
				
				//InputBuilder<?, ?> inputBuilder = (InputBuilder<?, ?>) viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.TRUE, UserAccount.PROPERTY_PROFILES);
				//inputBuilder.setIsNullable(Boolean.FALSE);
				
				InputChoiceBuilder<?, ?> functions = (InputChoiceBuilder<?, ?>) viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.TRUE,UserAccount.PROPERTY_USER, User.PROPERTY_FUNCTIONS);
				functions.setChoicesLayout(__inject__(ChoicesLayoutResponsive.class).setNumberOfColumns(5));
				InputChoiceBuilder<?, ?> profiles = (InputChoiceBuilder<?, ?>) viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.TRUE, UserAccount.PROPERTY_PROFILES);
				profiles.setIsGetChoices(Boolean.FALSE);
				profiles.addChoices((Collection)((UserAccount)data).getProfiles());
				functions.addEvent(EventName.CHANGE, new Runnable() {
					@Override
					public void run() {
						Collection<Function> selectedFunctions = (Collection<Function>) functions.getComponent().getValue();
						Map<String,Object> map = null;
						if(Boolean.TRUE.equals(CollectionHelper.isNotEmpty(selectedFunctions))) {
							map = __injectMapHelper__().instanciateKeyAsStringValueAsObject(ProfileFunction.PROPERTY_FUNCTION
									,selectedFunctions.stream().map(Function::getCode).collect(Collectors.toList()));
						}
						Collection<ProfileFunction> profileFunctions = __inject__(ProfileFunctionController.class).read(new Properties().setIsPageable(Boolean.FALSE)
								.setFilters(map));
						Collection<Profile> selectableProfiles = null;
						if(Boolean.TRUE.equals(CollectionHelper.isNotEmpty(profileFunctions))) {
							selectableProfiles = profileFunctions.stream().map(ProfileFunction::getProfile).collect(Collectors.toSet());
						}
						
						if(profiles.getComponent().getChoices()!=null)
							profiles.getComponent().getChoices().removeAll();
						((UserAccount)data).setProfiles(null);
						
						if(Boolean.TRUE.equals(CollectionHelper.isNotEmpty(selectableProfiles))) {
							((UserAccount)data).addProfiles(selectableProfiles);
							profiles.getComponent().addChoices(CollectionHelper.cast(Object.class, selectableProfiles));	
						}
					}
				},profiles);
			}else if(Constant.SYSTEM_ACTION_IDENTIFIER_ASSIGN_FUNCTION_SCOPES.equals(systemAction.getIdentifier())) {
				viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.FALSE, UserAccount.PROPERTY_ACCOUNT,User.PROPERTY_IDENTIFIER);
				
				viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.FALSE, UserAccount.PROPERTY_USER,User.PROPERTY_FIRST_NAME);
				viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.FALSE, UserAccount.PROPERTY_USER,User.PROPERTY_LAST_NAMES);
				viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.FALSE, UserAccount.PROPERTY_USER,User.PROPERTY_ELECTRONIC_MAIL_ADDRESS);
				
				InputBuilder<?, ?> inputBuilder = (InputBuilder<?, ?>) viewBuilder.addInputBuilderByObjectByFieldNames(data, Boolean.TRUE, UserAccount.PROPERTY_FUNCTION_SCOPES);
				inputBuilder.setIsNullable(Boolean.FALSE);
			}
		}
	}

	@Override
	protected Object __readOne__(SystemAction systemAction,Class<?> klass, Object identifier, Properties properties) {
		if(properties == null)
			properties = new Properties();
		if(Constant.SYSTEM_ACTION_IDENTIFIER_ASSIGN_PRIVILEGES.equals(systemAction.getIdentifier())) {
			properties.setFields(UserAccount.PROPERTY_PROFILES);
		}else if(Constant.SYSTEM_ACTION_IDENTIFIER_ASSIGN_FUNCTION_SCOPES.equals(systemAction.getIdentifier())) {
			properties.setFields(UserAccount.PROPERTY_FUNCTION_SCOPES);
		}
		return super.__readOne__(systemAction,klass, identifier, properties);
	}
		
}
