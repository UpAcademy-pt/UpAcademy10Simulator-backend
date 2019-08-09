package simSalProject.repositories;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import simSalProject.models.SimulationFields;

@Named("SimFieldsRep")
@RequestScoped
public class SimulationsFieldsRepository extends EntityRepository<SimulationFields> {

	public Class<SimulationFields> getEntityClass(){
		return SimulationFields.class;
	}

	@Override
	protected String getAllIds() {
		// TODO Auto-generated method stub
		return SimulationFields.ALL_SIM_FIELDS_IDS;
	}

	@Override
	protected String getAllValues() {
		// TODO Auto-generated method stub
		return SimulationFields.ALL_SIM_FIELDS_VALUES;
	}
	
	
}
