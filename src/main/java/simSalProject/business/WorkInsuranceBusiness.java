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
	WorkInsuranceRepository workInsuranceRepository;
	
	public WorkInsurance getWorkInsuranceVariable() {
		return workInsuranceRepository.getWorkInsuranceVariable();
	}
	
	public void setWorkInsuranceVariable(WorkInsurance newValue) {
		
		workInsuranceRepository.setWorkInsuranceVariable(newValue);
		
	}
}
