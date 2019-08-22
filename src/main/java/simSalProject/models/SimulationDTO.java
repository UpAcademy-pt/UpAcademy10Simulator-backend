package simSalProject.models;

import java.util.ArrayList;
import java.util.List;

public class SimulationDTO {

	private long id;
	private String date;
	private List<SimFieldsDataDTO> simFieldsDataDTO = new ArrayList<>();
	
	public SimulationDTO() {
		super();
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public List<SimFieldsDataDTO> getSimFieldsDataDTO() {
		return simFieldsDataDTO;
	}


	public void setSimFieldsDataDTO(List<SimFieldsDataDTO> simFieldsDataDTO) {
		this.simFieldsDataDTO = simFieldsDataDTO;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	


	
	
	
	
	
}
