package simSalProject.models;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=Simulation.ALL_SIM_IDS, query="SELECT s.id FROM Simulation s"),
	@NamedQuery(name=Simulation.ALL_SIM_VALUES, query="SELECT s FROM Simulation s"),
	@NamedQuery(name=Simulation.GET_SIM_BY_ID, query="SELECT s FROM Simulation s WHERE s.id = :id"),
	@NamedQuery(name=Simulation.GET_SIM_BY_NAME, query="SELECT s FROM Simulation s WHERE s.name = :name")
	
})
public class Simulation extends Entity_{

	private static final long serialVersionUID = 1L;
	public static final String ALL_SIM_IDS = "getAllSimIds";
	public static final String ALL_SIM_VALUES = "getAllSims";
	public static final String GET_SIM_BY_ID = "getSimByID";
	public static final String GET_SIM_BY_NAME = "getSimByName";
	
	private long netSalary;
	private String name;

	public Simulation() {
		super();
	}
	
	
	public Simulation(long netSalary, String name) {
		super();
		this.netSalary = netSalary;
		this.name = name;
	}
	
	public long getSalary() {
		return netSalary;
	}

	public void setSalary(long netSalary) {
		this.netSalary = netSalary;
	}
	
	
	public String getName() {
		return name;
	}

	public void setNameField(String name) {
		this.name = name;
	}

	
	
	
	
}
