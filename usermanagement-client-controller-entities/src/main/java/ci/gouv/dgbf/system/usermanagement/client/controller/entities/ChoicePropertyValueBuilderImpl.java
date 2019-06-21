package ci.gouv.dgbf.system.usermanagement.client.controller.entities;
import java.io.Serializable;

import org.cyk.utility.__kernel__.constant.ConstantCharacter;
import org.cyk.utility.client.controller.component.input.choice.AbstractChoicePropertyValueBuilderImpl;
import org.cyk.utility.client.controller.component.input.choice.ChoiceProperty;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.PosteLocation;

@ci.gouv.dgbf.system.usermanagement.server.annotation.System
public class ChoicePropertyValueBuilderImpl extends AbstractChoicePropertyValueBuilderImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected String __execute__() throws Exception {
		Object object = getObject();
		if(object instanceof PosteLocation) {
			ChoiceProperty property = getProperty();
			if(ChoiceProperty.LABEL.equals(property))
				return ((PosteLocation)object).getType().getName()+ConstantCharacter.SPACE+((PosteLocation)object).getIdentifier();
		}else if(object instanceof UserAccount) {
			ChoiceProperty property = getProperty();
			if(ChoiceProperty.LABEL.equals(property))
				return ((UserAccount)object).getAccount().getIdentifier()+" | "+((UserAccount)object).getUser().getNames();
		}
		return super.__execute__();
	}
	
}