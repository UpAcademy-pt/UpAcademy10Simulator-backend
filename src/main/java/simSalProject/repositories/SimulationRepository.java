package simSalProject.repositories;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.TypedQuery;

import simSalProject.models.Colaborator;
import simSalProject.models.Simulation;
import simSalProject.models.SimulationDTO;


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

	public List<Simulation> getSimulationById(long id) {
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
	public Class<Simulation> getEntityClass() {
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

	public List<Simulation> getSimulationsByColab(Colaborator colaborator) {
		TypedQuery<Simulation> query = entityManager.createNamedQuery(Simulation.GET_SIM_BY_COLAB_ID, Simulation.class);
		query.setParameter("colaborator", colaborator);
		return query.getResultList();
	}

	public List<Simulation> getSimsByDate(LocalDateTime startDate, LocalDateTime endDate) {
		TypedQuery<Simulation> query = entityManager.createNamedQuery(Simulation.GET_SIMS_BY_DATE, Simulation.class);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		return query.getResultList();
	}

	public List<Simulation> getSimFromDate(LocalDateTime localDateTime) {
		TypedQuery<Simulation> query = entityManager.createNamedQuery(Simulation.GET_SIM_FROM_DATE, Simulation.class);
		query.setParameter("localDateTime", localDateTime);
		return query.getResultList();
	}

	public long getSimCount() {
		TypedQuery<Long> query = entityManager.createNamedQuery(Simulation.GET_SIM_COUNT, Long.class);
		return query.getSingleResult();
	}

	public long getCountSimByDate(LocalDateTime startDate, LocalDateTime endDate) {
		TypedQuery<Long> query = entityManager.createNamedQuery(Simulation.GET_COUNT_SIMS_BY_DATE, Long.class);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		return query.getSingleResult();
	}
	
	public long getSimCountByColabId(Colaborator colaborator) {
		TypedQuery<Long> query = entityManager.createNamedQuery(Simulation.GET_SIM_COUNT_BY_COLAB_ID, Long.class);
		query.setParameter("colaborator", colaborator);
		return query.getSingleResult();
		
		
	}
	
	
}
