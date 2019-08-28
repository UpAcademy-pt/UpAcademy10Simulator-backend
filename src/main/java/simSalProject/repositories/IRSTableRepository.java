package simSalProject.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import simSalProject.models.IRSTable;


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
		Iterator<IRSTable> iterator = table.iterator();
		while (iterator.hasNext()) {
		    entityManager.persist(iterator.next());
		}
	}
	
	public List<Object[]> filteIRSTable(int depedents, String status) {
		if (depedents == 0) {
			List<Object[]> results = new ArrayList();
			List<Object[]> result = entityManager.createQuery("SELECT a.id, a.remuneracao_mensal, a.zero FROM IRSTable a WHERE a.n_titulares_rendimento = :n_titulares_rendimento").setParameter("n_titulares_rendimento", status).getResultList();
			for( Object[] a : result) {
				results.add(a);
			}
			return results;
		}
		if (depedents == 1) {
			List<Object[]> results = new ArrayList();
			List<Object[]> result = entityManager.createQuery("SELECT a.id, a.remuneracao_mensal, a.um FROM IRSTable a WHERE a.n_titulares_rendimento = :n_titulares_rendimento").setParameter("n_titulares_rendimento", status).getResultList();
			for( Object[] a : result) {
				results.add(a);
			}
			return results;
		}
		if (depedents == 2) {
			List<Object[]> results = new ArrayList();
			List<Object[]> result = entityManager.createQuery("SELECT a.id, a.remuneracao_mensal, a.dois FROM IRSTable a WHERE a.n_titulares_rendimento = :n_titulares_rendimento").setParameter("n_titulares_rendimento", status).getResultList();
			for( Object[] a : result) {
				results.add(a);
			}
			return results;
		}
		if (depedents == 3) {
			List<Object[]> results = new ArrayList();
			List<Object[]> result = entityManager.createQuery("SELECT a.id, a.remuneracao_mensal, a.tres FROM IRSTable a WHERE a.n_titulares_rendimento = :n_titulares_rendimento").setParameter("n_titulares_rendimento", status).getResultList();
			for( Object[] a : result) {
				results.add(a);
			}
			return results;
		}
		if (depedents == 4) {
			List<Object[]> results = new ArrayList();
			List<Object[]> result = entityManager.createQuery("SELECT a.id, a.remuneracao_mensal, a.quatro FROM IRSTable a WHERE a.n_titulares_rendimento = :n_titulares_rendimento").setParameter("n_titulares_rendimento", status).getResultList();
			for( Object[] a : result) {
				results.add(a);
			}
			return results;
		}
		if (depedents == 5) {
			List<Object[]> results = new ArrayList();
			List<Object[]> result = entityManager.createQuery("SELECT a.id, a.remuneracao_mensal, a.cinco FROM IRSTable a WHERE a.n_titulares_rendimento = :n_titulares_rendimento").setParameter("n_titulares_rendimento", status).getResultList();
			for( Object[] a : result) {
				results.add(a);
			}
			return results;
		}
		return null;
	}

	public void deleteAll() {
		Query query = entityManager.createQuery("DELETE FROM IRSTable a");
		int rowsDeleted = query.executeUpdate();
		
	}	
	
	public boolean existSomethingInIRSTable() {
		TypedQuery<Long> query = entityManager.createNamedQuery(IRSTable.VERIFY_IF_SOMETHING_EXISTS_IN_IRS_TABLE, Long.class);
		 if (query.getResultList().get(0) == 0) {
			 return false;
		 } else {
			 return true;
		 }
	}
}
