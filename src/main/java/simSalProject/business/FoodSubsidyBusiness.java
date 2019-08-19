package simSalProject.business;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.FoodSubsidy;
import simSalProject.repositories.FoodSubsidyRepository;

@Named("FoodSubBus")
@RequestScoped
public class FoodSubsidyBusiness {
	@Inject
	@Named("FoodSubRep")
	FoodSubsidyRepository FOODSUB_DB;
	
	public FoodSubsidy getFoodSubsidyValue () {
		return FOODSUB_DB.getFoodSubsidyValue().get(0);
	}
	

	public void setFoodSubsidyValue(double newvalue) {
		FOODSUB_DB.setFoodSubsidyValue(newvalue);
		
	}
}
