package simSalProject.repositories;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import simSalProject.models.Tax;


@Named("TaxRep")
@RequestScoped
public class TaxRepository extends EntityRepository<Tax> {

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
	protected Class<Tax> getEntityClass() {
		// TODO Auto-generated method stub
		return Tax.class;
	}
	
	public List<Tax> getTaxByName (String name){
		TypedQuery<Tax> query = entityManager.createNamedQuery(Tax.GET_TAX_BY_NAME, Tax.class);
		query.setParameter("name", name);
		
		return query.getResultList();
	}
	
	public long getTaxCountByName(String name) {
		TypedQuery<Long> query = entityManager.createNamedQuery(Tax.GET_TAX_COUNT_BY_NAME, Long.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}
	
	public List<Tax> getAllTaxes() {
		TypedQuery<Tax> query = entityManager.createNamedQuery(Tax.GET_ALL_TAXES, Tax.class);
		return query.getResultList();
	}

}
