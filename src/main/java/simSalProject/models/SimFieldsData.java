package simSalProject.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "SimulationFieldsData")
@Table(name="simulationfieldsdata")
@NamedQueries({
	@NamedQuery(name=SimFieldsData.GET_SIM_FIELDS_DATA_BY_NAME, query="SELECT sfd FROM SimulationFields sfd WHERE sfd.name = :name"),
	@NamedQuery(name=SimFieldsData.GET_SIM_FIELDS_DATA_COUNT_BY_NAME, query="SELECT count(sfd) FROM SimulationFields sfd WHERE sfd.name = :name"),
	
})
public class SimFieldsData extends Entity_ {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String GET_SIM_FIELDS_DATA_COUNT_BY_NAME = "getSimFieldsDataCountByName";
	public static final String GET_SIM_FIELDS_DATA_BY_NAME = "getSimFieldsDataByName";
	private String name;
	private float value;
	private float result;
	@ManyToMany(mappedBy = "simFieldsData")
	private List<Simulation> simulations;
	
	
	public SimFieldsData() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public float getResult() {
		return result;
	}
	public void setResult(float result) {
		this.result = result;
	}
	
	
	
}
