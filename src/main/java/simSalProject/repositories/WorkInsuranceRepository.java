package simSalProject.repositories;

import java.util.List;

import javax.persistence.TypedQuery;

import simSalProject.models.WorkInsurance;


public class WorkInsuranceRepository extends EntityRepository<WorkInsurance> {

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
	protected Class<WorkInsurance> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<WorkInsurance> getWorkInsuranceVariable() {
		TypedQuery<WorkInsurance> query = entityManager.createNamedQuery(WorkInsurance.GET_ALL_WORKINSURANCE_VALUES, WorkInsurance.class);
		return query.getResultList();
	}
	
	public List<WorkInsurance> getWorkInsuranceById(long id) {
		TypedQuery<WorkInsurance> query = entityManager.createNamedQuery(WorkInsurance.GET_WORK_INSURANCE_BY_ID, WorkInsurance.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

}
