package simSalProject.business;

import java.util.List;

import javax.inject.Inject;

import simSalProject.models.Margin;
import simSalProject.repositories.MarginRepository;


public class MarginBusiness {

	
	@Inject
	MarginRepository marginRepository;
	
	public List<Margin> getMarginValues () {
		return marginRepository.getMarginValues();
	}
	

	public void setMarginValue(Margin newValue) {
		
		marginRepository.setNewMarginValues(newValue);
		
	}

}
