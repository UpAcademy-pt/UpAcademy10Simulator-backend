package simSalProject.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=Simulation.ALL_SIM_IDS, query="SELECT s.id FROM Simulation s"),
	@NamedQuery(name=Simulation.ALL_SIM_VALUES, query="SELECT s FROM Simulation s")
	
})
public class Simulation extends Entity_{

	private static final long serialVersionUID = 1L;
	public static final String ALL_SIM_IDS = "getAllSimIds";
	public static final String ALL_SIM_VALUES = "getAllSims";
//	private List<SimFieldsData> simFieldsData;
	
	
	
	
	
	public Simulation() {
		super();
	}
	
	
	
	
	
}
