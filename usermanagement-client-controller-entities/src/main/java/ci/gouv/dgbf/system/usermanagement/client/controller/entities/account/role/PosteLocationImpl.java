package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputChoice;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOne;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOneCombo;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringImpl;

public class PosteLocationImpl extends AbstractDataIdentifiedByStringImpl implements PosteLocation,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Input @InputChoice @InputChoiceOne @InputChoiceOneCombo
	private PosteLocationType type;
	
	@Override
	public PosteLocationType getType() {
		return type;
	}
	
	@Override
	public PosteLocation setType(PosteLocationType type) {
		this.type = type;
		return this;
	}
	
	@Override
	public PosteLocation setIdentifier(String identifier) {
		return (PosteLocation) super.setIdentifier(identifier);
	}
	
}
