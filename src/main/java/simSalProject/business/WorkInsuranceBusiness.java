package simSalProject.business;

import javax.inject.Inject;
import javax.transaction.Transactional;

import simSalProject.models.WorkInsurance;
import simSalProject.repositories.WorkInsuranceRepository;


public class WorkInsuranceBusiness {

	@Inject
	WorkInsuranceRepository workInsuranceRepository;
	
	
	public WorkInsurance getWorkInsuranceVariable() {
		return workInsuranceRepository.getWorkInsuranceVariable().get(0);
	}
	
	@Transactional
	public WorkInsurance createWorkInsuranceVariable(WorkInsurance newValue) {
		return workInsuranceRepository.createEntity(newValue);
	}
	
	@Transactional
	public String editWorkInsuranceVariable(long id, WorkInsurance newValue) {
		if(workInsuranceRepository.getWorkInsuranceById(id).size() > 0) {
			newValue.setId(id);
			workInsuranceRepository.editEntity(newValue);
			return "Edited";
		} else {
			return "Not Edited";
		}
	}
}
