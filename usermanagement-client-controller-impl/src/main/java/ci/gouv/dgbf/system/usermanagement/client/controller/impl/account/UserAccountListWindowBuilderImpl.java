package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;

import org.cyk.utility.__kernel__.field.FieldHelper;
import org.cyk.utility.client.controller.component.grid.GridBuilder;
import org.cyk.utility.client.controller.component.grid.column.ColumnBuilder;
import org.cyk.utility.client.controller.component.window.AbstractWindowContainerManagedWindowBuilderListDataImpl;
import org.cyk.utility.client.controller.data.RowData;

import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.Account;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.User;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccount;
import ci.gouv.dgbf.system.usermanagement.client.controller.entities.account.UserAccountListWindowBuilder;

public class UserAccountListWindowBuilderImpl extends AbstractWindowContainerManagedWindowBuilderListDataImpl implements UserAccountListWindowBuilder, Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void __execute__(GridBuilder gridBuilder) {	
		ColumnBuilder column = null;
		column = __inject__(ColumnBuilder.class);
		column.addFieldNameStrings(FieldHelper
				.join(RowData.PROPERTY_DATA,UserAccount.PROPERTY_ACCOUNT,Account.PROPERTY_IDENTIFIER));
		column.setHeaderTextValue("Nom d'utilisateur");
		gridBuilder.getColumns(Boolean.TRUE).add(column);
		
		gridBuilder.addColumnsByFieldNames(FieldHelper.join(RowData.PROPERTY_DATA,UserAccount.PROPERTY_USER,User.PROPERTY_FIRST_NAME));
		gridBuilder.addColumnsByFieldNames(FieldHelper.join(RowData.PROPERTY_DATA,UserAccount.PROPERTY_USER,User.PROPERTY_LAST_NAMES));
		gridBuilder.addColumnsByFieldNames(FieldHelper.join(RowData.PROPERTY_DATA,UserAccount.PROPERTY_USER,User.PROPERTY_ELECTRONIC_MAIL_ADDRESS));
	}
	
}
