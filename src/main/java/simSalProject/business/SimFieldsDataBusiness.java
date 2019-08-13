package simSalProject.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.SimFieldsData;
import simSalProject.repositories.SimFieldsDataRepository;
import simSalProject.repositories.SimulationsFieldsRepository;

@Named("SimFieldsDataBus")
@RequestScoped
public class SimFieldsDataBusiness {

	@Inject
	@Named("SimFieldsDataRep")
	SimFieldsDataRepository SIMFD_DB;
	
	@Inject
	@Named("SimFieldsDataRep") 
	SimulationsFieldsRepository SIMF_DB;

	public String createSimFieldsData(SimFieldsData mySimFieldsData) {
		SIMFD_DB.createEntity(mySimFieldsData);
		return "Created";
	}

	public String editSimFieldsData(SimFieldsData mySimFieldsDataToEdit) {
		SIMFD_DB.editEntity(mySimFieldsDataToEdit);
		return "Edited";
	}

	public void removeSimFieldsData(SimFieldsData mySimFieldsData) {
		SIMFD_DB.removeEntity(mySimFieldsData);

	}

	public List<SimFieldsData> consultSimFieldsData(String name) {
		List<SimFieldsData> mySimulationField = SIMFD_DB.getSimFieldsDataByName(name);
		return mySimulationField;
	}

	public List<Long> getAllIds() {
		return new ArrayList<Long>(SIMFD_DB.allIds());
	}

	public Collection<SimFieldsData> getAllValues() {
		return SIMFD_DB.allValues();
	}

	public List<SimFieldsData> getSimFieldsDataByName(String name) {
		// TODO Auto-generated method stub
		return SIMFD_DB.getSimFieldsDataByName(name);
	}

	public long getSimFieldsCount(String name) {

		return SIMFD_DB.getSimFieldsCount(name);
	}

}
