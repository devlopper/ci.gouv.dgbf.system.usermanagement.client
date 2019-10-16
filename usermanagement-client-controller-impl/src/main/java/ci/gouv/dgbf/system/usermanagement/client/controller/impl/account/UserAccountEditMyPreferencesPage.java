package ci.gouv.dgbf.system.usermanagement.client.controller.impl.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ci.gouv.dgbf.system.usermanagement.client.controller.impl.AbstractUserAccountBasedPageContainerManagedImpl;
import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class UserAccountEditMyPreferencesPage extends AbstractUserAccountBasedPageContainerManagedImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<SelectItem> colors;
	private String color;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		colors = new ArrayList<>();
		colors.add(new SelectItem("atlantis-orange", "Orange"));
		colors.add(new SelectItem("atlantis-blue", "Bleu"));
		colors.add(new SelectItem("atlantis-light-blue", "Bleu ciel"));
		colors.add(new SelectItem("atlantis-green", "Vert"));
	}
	
	@Override
	protected String __getWindowTitleValue__() {
		return "Mes préférences";
	}
	
}
