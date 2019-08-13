package simSalProject.repositories;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import simSalProject.models.SimulationFields;

@Named("SimFieldsRep")
@RequestScoped
public class SimulationsFieldsRepository extends EntityRepository<SimulationFields> {

	public Class<SimulationFields> getEntityClass(){
		return SimulationFields.class;
	}

	@Override
	protected String getAllIds() {
		// TODO Auto-generated method stub
		return SimulationFields.ALL_SIM_FIELDS_IDS;
	}

	@Override
	protected String getAllValues() {
		// TODO Auto-generated method stub
		return SimulationFields.ALL_SIM_FIELDS_VALUES;
	}
	
	public SimulationFields getSimulationFieldsById(long id) {
		TypedQuery<SimulationFields> query = entityManager.createNamedQuery(SimulationFields.GET_SIM_FIELDS_BY_ID, SimulationFields.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
		
	}
	
	public List<SimulationFields> getSimulationFieldsByName(String name) {
		TypedQuery<SimulationFields> query = entityManager.createNamedQuery(SimulationFields.GET_SIM_FIELDS_BY_NAME, SimulationFields.class);
		query.setParameter("name", name);
		
		return query.getResultList();
	}
	
	public long getSimFieldsCount (String name){
		TypedQuery<Long> query = entityManager.createNamedQuery(SimulationFields.GET_SIM_FIELDS_COUNT_BY_NAME, long.class);
		query.setParameter("name", name);
		
		return query.getSingleResult();
	}
	
	
}
