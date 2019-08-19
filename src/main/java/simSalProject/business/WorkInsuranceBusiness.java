package simSalProject.business;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.WorkInsurance;
import simSalProject.repositories.WorkInsuranceRepository;

@Named("WorkInsuranceBus")
@RequestScoped
public class WorkInsuranceBusiness {

	@Inject
	@Named("WorkInsuranceRep")
	WorkInsuranceRepository WORKINS_DB;
	
	public WorkInsurance getWorkInsuranceVariable() {
		return WORKINS_DB.getWorkInsuranceVariable();
	}
	
	public void setWorkInsuranceVariable(WorkInsurance newValue) {
		
		WORKINS_DB.setWorkInsuranceVariable(newValue);
		
	}
}
