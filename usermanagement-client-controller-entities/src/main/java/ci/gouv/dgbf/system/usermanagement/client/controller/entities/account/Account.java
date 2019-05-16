package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCoded;

public interface Account extends DataIdentifiedByStringAndCoded {

	@Override Account setIdentifier(Object identifier);
	@Override Account setCode(String code);
	
	String getPass();
	Account setPass(String pass);
	
	/**/
	
	String PROPERTY_PASS = "pass";
	
}
