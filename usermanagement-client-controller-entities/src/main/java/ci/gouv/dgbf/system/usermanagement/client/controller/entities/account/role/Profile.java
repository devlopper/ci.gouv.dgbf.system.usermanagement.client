package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.util.Collection;
import java.util.List;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCodedAndNamed;

public interface Profile extends DataIdentifiedByStringAndCodedAndNamed {

	ProfileType getType();
	Profile setType(ProfileType type);
	
	List<Function> getFunctions();
	List<Function> getFunctions(Boolean injectIfNull);
	Profile setFunctions(List<Function> functions);
	Profile addFunctions(Collection<Function> functions);
	Profile addFunctions(Function...functions);
	Profile addFunctionsByCodes(Collection<String> codes);
	Profile addFunctionsByCodes(String...codes);
	
	List<Privilege> getPrivileges();
	List<Privilege> getPrivileges(Boolean injectIfNull);
	Profile setPrivileges(List<Privilege> privileges);
	Profile addPrivileges(Collection<Privilege> privileges);
	Profile addPrivileges(Privilege...privileges);
	Profile addPrivilegesByCodes(Collection<String> codes);
	Profile addPrivilegesByCodes(String...codes);
	
	@Override Profile setIdentifier(String identifier);
	@Override Profile setCode(String code);
	@Override Profile setName(String name);
	
	String PROPERTY_TYPE = "type";
	String PROPERTY_FUNCTIONS = "functions";
	String PROPERTY_PRIVILEGES = "privileges";
}
