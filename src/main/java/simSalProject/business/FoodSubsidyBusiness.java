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
		return FOODSUB_DB.getFoodSubsidyValue();
	}
	

	public void setFoodSubsidyValue(FoodSubsidy foodSubsidy) {
		long id = 1;
		foodSubsidy.setId(id);
		FOODSUB_DB.editEntity(foodSubsidy);
		
	}


	public void createFoodSubsidy(FoodSubsidy foodSubsidy) {
		FOODSUB_DB.createEntity(foodSubsidy);
	}
}
