package simSalProject.business;

import javax.inject.Inject;
import javax.transaction.Transactional;

import simSalProject.models.WorkInsurance;
import simSalProject.repositories.WorkInsuranceRepository;


public class WorkInsuranceBusiness {

	@Inject
	WorkInsuranceRepository workInsuranceRepository;
	
	
	public WorkInsurance getWorkInsuranceVariable() {
		return workInsuranceRepository.getWorkInsuranceVariable();
	}
	
	@Transactional
	public void setWorkInsuranceVariable(WorkInsurance newValue) {
		workInsuranceRepository.setWorkInsuranceVariable(newValue);
		
	}
}
