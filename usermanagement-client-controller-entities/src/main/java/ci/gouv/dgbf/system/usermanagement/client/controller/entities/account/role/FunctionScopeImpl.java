package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.role;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputChoice;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOne;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOneAutoComplete;
import org.cyk.utility.client.controller.component.annotation.InputChoiceOneCombo;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedAndNamedImpl;

public class FunctionScopeImpl extends AbstractDataIdentifiedByStringAndCodedAndNamedImpl implements FunctionScope,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputChoice @InputChoiceOne @InputChoiceOneCombo
	@NotNull
	private Function function;
	
	@Input @InputChoice @InputChoiceOne @InputChoiceOneAutoComplete
	private Scope scope;
	
	@Override
	public Function getFunction() {
		return function;
	}
	@Override
	public FunctionScope setFunction(Function function) {
		this.function = function;
		return this;
	}
	
	@Override
	public Scope getScope() {
		return scope;
	}
	
	@Override
	public FunctionScope setScope(Scope scope) {
		this.scope = scope;
		return this;
	}
	
	@Override
	public FunctionScope setIdentifier(String identifier) {
		return (FunctionScope) super.setIdentifier(identifier);
	}
	
	@Override
	public FunctionScope setCode(String code) {
		return (FunctionScope) super.setCode(code);
	}
	
	@Override
	public FunctionScope setName(String name) {
		return (FunctionScope) super.setName(name);
	}
}