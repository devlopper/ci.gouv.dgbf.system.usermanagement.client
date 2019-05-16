package ci.gouv.dgbf.system.usermanagement.client.controller.entities.account;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputString;
import org.cyk.utility.client.controller.component.annotation.InputStringLineMany;
import org.cyk.utility.client.controller.component.annotation.InputStringLineOne;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringAndCodedImpl;

public class ServiceImpl extends AbstractDataIdentifiedByStringAndCodedImpl implements Service,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputString @InputStringLineOne @NotNull
	private String name;
	
	@Input @InputString @InputStringLineMany
	private String description;
	
	@Input @InputString @InputStringLineOne @NotNull
	private String uniformResourceLocator;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public Service setName(String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public Service setDescription(String description) {
		this.description = description;
		return this;
	}
	
	@Override
	public String getUniformResourceLocator() {
		return uniformResourceLocator;
	}
	
	@Override
	public Service setUniformResourceLocator(String uniformResourceLocator) {
		this.uniformResourceLocator = uniformResourceLocator;
		return this;
	}
	
	@Override
	public Service setIdentifier(Object identifier) {
		return (Service) super.setIdentifier(identifier);
	}
	
	@Override
	public Service setCode(String code) {
		return (Service) super.setCode(code);
	}

}
