package ci.gouv.dgbf.system.usermanagement.client.controller.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.object.AbstractLifeCycleListenerImpl;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.__kernel__.session.Session;
import org.cyk.utility.__kernel__.persistence.query.filter.FilterDto;

import ci.gouv.dgbf.system.usermanagement.client.controller.api.account.UserAccountController;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;

@ApplicationScoped @ci.gouv.dgbf.system.usermanagement.server.annotation.System
public class LifeCycleListenerImpl extends AbstractLifeCycleListenerImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void listenConstructing(Object object) {
		super.listenConstructing(object);
		if(object instanceof Session) {
			Session session = (Session) object;
			UserAccount userAccount = null;
			try {
				userAccount = CollectionHelper.getFirst(DependencyInjection.inject(UserAccountController.class).read(new Properties().setFilters(new FilterDto()
						.addField("account.identifier",  session.getUserName()))));
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			if(userAccount == null)
				return;
			session.getUserInterface(Boolean.TRUE).getTheme(Boolean.TRUE).setColor(userAccount.getColor());
		}
	}	
}
