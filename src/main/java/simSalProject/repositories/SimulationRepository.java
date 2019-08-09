package simSalProject.repositories;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import simSalProject.models.Simulation;

@Named("SimRep")
@RequestScoped
public class SimulationRepository extends EntityRepository<Simulation> {

	@Override
	protected String getAllIds() {
		// TODO Auto-generated method stub
		return Simulation.ALL_SIM_IDS;
	}

	@Override
	protected String getAllValues() {
		// TODO Auto-generated method stub
		return Simulation.ALL_SIM_VALUES;
	}

	public Simulation getSimulationById(long id){
		TypedQuery<Simulation> query = entityManager.createNamedQuery(Simulation.GET_SIM_BY_ID, Simulation.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}
	
	public Simulation getSimulationByName(String name){
		TypedQuery<Simulation> query = entityManager.createNamedQuery(Simulation.GET_SIM_BY_NAME, Simulation.class);
		query.setParameter("name", name);
		
		return query.getSingleResult();
		
	}
	
	@Override
	public Class<Simulation> getEntityClass(){
		return Simulation.class;
	}

	
	
	
}
