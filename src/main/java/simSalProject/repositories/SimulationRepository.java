package simSalProject.repositories;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import simSalProject.models.Colaborator;
import simSalProject.models.Simulation;
import simSalProject.models.SimulationDTO;

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

	public List<Simulation> getSimulationById(long id){
		TypedQuery<Simulation> query = entityManager.createNamedQuery(Simulation.GET_SIM_BY_ID, Simulation.class);
		query.setParameter("id", id);
		
		return query.getResultList();
	}
	
	
	public long getSimulationCountById(long id) {
		TypedQuery<Long> query = entityManager.createNamedQuery(Simulation.GET_SIM_COUNT_BY_ID, Long.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	@Override
	public Class<Simulation> getEntityClass(){
		return Simulation.class;
	}
	
	
	
	public SimulationDTO SimulationToSimulationDTO(Simulation mySimulation) {
		SimulationDTO mySimulationDTO = new SimulationDTO();
		mySimulationDTO.setId(mySimulation.getId());
		return mySimulationDTO;
	}

	public Simulation SimulationDTOToSimulation(SimulationDTO mySimulationDTO) {
		Simulation mySimulation = getSimulationById(mySimulationDTO.getId()).get(0);
		return mySimulation;
	}
	
	
	public List<Simulation> getSimulationsByColab(Colaborator colaborator){
		TypedQuery<Simulation> query = entityManager.createNamedQuery(Simulation.GET_SIM_BY_COLAB_ID, Simulation.class);
		query.setParameter("colaborator", colaborator);
		return query.getResultList();
	}
		
		
		
	

	
	
	
}
