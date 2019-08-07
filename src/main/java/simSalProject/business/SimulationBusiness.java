package simSalProject.business;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.repositories.SimulationRepository;

@Named("SimBus")
@RequestScoped
public class SimulationBusiness {

	
	@Inject
	@Named("SimRep")
	SimulationRepository SIM_DB;
	
}
