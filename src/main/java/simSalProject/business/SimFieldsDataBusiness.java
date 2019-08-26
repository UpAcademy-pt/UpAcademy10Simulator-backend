package simSalProject.business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import simSalProject.models.SimFieldsData;
import simSalProject.models.SimFieldsDataDTO;
import simSalProject.repositories.SimFieldsDataRepository;
import simSalProject.repositories.SimulationsFieldsRepository;


public class SimFieldsDataBusiness {

	@Inject
	SimFieldsDataRepository simFieldsDataRepository;
	
	@Inject
	SimulationsFieldsRepository simFieldsRepository;

	public String createSimFieldsData(SimFieldsData mySimFieldsData) {
		simFieldsDataRepository.createEntity(mySimFieldsData);
		return "Created";
	}

	public String editSimFieldsData(SimFieldsData mySimFieldsDataToEdit) {
		simFieldsDataRepository.editEntity(mySimFieldsDataToEdit);
		return "Edited";
	}

	public String removeSimFieldsData(SimFieldsData mySimFieldsData) {
		mySimFieldsData.setSimulation(null);
		editSimFieldsData(mySimFieldsData);
		simFieldsDataRepository.removeEntity(mySimFieldsData);
		return "Removed";
	}

	public List<SimFieldsDataDTO> consultSimFieldsData(long id) { 
		return SimFieldsDataToSimFieldsDataDTO(simFieldsDataRepository.getSimFieldsDataById(id));
	}

	public List<SimFieldsDataDTO> getAllValues() {
		List<SimFieldsDataDTO> fieldsDataDTO = new ArrayList<SimFieldsDataDTO>();
		List<SimFieldsData> fieldsData = simFieldsDataRepository.allValues();
		SimFieldsDataToSimFieldsDataDTO(fieldsData);
		return fieldsDataDTO;

	}

	public List<SimFieldsData> getSimFieldsDataById(long id) {
		// TODO Auto-generated method stub
		return simFieldsDataRepository.getSimFieldsDataById(id);
	}

	public long getSimFieldsDataCountById(long id) {
		return simFieldsDataRepository.getSimFieldsDataCountById(id);
	}
	
	public List<SimFieldsDataDTO> SimFieldsDataToSimFieldsDataDTO(List<SimFieldsData> fieldsData){
		List<SimFieldsDataDTO> fieldsDataDTO = new ArrayList<SimFieldsDataDTO>();
		for (SimFieldsData fieldData : fieldsData) {
			fieldsDataDTO.add(SimFieldsDataToSimFieldsDataDTO(fieldData));
		}
		return fieldsDataDTO;
	}
	
	public SimFieldsDataDTO SimFieldsDataToSimFieldsDataDTO(SimFieldsData mySimFieldsData) {
		SimFieldsDataDTO mySimFieldsDataDTO = simFieldsDataRepository.SimFieldsDataToSimFieldsDataDTO(mySimFieldsData);
		mySimFieldsDataDTO.setName(mySimFieldsData.getName());
		mySimFieldsDataDTO.setValue(mySimFieldsData.getValue());
		return mySimFieldsDataDTO;
	}
	
	
	public SimFieldsData SimFieldsDataDTOToSimFieldsData(SimFieldsDataDTO mySimFieldsDataDTO) {
		SimFieldsData mySimFieldsData = getSimFieldsDataById(mySimFieldsDataDTO.getId()).get(0);
		return mySimFieldsData;
	}

}
