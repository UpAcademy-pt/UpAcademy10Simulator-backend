package simSalProject.repositories;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import simSalProject.models.HealthInsurance;

@Named("HealthInsRep")
@RequestScoped
public class HealthInsuranceRepository extends EntityRepository<HealthInsurance>{

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
	protected Class<HealthInsurance> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public HealthInsurance getHealthInsuranceValue() {
		TypedQuery<HealthInsurance> query = entityManager.createNamedQuery(HealthInsurance.GET_ALL_HEALTHINSURANCE_VALUE, HealthInsurance.class);
		return query.getSingleResult();
	}
	
	public void setHealthInsuranceValue(HealthInsurance newValue) {
		Query query = entityManager.createQuery("DELETE FROM HealthInsurance h");
		query.executeUpdate();
		entityManager.persist(newValue);
	}
}
