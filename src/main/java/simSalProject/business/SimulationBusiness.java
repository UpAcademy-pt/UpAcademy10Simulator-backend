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
	SimulationRepository simulationRepository;
	
	@Inject
	@Named("SimFieldsDataRep")
	SimFieldsDataRepository simFieldsDataRepository;
	
	
	public SimulationDTO createSimulation(Colaborator colaborator, List<SimFieldsData> myFieldsData) {
		Simulation mySimulation = new Simulation();
		mySimulation.setColaborator(colaborator);
		mySimulation.setSimFieldsData(myFieldsData);
		Simulation simulation = simulationRepository.createEntity(mySimulation);
		for (SimFieldsData fieldData : myFieldsData) {
			fieldData.setSimulation(simulation);
			simFieldsDataRepository.editEntity(fieldData);
		}
		SimulationDTO simulationDTO = simulationRepository.SimulationToSimulationDTO(simulationRepository.getSimulationById(simulation.getId()).get(0));
		simulationDTO.setSimFieldsData(simFieldsDataRepository.SimFieldsDataToSimFieldsDataDTO(myFieldsData));
		return simulationDTO;
	}
	
	public Simulation consultSimulation(long id) {
		List<Simulation> mySimulation = simulationRepository.getSimulationById(id);
		return mySimulation.get(0);
	}
	
	public void editSimulation(Simulation mySimulationToEdit) {
		simulationRepository.editEntity(mySimulationToEdit);
	}
	
	public void removeSimulation(Simulation mySimulation) {
		simulationRepository.removeEntity(mySimulation);
	}
	
	public List<Long> getAllIds() {
		return new ArrayList<Long>(simulationRepository.allIds());
	}
	
	public List<SimulationDTO> getAllValues(){
		List<SimulationDTO> simulationsDTO = new ArrayList<>();
		List<Simulation> simulations = simulationRepository.allValues();
		for (Simulation simulation : simulations) {
			simulationsDTO.add(simulationRepository.SimulationToSimulationDTO(simulation));
		}
		return simulationsDTO ;
	}
	
	public long getSimulationCountById(long id) {
		return simulationRepository.getSimulationCountById(id);
	}
	
	public List<Simulation> getSimulationById(long id){
		return simulationRepository.getSimulationById(id);
	}
	
	public List<SimulationDTO> getSimulationByColabId(Colaborator colaborator) {
		List<Simulation> simulations = simulationRepository.getSimulationsByColabId(colaborator);
		List<SimulationDTO> simulationsDTO = new ArrayList<SimulationDTO>();
		for (Simulation simulation : simulations) {
			simulationsDTO.add(simulationRepository.SimulationToSimulationDTO(simulation));
		}
		return simulationsDTO; 
	}
	
}
