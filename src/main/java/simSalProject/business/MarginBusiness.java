package simSalProject.business;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import simSalProject.models.Margin;
import simSalProject.repositories.MarginRepository;


public class MarginBusiness {

	
	@Inject
	MarginRepository marginRepository;
	
	public List<Margin> getMarginValues () {
		return marginRepository.getMarginValues();
	}
	
	@Transactional
	public String editMarginValue(long id, Margin newValue) {
		if(marginRepository.getMarginById(id).size() > 0) {
			newValue.setId(id);
			marginRepository.editEntity(newValue);
			return "Edited";
		} else {
			return "Not Edited";
		}
	}

	@Transactional
	public Margin createMarginValue(Margin newValue) {
		return marginRepository.createEntity(newValue);
	}
	
	
	

}
