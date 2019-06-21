package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

public class UserAccountInterimModelImpl extends AbstractUserAccountInterimCommonImpl implements UserAccountInterimModel,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public UserAccountInterimModel setIdentifier(String identifier) {
		return (UserAccountInterimModel) super.setIdentifier(identifier);
	}
	
}
