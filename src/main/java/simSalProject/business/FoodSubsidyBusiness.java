package simSalProject.business;

import javax.inject.Inject;
import javax.transaction.Transactional;

import simSalProject.models.FoodSubsidy;
import simSalProject.repositories.FoodSubsidyRepository;


public class FoodSubsidyBusiness {
	@Inject
	FoodSubsidyRepository foodSubRepository;
	
	public FoodSubsidy getFoodSubsidyValue () {
		return foodSubRepository.getFoodSubsidyValue();
	}
	

	public void setFoodSubsidyValue(FoodSubsidy foodSubsidy) {
		long id = 1;
		foodSubsidy.setId(id);
		foodSubRepository.editEntity(foodSubsidy);
		
	}

	@Transactional
	public void createFoodSubsidy(FoodSubsidy foodSubsidy) {
		foodSubRepository.createEntity(foodSubsidy);
	}
}
