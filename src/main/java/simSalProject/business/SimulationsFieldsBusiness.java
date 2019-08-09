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
	
public String createSimulationFields(SimulationFields mySimulationFields) {
		
		SIMF_DB.createEntity(mySimulationFields);
		return "Created";
		
	}
	
	public SimulationFields consultSimulationFields(long id) {
		SimulationFields mySimulationFields = SIMF_DB.consultEntity(id);
		return mySimulationFields;
	}
	
	public void editSimulationFields(long id, SimulationFields mySimulationFieldsToEdit) {
		
			SIMF_DB.editEntity(mySimulationFieldsToEdit);
		
	}
	
	public void removeSimulationFields(SimulationFields mySimulationFields) {
		
			SIMF_DB.removeEntity(mySimulationFields);
		
	}
	
	public List<Long> getAllIds() {
		return new ArrayList<Long>(SIMF_DB.allIds());
	}
	
	public Collection<SimulationFields> getAllValues() {
		return SIMF_DB.allValues();
	}
	
}