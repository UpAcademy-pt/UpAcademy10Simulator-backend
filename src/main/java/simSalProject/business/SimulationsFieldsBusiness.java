package simSalProject.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.SimulationFields;
import simSalProject.repositories.SimulationsFieldsRepository;

@Named("SimFieldsBus")
@RequestScoped
public class SimulationsFieldsBusiness {

	@Inject
	@Named("SimFieldsRep")
	SimulationsFieldsRepository SIMF_DB;
	
	
	public String createSimulationField(SimulationFields mySimulationField) {
		if(SIMF_DB.allValues().contains(mySimulationField)) {
			return "This Simulation Field already exists";
		}
		return "Created";
	}
	
	public SimulationFields consultSimulationField(long id) {
		SimulationFields mySimulationField = SIMF_DB.getSimulationFieldsById(id);
		return mySimulationField;
	}
	
	public SimulationFields consultSimulationField(String name) {
		SimulationFields mySimulationField = SIMF_DB.getSimulationFieldsByName(name);
		return mySimulationField;
	}
	
	public void editSimulationField(SimulationFields mySimulationFieldToEdit) {
		SIMF_DB.editEntity(mySimulationFieldToEdit);
	}

	public void removeSimulationField(SimulationFields mySimulatonField) {
		SIMF_DB.removeEntity(mySimulatonField);
	}
	
	public List<Long> getAllIds(){
		return new ArrayList<Long>(SIMF_DB.allIds());
	}
	
	public Collection<SimulationFields> getAllValues(){
		return SIMF_DB.allValues();
	}
	
}
