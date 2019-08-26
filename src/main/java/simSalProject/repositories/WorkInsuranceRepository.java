package simSalProject.repositories;

import javax.persistence.Query;
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
	
	
	public WorkInsurance getWorkInsuranceVariable() {
		TypedQuery<WorkInsurance> query = entityManager.createNamedQuery(WorkInsurance.GET_ALL_WORKINSURANCE_VALUES, WorkInsurance.class);
		return query.getSingleResult();
	}
	
	public void setWorkInsuranceVariable(WorkInsurance newValue) {
		Query query = entityManager.createQuery("DELETE FROM WorkInsurance w");
		query.executeUpdate();
		entityManager.merge(newValue);
	}

}
