package simSalProject.models;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=FoodSubsidy.GET_ALL_FoodSubsidy_VALUE, query="SELECT h FROM FoodSubsidy h")
})
public class FoodSubsidy extends Entity_{
	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL_FoodSubsidy_VALUE = "getFoodSubsidy";

	public static final String SET_NEW_VALUE_FOR_SUBSIDY = null;

	public FoodSubsidy() {}
	
	private double foodSubsidyMonth;
	private int averageDaysOfTheMonth;
	private double limitValueForFoodSubsidy;

	public double getFoodSubsidyMonth() {
		return foodSubsidyMonth;
	}

	public void setFoodSubsidyMonth(double foodSubsidyMonth) {
		this.foodSubsidyMonth = foodSubsidyMonth;
	}

	public int getAverageDaysOfTheMonth() {
		return averageDaysOfTheMonth;
	}

	public void setAverageDaysOfTheMonth(int averageDaysOfTheMonth) {
		this.averageDaysOfTheMonth = averageDaysOfTheMonth;
	}

	public double getLimitValueForFoodSubsidy() {
		return limitValueForFoodSubsidy;
	}

	public void setLimitValueForFoodSubsidy(double limitValueForFoodSubsidy) {
		this.limitValueForFoodSubsidy = limitValueForFoodSubsidy;
	}
	
	
	
}
