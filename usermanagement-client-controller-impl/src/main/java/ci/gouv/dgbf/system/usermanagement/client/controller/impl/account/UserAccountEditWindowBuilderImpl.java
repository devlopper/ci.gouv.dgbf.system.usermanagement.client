package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;

import org.cyk.utility.client.controller.component.view.ViewBuilder;
import org.cyk.utility.client.controller.component.window.AbstractWindowContainerManagedWindowBuilderEditDataImpl;
import org.cyk.utility.client.controller.data.Data;
import org.cyk.utility.client.controller.data.Form;
import org.cyk.utility.system.action.SystemAction;
import org.cyk.utility.system.action.SystemActionCreate;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.User;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccountEditWindowBuilder;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserNaturalPerson;

public class UserAccountEditWindowBuilderImpl extends AbstractWindowContainerManagedWindowBuilderEditDataImpl implements UserAccountEditWindowBuilder, Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __execute__(Form form,SystemAction systemAction,Data data,ViewBuilder viewBuilder) {
		if(systemAction instanceof SystemActionCreate) {
			((UserAccount)data).setUser(__inject__(User.class));
			((UserAccount)data).getUser().setPerson(__inject__(UserNaturalPerson.class));
		}
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_USER,User.PROPERTY_PERSON,UserNaturalPerson.PROPERTY_FIRST_NAME);
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_USER,User.PROPERTY_PERSON,UserNaturalPerson.PROPERTY_LAST_NAMES);
		viewBuilder.addInputBuilderByObjectByFieldNames(data,systemAction, UserAccount.PROPERTY_USER,User.PROPERTY_ELECTRONIC_MAIL_ADDRESS);
	}

}
