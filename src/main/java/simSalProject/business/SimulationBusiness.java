package simSalProject.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.Colaborator;
import simSalProject.models.SimFieldsData;
import simSalProject.models.Simulation;
import simSalProject.models.SimulationDTO;
import simSalProject.repositories.SimFieldsDataRepository;
import simSalProject.repositories.SimulationRepository;

@Named("SimBus")
@RequestScoped
public class SimulationBusiness {

	
	@Inject
	@Named("SimRep")
	SimulationRepository SIM_DB;
	
	@Inject
	@Named("SimFieldsDataRep")
	SimFieldsDataRepository SIMFD_DB;
	
	
	public Simulation createSimulation(List<SimFieldsData> myFieldsData) {
		Simulation mySimulation = new Simulation();
		mySimulation.setSimFieldsData(myFieldsData);
		Simulation simulation = SIM_DB.createEntity(mySimulation);
		for (SimFieldsData fieldData : myFieldsData) {
			fieldData.setSimulation(simulation);
			SIMFD_DB.createEntity(fieldData);
		}
		return simulation;
	}
	
	public Simulation consultSimulation(long id) {
		List<Simulation> mySimulation = SIM_DB.getSimulationById(id);
		return mySimulation.get(0);
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
	
	public List<SimulationDTO> getAllValues(){
		List<SimulationDTO> simulationsDTO = new ArrayList<>();
		List<Simulation> simulations = SIM_DB.allValues();
		for (Simulation simulation : simulations) {
			simulationsDTO.add(SIM_DB.SimulationToSimulationDTO(simulation));
		}
		return simulationsDTO ;
	}
	
	public long getSimulationCountById(long id) {
		return SIM_DB.getSimulationCountById(id);
	}
	
	public List<Simulation> getSimulationById(long id){
		return SIM_DB.getSimulationById(id);
	}
	
	public List<SimulationDTO> getSimulationByColabId(Colaborator colaborator) {
		List<Simulation> simulations = SIM_DB.getSimulationsByColabId(colaborator);
		List<SimulationDTO> simulationsDTO = new ArrayList<SimulationDTO>();
		for (Simulation simulation : simulations) {
			simulationsDTO.add(SIM_DB.SimulationToSimulationDTO(simulation));
		}
		return simulationsDTO; 
	}
	
}
