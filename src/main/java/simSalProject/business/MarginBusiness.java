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
	MarginRepository marginRepository;
	
	public List<Margin> getMarginValues () {
		return marginRepository.getMarginValues();
	}
	

	public void setMarginValue(Margin newValue) {
		
		marginRepository.setNewMarginValues(newValue);
		
	}

}
