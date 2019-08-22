package simSalProject.models;

import java.util.ArrayList;
import java.util.List;

public class ColaboratorDTO {
	
	private long id;
	private String name;
	private String status;
	private String dependents;
	
	private List<SimulationDTO> simulations = new ArrayList<SimulationDTO>();
	
	
	public ColaboratorDTO() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public List<SimulationDTO> getSimulations() {
		return simulations;
	}
	public void setSimulations(List<SimulationDTO> simulations) {
		this.simulations = simulations;
	}
	
	
	
}
