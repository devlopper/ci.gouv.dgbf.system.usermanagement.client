package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

public interface Account extends DataIdentifiedByString {

	@Override Account setIdentifier(String identifier);
	
	String getPass();
	Account setPass(String pass);
	
	/**/
	
	String PROPERTY_PASS = "pass";
	
}
