package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.cyk.utility.array.ArrayHelper;
import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputChoice;
import org.cyk.utility.client.controller.component.annotation.InputChoiceMany;
import org.cyk.utility.client.controller.component.annotation.InputChoiceManyCheckBox;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOne;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOneCombo;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedAndNamedImpl;
import org.cyk.utility.__kernel__.collection.CollectionHelper;

public class ProfileImpl extends AbstractDataIdentifiedByStringAndCodedAndNamedImpl implements Profile,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Input @InputChoice @InputChoiceOne @InputChoiceOneCombo
	private ProfileType type;
	
	@Input @InputChoice @InputChoiceMany @InputChoiceManyCheckBox
	private List<Function> functions;
	
	@Input @InputChoice @InputChoiceMany @InputChoiceManyCheckBox
	private List<Privilege> privileges;
	
	@Override
	public ProfileType getType() {
		return type;
	}
	
	@Override
	public Profile setType(ProfileType type) {
		this.type = type;
		return this;
	}
	
	@Override
	public List<Function> getFunctions() {
		return functions;
	}

	@Override
	public List<Function> getFunctions(Boolean injectIfNull) {
		if(functions == null && Boolean.TRUE.equals(injectIfNull))
			functions = new ArrayList<>();
		return functions;
	}

	@Override
	public Profile setFunctions(List<Function> functions) {
		this.functions = functions;
		return this;
	}

	@Override
	public Profile addFunctions(Collection<Function> functions) {
		if(CollectionHelper.isNotEmpty(functions))
			getFunctions(Boolean.TRUE).addAll(functions);
		return this;
	}

	@Override
	public Profile addFunctions(Function... functions) {
		if(Boolean.TRUE.equals(__inject__(ArrayHelper.class).isNotEmpty(functions)))
			addFunctions(CollectionHelper.listOf(functions));
		return this;
	}
	
	@Override
	public Profile addFunctionsByCodes(Collection<String> codes) {
		if(CollectionHelper.isNotEmpty(codes)) {
			for(String index : codes)
				addFunctions(__inject__(Function.class).setCode(index));
		}
		return this;
	}
	
	@Override
	public Profile addFunctionsByCodes(String... codes) {
		if(Boolean.TRUE.equals(__inject__(ArrayHelper.class).isNotEmpty(codes)))
			addFunctionsByCodes(CollectionHelper.listOf(codes));
		return this;
	}
	
	@Override
	public List<Privilege> getPrivileges() {
		return privileges;
	}

	@Override
	public List<Privilege> getPrivileges(Boolean injectIfNull) {
		if(privileges == null && Boolean.TRUE.equals(injectIfNull))
			privileges = new ArrayList<>();
		return privileges;
	}

	@Override
	public Profile setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
		return this;
	}

	@Override
	public Profile addPrivileges(Collection<Privilege> privileges) {
		if(CollectionHelper.isNotEmpty(privileges))
			getPrivileges(Boolean.TRUE).addAll(privileges);
		return this;
	}

	@Override
	public Profile addPrivileges(Privilege... privileges) {
		if(Boolean.TRUE.equals(__inject__(ArrayHelper.class).isNotEmpty(privileges)))
			addPrivileges(CollectionHelper.listOf(privileges));
		return this;
	}
	
	@Override
	public Profile addPrivilegesByCodes(Collection<String> codes) {
		if(CollectionHelper.isNotEmpty(codes)) {
			for(String index : codes)
				addPrivileges(__inject__(Privilege.class).setCode(index));
		}
		return this;
	}
	
	@Override
	public Profile addPrivilegesByCodes(String... codes) {
		if(Boolean.TRUE.equals(__inject__(ArrayHelper.class).isNotEmpty(codes)))
			addPrivilegesByCodes(CollectionHelper.listOf(codes));
		return this;
	}
	
	@Override
	public Profile setIdentifier(String identifier) {
		return (Profile) super.setIdentifier(identifier);
	}
	
	@Override
	public Profile setCode(String code) {
		return (Profile) super.setCode(code);
	}
	
	@Override
	public Profile setName(String name) {
		return (Profile) super.setName(name);
	}
	
	/**/
}
