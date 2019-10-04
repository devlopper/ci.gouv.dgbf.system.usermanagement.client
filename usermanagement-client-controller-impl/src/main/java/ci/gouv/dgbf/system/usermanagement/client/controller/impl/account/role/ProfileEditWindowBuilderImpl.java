package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account.role;

import java.io.Serializable;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.__kernel__.system.action.SystemAction;
import org.cyk.utility.client.controller.component.ComponentBuilder;
import org.cyk.utility.client.controller.component.input.choice.ChoicesLayoutResponsive;
import org.cyk.utility.client.controller.component.input.choice.InputChoiceBuilder;
import org.cyk.utility.client.controller.component.view.ViewBuilder;
import org.cyk.utility.client.controller.component.window.AbstractWindowContainerManagedWindowBuilderEditDataImpl;
import org.cyk.utility.client.controller.data.Data;
import org.cyk.utility.client.controller.data.Form;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.ProfileEditWindowBuilder;

public class ProfileEditWindowBuilderImpl extends AbstractWindowContainerManagedWindowBuilderEditDataImpl implements ProfileEditWindowBuilder, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __execute__(Form form,SystemAction systemAction,Data data,ViewBuilder viewBuilder) {
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, Profile.PROPERTY_CODE);
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, Profile.PROPERTY_NAME);
		ComponentBuilder<?> functions = (ComponentBuilder<?>) viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, Profile.PROPERTY_FUNCTIONS);
		if(functions instanceof InputChoiceBuilder) {
			((InputChoiceBuilder<?, ?>)functions).setChoicesLayout(__inject__(ChoicesLayoutResponsive.class).setNumberOfColumns(1));	
		}
	}

	@Override
	protected Object __readOne__(SystemAction systemAction,Class<?> klass, Object identifier, Properties properties) {
		if(properties == null)
			properties = new Properties();
		properties.setFields(Profile.PROPERTY_FUNCTIONS);
		return super.__readOne__(systemAction,klass, identifier, properties);
	}
	
}
