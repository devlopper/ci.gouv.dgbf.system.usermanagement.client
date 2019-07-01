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
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedAndNamedImpl;
import org.cyk.utility.collection.CollectionHelper;

public class ProfileImpl extends AbstractDataIdentifiedByStringAndCodedAndNamedImpl implements Profile,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Input @InputChoice @InputChoiceMany @InputChoiceManyCheckBox
	private List<Function> functions;
	
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
		if(Boolean.TRUE.equals(__inject__(CollectionHelper.class).isNotEmpty(functions)))
			getFunctions(Boolean.TRUE).addAll(functions);
		return this;
	}

	@Override
	public Profile addFunctions(Function... functions) {
		if(Boolean.TRUE.equals(__inject__(ArrayHelper.class).isNotEmpty(functions)))
			addFunctions(__inject__(CollectionHelper.class).instanciate(functions));
		return this;
	}
	
	@Override
	public Profile addFunctionsByCodes(Collection<String> codes) {
		if(Boolean.TRUE.equals(__inject__(CollectionHelper.class).isNotEmpty(codes))) {
			for(String index : codes)
				addFunctions(__inject__(Function.class).setCode(index));
		}
		return this;
	}
	
	@Override
	public Profile addFunctionsByCodes(String... codes) {
		if(Boolean.TRUE.equals(__inject__(ArrayHelper.class).isNotEmpty(codes)))
			addFunctionsByCodes(__inject__(CollectionHelper.class).instanciate(codes));
		return this;
	}
	
	/**/
}
