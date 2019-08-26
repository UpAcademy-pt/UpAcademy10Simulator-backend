package simSalProject.business;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import simSalProject.models.Colaborator;
import simSalProject.models.SimFieldsData;
import simSalProject.models.SimFieldsDataDTO;
import simSalProject.models.Simulation;
import simSalProject.models.SimulationDTO;
import simSalProject.repositories.SimulationRepository;


public class SimulationBusiness {

	
	@Inject
	SimulationRepository simulationRepository;
	
	@Inject
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
		mySimulationDTO.setDate(mySimulation.getLocalDateTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
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
	
	public List<SimulationDTO> getSimsByDate (long firstDate, long lastDate) {
		LocalDateTime startDate = Instant.ofEpochMilli(firstDate).atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime endDate = Instant.ofEpochMilli(lastDate).atZone(ZoneId.systemDefault()).toLocalDateTime();
		List<SimulationDTO> simsDTO = SimulationToSimulationDTO(simulationRepository.getSimsByDate(startDate, endDate));
		return simsDTO;
	}
	
	public List<SimulationDTO> getSimFromDate (long milliDate) {
		LocalDateTime localDateTime = Instant.ofEpochMilli(milliDate).atZone(ZoneId.systemDefault()).toLocalDateTime();
		List<SimulationDTO> simsDTO = SimulationToSimulationDTO(simulationRepository.getSimFromDate(localDateTime));
		return simsDTO;
	}
	
	public long getSimCount () {
		return simulationRepository.getSimCount();
	}
	
	public long getCountSimByDate(long firstDate, long lastDate) {
		LocalDateTime startDate = Instant.ofEpochMilli(firstDate).atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime endDate = Instant.ofEpochMilli(lastDate).atZone(ZoneId.systemDefault()).toLocalDateTime();
		return simulationRepository.getCountSimByDate(startDate, endDate);
	}
	
	public long getSimCountByColabId(Colaborator colaborator) {
		return simulationRepository.getSimCountByColabId(colaborator);
	}
	
	
}
