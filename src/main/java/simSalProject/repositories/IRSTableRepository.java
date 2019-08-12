package simSalProject.repositories;

import java.util.Collection;
import java.util.Iterator;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityTransaction;

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
	protected String getAllValues() {
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
	
	
	
}
