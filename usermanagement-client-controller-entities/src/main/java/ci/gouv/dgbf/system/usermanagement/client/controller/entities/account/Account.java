package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.Data;

public interface Account extends Data {

	@Override Account setIdentifier(Object identifier);
	@Override Account setCode(String code);
	
	String getPass();
	Account setPass(String pass);
	
	/**/
	
	String PROPERTY_PASS = "pass";
	
}
