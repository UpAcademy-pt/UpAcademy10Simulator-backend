package simSalProject.business;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.HealthInsurance;
import simSalProject.repositories.HealthInsuranceRepository;

@Named("HealthInsBus")
@RequestScoped
public class HealthInsuranceBusiness {
	@Inject
	@Named("HealthInsRep")
	HealthInsuranceRepository HEALTHINS_DB;
	
	public HealthInsurance getHealthInsuranceValue () {
		return HEALTHINS_DB.getHealthInsuranceValue();
	}
	

	public void setHealthInsuranceValue(HealthInsurance newValue) {
		
		HEALTHINS_DB.setHealthInsuranceValue(newValue);
		
	}
}
