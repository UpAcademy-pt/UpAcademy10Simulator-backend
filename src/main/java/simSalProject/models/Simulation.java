package simSalProject.models;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import simSalProject.models.Entity_;

@Entity
@NamedQueries({
	@NamedQuery(name=Simulation.ALL_SIM_IDS, query="SELECT s.id FROM Simulation s"),
	@NamedQuery(name=Simulation.ALL_SIM_VALUES, query="SELECT s FROM Simulation s"),
	@NamedQuery(name=Simulation.GET_SIM_BY_ID, query="SELECT s FROM Simulation s WHERE s.id = :id"),
//	@NamedQuery(name=Simulation.GET_SIM_BY_NAME, query="SELECT s FROM Simulation s WHERE s.name = :name")
	
})
public class Simulation extends Entity_{

	private static final long serialVersionUID = 1L;
	public static final String ALL_SIM_IDS = "getAllSimIds";
	public static final String ALL_SIM_VALUES = "getAllSims";
	public static final String GET_SIM_BY_ID = "getSimByID";
	public static final String GET_SIM_BY_NAME = "getSimByName";
	
	
	
	private SimulationFields simFields;
	private SimFieldsData simFieldsData;

	public Simulation() {
		super();
	}
	


	public SimulationFields getSimFields() {
		return simFields;
	}




	public SimFieldsData getSimFieldsData() {
		return simFieldsData;
	}


	
	
	
	
	
	

	
	
	
	
}
