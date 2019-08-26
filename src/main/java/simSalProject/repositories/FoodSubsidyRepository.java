package simSalProject.repositories;

import javax.persistence.TypedQuery;

import simSalProject.models.FoodSubsidy;


public class FoodSubsidyRepository extends EntityRepository<FoodSubsidy>{

	@Override
	protected String getAllIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getAllValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<FoodSubsidy> getEntityClass() {
		// TODO Auto-generated method stub
		return FoodSubsidy.class;
	}
	
	public FoodSubsidy getFoodSubsidyValue() {
		TypedQuery<FoodSubsidy> query = entityManager.createNamedQuery(FoodSubsidy.GET_ALL_FoodSubsidy_VALUE, FoodSubsidy.class);
		return query.getSingleResult();
	}
	
//	public void setFoodSubsidyValue(double newValue) {
//		TypedQuery<FoodSubsidy> query = entityManager.createQuery(FoodSubsidy.SET_NEW_VALUE_FOR_SUBSIDY, FoodSubsidy.class);
//		
}
