package ci.gouv.dgbf.system.usermanagement.client.controller.entities;

import java.io.Serializable;

import org.cyk.utility.clazz.ClassHelper;
import org.cyk.utility.client.controller.data.AbstractDataFieldDescriptionsGetterImpl;
import org.cyk.utility.field.FieldDescription;
import org.cyk.utility.string.Strings;
import org.cyk.utility.system.action.SystemAction;
import org.cyk.utility.system.action.SystemActionCreate;
import org.cyk.utility.system.action.SystemActionUpdate;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Account;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccountInterim;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.FunctionScope;

@ci.gouv.dgbf.system.usermanagement.server.annotation.System
public class DataFieldDescriptionsGetterImpl extends AbstractDataFieldDescriptionsGetterImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected Strings __getNames__(SystemAction systemAction) {
		Strings strings = super.__getNames__(systemAction);
		if(UserAccountInterim.class.equals(systemAction.getEntityClass())) {
			strings.remove(UserAccountInterim.PROPERTY_IDENTIFIER);
		}
		return strings;
	}
	
	@Override
	protected void __process__(SystemAction systemAction, FieldDescription fieldDescription) {
		super.__process__(systemAction, fieldDescription);
		if(Boolean.TRUE.equals( __inject__(ClassHelper.class).isInstanceOf(systemAction.getEntityClass(), FunctionScope.class)) 
				&& (fieldDescription.getName().equals(FunctionScope.PROPERTY_CODE) || fieldDescription.getName().equals(FunctionScope.PROPERTY_NAME)) 
				&& (systemAction instanceof SystemActionCreate || systemAction instanceof SystemActionUpdate)) {
			fieldDescription.setIsNullable(Boolean.TRUE);
		}else if(Boolean.TRUE.equals( __inject__(ClassHelper.class).isInstanceOf(systemAction.getEntityClass(), UserAccount.class)) 
				&& fieldDescription.getName().equals(Account.PROPERTY_IDENTIFIER)) {
			fieldDescription.setName("Nom d'utilisateur");
		}else if(Boolean.TRUE.equals( __inject__(ClassHelper.class).isInstanceOf(systemAction.getEntityClass(), UserAccount.class)) 
				&& fieldDescription.getName().equals(Account.PROPERTY_PASS)) {
			fieldDescription.setName("Mot de passe");
		}
	}
	
}