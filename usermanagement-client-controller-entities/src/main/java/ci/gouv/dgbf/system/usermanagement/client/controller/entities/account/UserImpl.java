package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputChoice;
import org.cyk.utility.client.controller.component.annotation.InputChoiceMany;
import org.cyk.utility.client.controller.component.annotation.InputChoiceManyAutoComplete;
import org.cyk.utility.client.controller.component.annotation.InputString;
import org.cyk.utility.client.controller.component.annotation.InputStringLineOne;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringImpl;
import org.cyk.utility.collection.CollectionHelper;
import org.cyk.utility.string.StringHelper;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role.Function;

public class UserImpl extends AbstractDataIdentifiedByStringImpl implements User,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputString @InputStringLineOne @NotNull private String firstName;
	@Input @InputString @InputStringLineOne @NotNull private String lastNames;
	@Input @InputString @InputStringLineOne @NotNull private String electronicMailAddress;
	private String names;
	
	@Input @InputChoice @InputChoiceMany @InputChoiceManyAutoComplete
	private List<Function> functions;
	
	@Override
	public User setIdentifier(String identifier) {
		return (User) super.setIdentifier(identifier);
	}

	@Override
	public String getFirstName() {
		return firstName;
	}
	
	@Override
	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	@Override
	public String getLastNames() {
		return lastNames;
	}
	
	@Override
	public User setLastNames(String lastNames) {
		this.lastNames = lastNames;
		return this;
	}
	
	@Override
	public String getNames() {
		if(names == null) {
			names = firstName;
			if(Boolean.TRUE.equals(__inject__(StringHelper.class).isNotBlank(lastNames)))
				names += " " + lastNames; 
		}
		return names;
	}
	
	@Override
	public User setNames(String names) {
		this.names = names;
		return this;
	}
	
	@Override
	public String getElectronicMailAddress() {
		return electronicMailAddress;
	}

	@Override
	public User setElectronicMailAddress(String electronicMailAddress) {
		this.electronicMailAddress = electronicMailAddress;
		return this;
	}
	
	@Override
	public List<Function> getFunctions() {
		return functions;
	}
	
	@Override
	public User setFunctions(List<Function> functions) {
		this.functions = functions;
		return this;
	}
	
	@Override
	public List<Function> getFunctions(Boolean injectIfNull) {
		if(functions == null && Boolean.TRUE.equals(injectIfNull))
			functions = new ArrayList<>();
		return functions;
	}
	
	@Override
	public User addFunctions(Collection<Function> functions) {
		getFunctions(Boolean.TRUE).addAll(functions);
		return this;
	}
	
	@Override
	public User addFunctions(Function... functions) {
		addFunctions(__inject__(CollectionHelper.class).instanciate(functions));
		return this;
	}
}
