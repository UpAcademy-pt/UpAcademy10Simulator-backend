package simSalProject.repositories;

import java.util.Collection;
import java.util.Iterator;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import simSalProject.models.IRSTable;

@Named("IRSTableRep")
@RequestScoped
public class IRSTableRepository extends EntityRepository<IRSTable> {
	
	public Class<IRSTable> getEntityClass(){
		return IRSTable.class;
	}

	@Override
	protected String getAllIds() {
		// TODO Auto-generated method stub
		return IRSTable.ALL_IRS_IDS;
	}

	@Override
	public String getAllValues() {
		// TODO Auto-generated method stub
		return IRSTable.ALL_IRS_VALUES;
	}
	

	public void setAllTable(Collection <IRSTable> table) {
		// EntityTransaction tx = entityManager.getTransaction();
		Iterator<IRSTable> iterator = table.iterator();
		while (iterator.hasNext()) {
		   // tx.begin();
		    entityManager.persist(iterator.next());
		   // tx.commit();
		}
	}
	
	public Collection<IRSTable> filteIRSTable(int depedents, String status) {
		if (depedents == 0) {
			TypedQuery<IRSTable> query = entityManager.createNamedQuery(IRSTable.FILTER_IRS_BY_ZERO, IRSTable.class);
			query.setParameter("n_titulares_rendimento", status);
			return query.getResultList();
		}
		if (depedents == 1) {
			TypedQuery<IRSTable> query = entityManager.createNamedQuery(IRSTable.FILTER_IRS_BY_ONE, IRSTable.class);
			query.setParameter("n_titulares_rendimento", status);
			return query.getResultList();
		}
		if (depedents == 2) {
			TypedQuery<IRSTable> query = entityManager.createNamedQuery(IRSTable.FILTER_IRS_BY_TWO, IRSTable.class);
			query.setParameter("n_titulares_rendimento", status);
			return query.getResultList();
		}
		if (depedents == 3) {
			TypedQuery<IRSTable> query = entityManager.createNamedQuery(IRSTable.FILTER_IRS_BY_THREE, IRSTable.class);
			query.setParameter("n_titulares_rendimento", status);
			return query.getResultList();
		}
		if (depedents == 4) {
			TypedQuery<IRSTable> query = entityManager.createNamedQuery(IRSTable.FILTER_IRS_BY_FOUR, IRSTable.class);
			query.setParameter("n_titulares_rendimento", status);
			return query.getResultList();
		}
		if (depedents == 5) {
			TypedQuery<IRSTable> query = entityManager.createNamedQuery(IRSTable.FILTER_IRS_BY_FIVE, IRSTable.class);
			query.setParameter("n_titulares_rendimento", status);
			return query.getResultList();
		}
		return null;
	}
	
	
	
}
