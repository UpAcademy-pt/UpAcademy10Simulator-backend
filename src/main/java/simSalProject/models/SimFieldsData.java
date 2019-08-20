package simSalProject.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "SimulationFieldsData")
@Table(name = "simulationfieldsdata")
@NamedQueries({
		@NamedQuery(name = SimFieldsData.GET_SIM_FIELDS_DATA_BY_NAME, query = "SELECT sfd FROM SimulationFieldsData sfd WHERE sfd.name = :name"),
		@NamedQuery(name = SimFieldsData.GET_SIM_FIELDS_DATA_COUNT_BY_NAME, query = "SELECT count(sfd) FROM SimulationFieldsData sfd WHERE sfd.name = :name"),
//	@NamedQuery(name=SimFieldsData.PUT_SIM_FIELDS_DATA_FROM_FIELD_NAMES, query="INSERT INTO SimFieldsData (name, value) VALUES(SELECT ")
})
public class SimFieldsData extends Entity_ {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public static final String GET_SIM_FIELDS_DATA_COUNT_BY_NAME = "getSimFieldsDataCountByName";
	public static final String GET_SIM_FIELDS_DATA_BY_NAME = "getSimFieldsDataByName";
	public static final String PUT_SIM_FIELDS_DATA_FROM_FIELD_NAMES = "updateSimFieldsData";
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Simulation simulation;
	private String name;
	private double value;
	
	

	
	

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

	public Simulation getSimulation() {
		return simulation;
	}

	public void setSimulation(Simulation simulation) {
		this.simulation = simulation;
	}
	
	

}
