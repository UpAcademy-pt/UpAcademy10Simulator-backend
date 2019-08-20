package simSalProject.models;

import java.util.ArrayList;
import java.util.List;

public class SimulationDTO {

	private long id;
	private List<SimFieldsData> simFieldsData = new ArrayList<>();
	
	public SimulationDTO() {
		super();
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public List<SimFieldsData> getSimFieldsData() {
		return simFieldsData;
	}

	public void setSimFieldsData(List<SimFieldsData> simFieldsData) {
		this.simFieldsData = simFieldsData;
	}
	
	
	
	
}
