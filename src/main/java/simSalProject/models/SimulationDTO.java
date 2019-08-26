package simSalProject.models;

import java.util.ArrayList;
import java.util.List;

public class SimulationDTO {

	private long id;
	private long date;
	private List<SimFieldsDataDTO> simFieldsData = new ArrayList<>();
	
	public SimulationDTO() {
		super();
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public List<SimFieldsDataDTO> getSimFieldsData() {
		return simFieldsData;
	}


	public void setSimFieldsData(List<SimFieldsDataDTO> simFieldsData) {
		this.simFieldsData = simFieldsData;
	}


	public long getDate() {
		return date;
	}


	public void setDate(long date) {
		this.date = date;
	}


	


	


	
	
	
	
	
}
