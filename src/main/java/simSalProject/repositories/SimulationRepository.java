package simSalProject.repositories;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

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

	@Override
	public Class<Simulation> getEntityClass(){
		return Simulation.class;
	}

	
	
	
}
