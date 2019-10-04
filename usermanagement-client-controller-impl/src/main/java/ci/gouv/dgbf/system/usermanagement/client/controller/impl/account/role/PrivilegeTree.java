package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account.role;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.web.jsf.primefaces.tag.Tree;
import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.server.persistence.query.filter.FilterDto;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.role.PrivilegeController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Privilege;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Profile;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PrivilegeTree extends Tree implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Collection<Profile> initialSelectedProfiles;
	
	public PrivilegeTree() {
		super(Privilege.class);
	}
	
	@Override
	protected void __initialise__() {
		/*
		 * Derived initial selected privileges from profiles
		 */
		Collection<Privilege> initialSelectedPrivileges = null;
		if(CollectionHelper.isNotEmpty(initialSelectedProfiles)) {
			FilterDto filter = new FilterDto();
			filter.addField(Privilege.PROPERTY_PROFILES, initialSelectedProfiles.stream().map(Profile::getIdentifier).collect(Collectors.toList()));
			initialSelectedPrivileges = __inject__(PrivilegeController.class).read(new Properties().setFilters(filter).setIsPageable(Boolean.FALSE));
		}
		//System.out.println("PrivilegeTree.__initialise__() ::: "+initialSelectedPrivileges);
		if(CollectionHelper.isNotEmpty(initialSelectedPrivileges))
			setInitialSelectedNodes(initialSelectedPrivileges);
		super.__initialise__();
	}
	
}