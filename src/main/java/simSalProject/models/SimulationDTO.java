package simSalProject.models;

import java.util.ArrayList;
import java.util.List;

public class SimulationDTO {

	private long id;
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
	
	public List<SimFieldsDataDTO> getSimFieldsData() {
		return simFieldsDataDTO;
	}

	public void setSimFieldsData(List<SimFieldsDataDTO> simFieldsDataDTO) {
		this.simFieldsDataDTO = simFieldsDataDTO;
	}
	
	
	
	
}
