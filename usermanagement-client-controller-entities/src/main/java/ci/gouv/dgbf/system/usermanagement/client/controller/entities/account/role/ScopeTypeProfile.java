package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import org.cyk.utility.client.controller.data.AbstractDataIdentifiableSystemStringImpl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor //@Accessors(chain=true)
public class ScopeTypeProfile extends AbstractDataIdentifiableSystemStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private Profile profile;
	private ScopeTypeImpl scopeType;
	
	public static final String FIELD_PROFILE = "profile";
	public static final String FIELD_SCOPE_TYPE = "scopeType";
	
}