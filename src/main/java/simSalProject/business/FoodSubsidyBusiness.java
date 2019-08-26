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
	FoodSubsidyRepository foodSubRepository;
	
	public FoodSubsidy getFoodSubsidyValue () {
		return foodSubRepository.getFoodSubsidyValue();
	}
	

	public void setFoodSubsidyValue(FoodSubsidy foodSubsidy) {
		long id = 1;
		foodSubsidy.setId(id);
		foodSubRepository.editEntity(foodSubsidy);
		
	}


	public void createFoodSubsidy(FoodSubsidy foodSubsidy) {
		foodSubRepository.createEntity(foodSubsidy);
	}
}
