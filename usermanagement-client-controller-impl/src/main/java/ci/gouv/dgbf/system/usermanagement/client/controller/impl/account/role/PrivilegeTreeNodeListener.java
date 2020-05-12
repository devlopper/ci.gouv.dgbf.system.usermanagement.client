package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account.role;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.cyk.utility.__kernel__.object.dynamic.AbstractObject;
import org.cyk.utility.__kernel__.persistence.query.filter.Filter;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.data.hierarchy.TreeNodeListener;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.PrivilegeController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Privilege;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.PrivilegeHierarchy;

public class PrivilegeTreeNodeListener extends AbstractObject implements TreeNodeListener<Privilege,PrivilegeHierarchy>,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public List<Privilege> getChildren(Privilege privilege) {
		Filter.Dto filter = new Filter.Dto().useKlass(ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.role.Privilege.class)
				.addField(ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.role.Privilege.FIELD_PARENTS, Arrays.asList(privilege.getIdentifier()));
		return (List<Privilege>) __inject__(PrivilegeController.class).read(new Properties().setFilters(filter));
	}

	@Override
	public Integer getNumberOfChildren(Privilege privilege) {
		Filter.Dto filter = new Filter.Dto().useKlass(ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.role.Privilege.class)
				.addField(ci.gouv.dgbf.system.usermanagement.server.persistence.entities.account.role.Privilege.FIELD_PARENTS, Arrays.asList(privilege.getIdentifier()));
		Long value = __inject__(PrivilegeController.class).count(new Properties().setFilters(filter));
		return value == null ? null : value.intValue();
	}

}
