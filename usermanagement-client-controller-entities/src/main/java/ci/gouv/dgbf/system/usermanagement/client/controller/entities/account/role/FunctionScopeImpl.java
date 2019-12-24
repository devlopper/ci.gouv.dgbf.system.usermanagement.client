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
	private ScopeImpl scope;
	
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
	public ScopeImpl getScope() {
		return scope;
	}
	
	@Override
	public FunctionScope setScope(ScopeImpl scope) {
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
	
	@Override
	public String toString() {
		return function+"/"+scope;
	}
}
