package simSalProject.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.Simulation;
import simSalProject.repositories.SimulationRepository;

@Named("SimBus")
@RequestScoped
public class SimulationBusiness {

	
	@Inject
	@Named("SimRep")
	SimulationRepository SIM_DB;
	
	public String createSimulation(Simulation mySimulation) {
		if(SIM_DB.allValues().contains(mySimulation)) {
			return "This Simulation already exists";
		}
		return "Created";
	}
	
	public Simulation consultSimulation(long id) {
		Simulation mySimulation = SIM_DB.getSimulationById(id);
		return mySimulation;
	}
	
	public Simulation consultSimulation(String name) {
		Simulation mySimulation = SIM_DB.getSimulationByName(name);
		return mySimulation;
	}
	
	public void editSimulation(Simulation mySimulationToEdit) {
		SIM_DB.editEntity(mySimulationToEdit);
	}
	
	public void removeSimulation(Simulation mySimulation) {
		SIM_DB.removeEntity(mySimulation);
	}
	
	public List<Long> getAllIds() {
		return new ArrayList<Long>(SIM_DB.allIds());
	}
	
	public Collection<Simulation> getAllValues(){
		return SIM_DB.allValues();
	}
	
}
