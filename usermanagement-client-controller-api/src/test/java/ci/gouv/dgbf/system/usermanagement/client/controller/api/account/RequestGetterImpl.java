package ci.gouv.dgbf.system.usermanagement.client.controller.api.account;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;

import org.cyk.utility.__kernel__.annotation.Test;
import org.cyk.utility.function.AbstractFunctionWithPropertiesAsInputImpl;
import org.cyk.utility.request.RequestGetter;
import org.cyk.utility.throwable.ThrowableHelper;

@Dependent @Test
public class RequestGetterImpl extends AbstractFunctionWithPropertiesAsInputImpl<Object> implements RequestGetter,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected Object __execute__() throws Exception {
		System.out.println("RequestGetterImpl.__execute__()");
		if(FacesContext.getCurrentInstance() == null)
			__inject__(ThrowableHelper.class).throwRuntimeException("We cannot get request because FacesContext current instance is null.");
		return FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}
	
}
