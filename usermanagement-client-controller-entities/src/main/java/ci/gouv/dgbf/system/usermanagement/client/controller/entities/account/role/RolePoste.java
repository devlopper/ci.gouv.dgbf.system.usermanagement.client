package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import org.cyk.utility.client.controller.data.DataIdentifiedByStringAndCodedAndNamed;

public interface RolePoste extends DataIdentifiedByStringAndCodedAndNamed {

	RoleFunction getFunction();
	RolePoste setFunction(RoleFunction function);
	
	Ministry getMinistry();
	RolePoste setMinistry(Ministry ministry);
	
	Program getProgram();
	RolePoste setProgram(Program program);
	
	AdministrativeUnit getAdministrativeUnit();
	RolePoste setAdministrativeUnit(AdministrativeUnit administrativeUnit);
	
	@Override RolePoste setIdentifier(String identifier);
	@Override RolePoste setCode(String code);
	@Override RolePoste setName(String name);
	
	/**/
	
	String PROPERTY_FUNCTION = "function";
	String PROPERTY_MINISTRY = "ministry";
	String PROPERTY_PROGRAM = "program";
	String PROPERTY_ADMINISTRATIVE_UNIT = "administrativeUnit";
}
