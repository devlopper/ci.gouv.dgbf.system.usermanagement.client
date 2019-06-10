package ci.gouv.dgbf.system.usermanagement.client.controller.entities;

import java.io.Serializable;

import org.cyk.utility.clazz.ClassHelper;
import org.cyk.utility.client.controller.data.AbstractDataFieldDescriptionsGetterImpl;
import org.cyk.utility.field.FieldDescription;
import org.cyk.utility.system.action.SystemAction;
import org.cyk.utility.system.action.SystemActionCreate;
import org.cyk.utility.system.action.SystemActionUpdate;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.RolePoste;

@ci.gouv.dgbf.system.usermanagement.server.annotation.System
public class DataFieldDescriptionsGetterImpl extends AbstractDataFieldDescriptionsGetterImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __process__(SystemAction systemAction, FieldDescription fieldDescription) {
		super.__process__(systemAction, fieldDescription);
		if(Boolean.TRUE.equals( __inject__(ClassHelper.class).isInstanceOf(systemAction.getEntityClass(), RolePoste.class)) 
				&& (fieldDescription.getName().equals(RolePoste.PROPERTY_CODE) || fieldDescription.getName().equals(RolePoste.PROPERTY_NAME)) 
				&& (systemAction instanceof SystemActionCreate || systemAction instanceof SystemActionUpdate)) {
			fieldDescription.setIsNullable(Boolean.TRUE);
		}
	}
	
}