package simSalProject.business;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.Margin;
import simSalProject.repositories.MarginRepository;



@Named("MarginBus")
@RequestScoped
public class MarginBusiness {

	
	@Inject
	@Named("MarginRep")
	MarginRepository MARGIN_DB;
	
	public List<Margin> getMarginValues () {
		return MARGIN_DB.getMarginValues();
	}
	

	public void setMarginValue(Margin newValue) {
		
		MARGIN_DB.setNewMarginValues(newValue);
		
	}

}
