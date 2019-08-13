package simSalProject.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=Colaborator.ALL_COLABORATOR_IDS, query="SELECT c.id FROM Colaborator c"),
	@NamedQuery(name=Colaborator.ALL_COLABORATOR_VALUES, query="SELECT c FROM Colaborator c"),
	@NamedQuery(name=Colaborator.GET_COLABORATOR_BY_ID, query="SELECT c FROM Colaborator c WHERE c.id = :id"),
	@NamedQuery(name=Colaborator.GET_COLABORATOR_BY_NAME , query="SELECT c FROM Colaborator C WHERE c.name = :name")
	
})
public class Colaborator extends Entity_{
	private static final long serialVersionUID = 1L;
	public static final String ALL_COLABORATOR_IDS = "getAllColabIds";
	public static final String ALL_COLABORATOR_VALUES = "getAllColabs";
	public static final String GET_COLABORATOR_BY_ID = "getColabById";
	public static final String GET_COLABORATOR_BY_NAME = "getColabByName";
	private String name;
	private String status;
	private String dependents;
//	@ManyToOne
//	private Simulation simulation;
	
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

	public String getDependents() {
		return dependents;
	}

	public void setDependents(String dependents) {
		this.dependents = dependents;
	}

	
	
	
	

}
