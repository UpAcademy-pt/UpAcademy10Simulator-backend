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

	public FoodSubsidy() {}
	
	private double foodSubsidyMonth;

	public double getFoodSubsidyMonth() {
		return foodSubsidyMonth;
	}

	public void setFoodSubsidyMonth(double foodSubsidyMonth) {
		this.foodSubsidyMonth = foodSubsidyMonth;
	}
	
	
}
