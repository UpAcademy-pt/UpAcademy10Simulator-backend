package simSalProject.repositories;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import simSalProject.models.SimFieldsData;


@Named("SimFieldsDataRep")
@RequestScoped
public class SimFieldsDataRepository extends EntityRepository<SimFieldsData> {

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
	protected Class<SimFieldsData> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SimFieldsData> getSimFieldsDataByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getSimFieldsCount(String name) {
		TypedQuery<Long> query = entityManager.createNamedQuery(SimFieldsData.GET_SIM_FIELDS_DATA_COUNT_BY_NAME, long.class);
		query.setParameter("name", name);
		
		return query.getSingleResult();
	}
	
	public List<SimFieldsData> getSimulationFieldsByName(String name) {
		TypedQuery<SimFieldsData> query = entityManager.createNamedQuery(SimFieldsData.GET_SIM_FIELDS_DATA_BY_NAME, SimFieldsData.class);
		query.setParameter("name", name);
		
		return query.getResultList();
	}

}
