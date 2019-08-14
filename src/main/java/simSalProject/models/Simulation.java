package simSalProject.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "Simulation")
@Table(name="simulation")
@NamedQueries({
	@NamedQuery(name=Simulation.ALL_SIM_IDS, query="SELECT s.id FROM Simulation s"),
	@NamedQuery(name=Simulation.ALL_SIM_VALUES, query="SELECT s FROM Simulation s"),
	@NamedQuery(name=Simulation.GET_SIM_BY_ID, query="SELECT s FROM Simulation s WHERE s.id = :id"),
//	@NamedQuery(name=Simulation.GET_SIM_BY_NAME, query="SELECT s FROM Simulation s WHERE s.name = :name")
	@NamedQuery(name=Simulation.GET_SIM_COUNT_BY_ID, query="SELECT count(s) FROM Simulation s WHERE s.id = :id")
	
})
public class Simulation extends Entity_{

	private static final long serialVersionUID = 1L;
	public static final String ALL_SIM_IDS = "getAllSimIds";
	public static final String ALL_SIM_VALUES = "getAllSims";
	public static final String GET_SIM_BY_ID = "getSimByID";
	public static final String GET_SIM_BY_NAME = "getSimByName";
	public static final String GET_SIM_COUNT_BY_ID = "getSimCountById";
	
	
	@ManyToMany(cascade = {
	        CascadeType.PERSIST,
	        CascadeType.MERGE
	    })
	@JoinTable(name = "simulation_simulationfields",
    joinColumns = @JoinColumn(name = "simulation_id"),
    inverseJoinColumns = @JoinColumn(name = "simulationfields_id")
)
	private List<SimulationFields> simFields = new ArrayList<>();
	@ManyToMany(cascade = {
	        CascadeType.PERSIST,
	        CascadeType.MERGE
	    })
	@JoinTable(name = "simulation_simulationfieldsdata",
    joinColumns = @JoinColumn(name = "simulation_id"),
    inverseJoinColumns = @JoinColumn(name = "simulationfieldsdata_id")
)
	private List<SimFieldsData> simFieldsData = new ArrayList<>();

	public Simulation() {
		super();
	}

	


	
	
	
}
