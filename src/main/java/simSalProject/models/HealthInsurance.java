package simSalProject.models;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=HealthInsurance.GET_ALL_HEALTHINSURANCE_VALUE, query="SELECT h FROM HealthInsurance h")
})
public class HealthInsurance extends Entity_{
	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL_HEALTHINSURANCE_VALUE = "getHealthInsurace";

	public HealthInsurance() {}
	
	private double healthInsuranceMonth = 160.23;

	public double getHealthInsuranceMonth() {
		return healthInsuranceMonth;
	}

	public void setHealthInsuranceMonth(double healthInsuranceMonth) {
		this.healthInsuranceMonth = healthInsuranceMonth;
	}
	
	
}
