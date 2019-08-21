package simSalProject.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.SimFieldsData;
import simSalProject.models.SimFieldsDataDTO;
import simSalProject.repositories.SimFieldsDataRepository;
import simSalProject.repositories.SimulationsFieldsRepository;

@Named("SimFieldsDataBus")
@RequestScoped
public class SimFieldsDataBusiness {

	@Inject
	@Named("SimFieldsDataRep")
	SimFieldsDataRepository SIMFD_DB;
	
	@Inject
	@Named("SimFieldsRep") 
	SimulationsFieldsRepository SIMF_DB;

	public String createSimFieldsData(SimFieldsData mySimFieldsData) {
		SIMFD_DB.createEntity(mySimFieldsData);
		return "Created";
	}

	public String editSimFieldsData(SimFieldsData mySimFieldsDataToEdit) {
		SIMFD_DB.editEntity(mySimFieldsDataToEdit);
		return "Edited";
	}

	public String removeSimFieldsData(SimFieldsData mySimFieldsData) {
		SIMFD_DB.removeEntity(mySimFieldsData);
		return "Removed";
	}

	public List<SimFieldsData> consultSimFieldsData(long id) {
		List<SimFieldsData> mySimulationField = SIMFD_DB.getSimFieldsDataById(id);
		return mySimulationField;
	}

	public List<Long> getAllIds() {
		return new ArrayList<Long>(SIMFD_DB.allIds());
	}

	public List<SimFieldsDataDTO> getAllValues() {
		List<SimFieldsDataDTO> fieldsDataDTO = new ArrayList<SimFieldsDataDTO>();
		List<SimFieldsData> fieldsData = SIMFD_DB.allValues();
		for (SimFieldsData fieldData : fieldsData) {
			fieldsDataDTO.add(SIMFD_DB.SimFieldsDataToSimFieldsDataDTO(fieldData));
		}
		return fieldsDataDTO;

	}

	public List<SimFieldsData> getSimFieldsDataById(long id) {
		// TODO Auto-generated method stub
		return SIMFD_DB.getSimFieldsDataById(id);
	}

	public long getSimFieldsDataCountById(long id) {
		return SIMFD_DB.getSimFieldsDataCountById(id);
	}
	
	public List<SimFieldsDataDTO> SimFieldsDataToSimFieldsDataDTO(List<SimFieldsData> fieldsData){
		List<SimFieldsDataDTO> fieldsDataDTO = new ArrayList<SimFieldsDataDTO>();
		for (SimFieldsData fieldData : fieldsData) {
			fieldsDataDTO.add(SIMFD_DB.SimFieldsDataToSimFieldsDataDTO(fieldData));
		}
		return fieldsDataDTO;
	}

}
