package simSalProject.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "SimulationFieldsData")
@Table(name="simulationfieldsdata")
@NamedQueries({
	@NamedQuery(name=SimFieldsData.GET_SIM_FIELDS_DATA_BY_NAME, query="SELECT sfd FROM SimulationFieldsData sfd WHERE sfd.name = :name"),
	@NamedQuery(name=SimFieldsData.GET_SIM_FIELDS_DATA_COUNT_BY_NAME, query="SELECT count(sfd) FROM SimulationFieldsData sfd WHERE sfd.name = :name"),
	
})
public class SimFieldsData extends Entity_ {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String GET_SIM_FIELDS_DATA_COUNT_BY_NAME = "getSimFieldsDataCountByName";
	public static final String GET_SIM_FIELDS_DATA_BY_NAME = "getSimFieldsDataByName";
	private String name;
	private double value;
	
	@OneToMany
    private List<SimulationFields> simFields = new ArrayList<>();
	
	
	
	public SimFieldsData() {
		super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getValue() {
		return value;
	}


	public void setValue(double value) {
		this.value = value;
	}


	public List<SimulationFields> getSimFields() {
		return simFields;
	}


	public void setSimFields(List<SimulationFields> simFields) {
		this.simFields = simFields;
	}


	
	
	
	
	
}
