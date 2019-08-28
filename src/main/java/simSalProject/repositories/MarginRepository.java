package simSalProject.repositories;

import java.util.List;

import javax.persistence.TypedQuery;

import simSalProject.models.Margin;



public class MarginRepository extends EntityRepository<Margin>{
	
	
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
	
	
	public Class<Margin> getEntityClass() {
		return Margin.class;
	}
	
	public List<Margin> getMarginValues() {
		TypedQuery<Margin> query = entityManager.createNamedQuery(Margin.GET_ALL_MARGIN_VALUES, Margin.class);
		return query.getResultList();
	}
	
	public List<Margin> getMarginById(long id) {
		TypedQuery<Margin> query = entityManager.createNamedQuery(Margin.GET_MARGIN_BY_ID, Margin.class);
		query.setParameter("id", id);
		return query.getResultList();
	}


	
}
