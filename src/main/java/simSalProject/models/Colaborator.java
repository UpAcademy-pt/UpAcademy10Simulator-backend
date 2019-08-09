package simSalProject.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=Colaborator.ALL_COLABORATOR_IDS, query="SELECT c.id FROM Colaborator c"),
	@NamedQuery(name=Colaborator.ALL_COLABORATOR_VALUES, query="SELECT c FROM Colaborator c")
	
})
public class Colaborator extends Entity_{
	private static final long serialVersionUID = 1L;
	public static final String ALL_COLABORATOR_IDS = "getAllColabIds";
	public static final String ALL_COLABORATOR_VALUES = "getAllColabs";
	private String name;
	private String status;
	private int dependents;
	
//	private List<Simulation> simulations = new ArrayList();
	
	public Colaborator() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDependents() {
		return dependents;
	}

	public void setDependents(int dependents) {
		this.dependents = dependents;
	}

//	public List<Simulation> getSimulations() {
//		return simulations;
//	}
	
	
	
	
	
	
	

}
