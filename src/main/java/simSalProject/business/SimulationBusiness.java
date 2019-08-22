package simSalProject.business;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.Colaborator;
import simSalProject.models.SimFieldsData;
import simSalProject.models.SimFieldsDataDTO;
import simSalProject.models.Simulation;
import simSalProject.models.SimulationDTO;
import simSalProject.repositories.SimulationRepository;

@Named("SimBus")
@RequestScoped
public class SimulationBusiness {

	
	@Inject
	@Named("SimRep")
	SimulationRepository simulationRepository;
	
	@Inject
	@Named("SimFieldsDataBus")
	SimFieldsDataBusiness simFieldsDataBusiness;
	
	
	public SimulationDTO createSimulation(Colaborator colaborator, List<SimFieldsData> myFieldsData) {
		Simulation mySimulation = new Simulation();
		mySimulation.setColaborator(colaborator);
		mySimulation.setLocalDateTime(LocalDateTime.now());
		mySimulation.setSimFieldsData(myFieldsData);
		Simulation simulation = simulationRepository.createEntity(mySimulation);
		for (SimFieldsData fieldData : myFieldsData) {
			fieldData.setSimulation(simulation);
			simFieldsDataBusiness.editSimFieldsData(fieldData);
		}
		return SimulationToSimulationDTO(simulation);
	}
	
	public Simulation consultSimulation(long id) {
		List<Simulation> mySimulation = simulationRepository.getSimulationById(id);
		return mySimulation.get(0);
	}
	
	public void editSimulation(Simulation mySimulationToEdit) {
		simulationRepository.editEntity(mySimulationToEdit);
	}
	
	public void removeSimulation(Simulation mySimulation) {
		mySimulation.setColaborator(null);
		simulationRepository.editEntity(mySimulation);
		simulationRepository.removeEntity(mySimulation);
	}
	
	public List<Long> getAllIds() {
		return new ArrayList<Long>(simulationRepository.allIds());
	}
	
	public List<SimulationDTO> getAllValues(){
		List<Simulation> simulations = simulationRepository.allValues();
		return SimulationToSimulationDTO(simulations); 
	}
	
	public long getSimulationCountById(long id) {
		return simulationRepository.getSimulationCountById(id);
	}
	
	public List<Simulation> getSimulationById(long id){
		return simulationRepository.getSimulationById(id);
	}
	
	public List<SimulationDTO> getSimulationByColab(Colaborator colaborator) {
		List<Simulation> simulations = simulationRepository.getSimulationsByColab(colaborator);
		return SimulationToSimulationDTO(simulations); 
	}
	
	
	public List<SimulationDTO> SimulationToSimulationDTO(List<Simulation> simulations){
		List<SimulationDTO> simulationsDTO = new ArrayList<SimulationDTO>();
		for (Simulation simulation : simulations) {
			simulationsDTO.add(SimulationToSimulationDTO(simulation));
		}
		return simulationsDTO;
	}
	
	//Simulation to DTO - Transforms simulation into DTO and calls method to transform Array of fieldsData to fieldsDataDTO
	public SimulationDTO SimulationToSimulationDTO(Simulation mySimulation) {
		SimulationDTO mySimulationDTO = simulationRepository.SimulationToSimulationDTO(mySimulation);
		mySimulationDTO.setId(mySimulation.getId());
		mySimulationDTO.setDate(mySimulation.getLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		List<SimFieldsData> fieldsData = mySimulation.getSimFieldsData();
		List<SimFieldsDataDTO> fieldsDataDTO = new ArrayList<SimFieldsDataDTO>();
		for (SimFieldsData fieldData : fieldsData) {
			fieldsDataDTO.add(simFieldsDataBusiness.SimFieldsDataToSimFieldsDataDTO(fieldData));
		}
		mySimulationDTO.setSimFieldsDataDTO(fieldsDataDTO);
		return mySimulationDTO;
	}
	

	public Simulation SimulationDTOToSimulation(SimulationDTO mySimulationDTO) {
		Simulation mySimulation = getSimulationById(mySimulationDTO.getId()).get(0);
		return mySimulation;
	}
	
	
}
