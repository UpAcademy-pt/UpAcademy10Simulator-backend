package simSalProject.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "SimulationFields")
@Table(name="simulationfields")
@NamedQueries({
	@NamedQuery(name=SimulationFields.ALL_SIM_FIELDS_IDS, query="SELECT sf.id FROM SimulationFields sf "),
	@NamedQuery(name=SimulationFields.ALL_SIM_FIELDS_VALUES, query="SELECT sf FROM SimulationFields sf"),
	@NamedQuery(name=SimulationFields.GET_SIM_FIELDS_BY_ID, query="SELECT sf FROM SimulationFields sf WHERE sf.id = :id"),
	@NamedQuery(name=SimulationFields.GET_SIM_FIELDS_BY_NAME, query="SELECT sf FROM SimulationFields sf WHERE sf.name = :name"),
	@NamedQuery(name=SimulationFields.GET_SIM_FIELDS_COUNT_BY_NAME, query="SELECT count(sf) FROM SimulationFields sf WHERE sf.name = :name"),
	
})
public class SimulationFields extends Entity_{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ALL_SIM_FIELDS_IDS = "getAllSimFieldsIds";
	public static final String ALL_SIM_FIELDS_VALUES = "getAllSimFieldsValues";
	public static final String GET_SIM_FIELDS_BY_ID = "getSimFieldsById";
	public static final String GET_SIM_FIELDS_BY_NAME = "getSimFieldsByName";
	public static final String GET_SIM_FIELDS_COUNT_BY_NAME = "getSimFieldsByNameCount";
	
	private String name;
	private double sA;
	private double iRS;
	private double sS;
	private double tA;
	private double bE;
	private double varComponent;
	@ManyToMany(mappedBy = "simFields")
    private List<Simulation> simulations = new ArrayList<>();
	
	public SimulationFields() {
		super();
	}


	
	
	public SimulationFields(String name, double sA, double iRS, double sS, double tA, double bE, double varComponent) {
		super();
		this.name = name;
		this.sA = sA;
		this.iRS = iRS;
		this.sS = sS;
		this.tA = tA;
		this.bE = bE;
		this.varComponent = varComponent;
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getsA() {
		return sA;
	}


	public void setsA(double sA) {
		this.sA = sA;
	}


	public double getiRS() {
		return iRS;
	}


	public void setiRS(double iRS) {
		this.iRS = iRS;
	}


	public double getsS() {
		return sS;
	}


	public void setsS(double sS) {
		this.sS = sS;
	}


	public double gettA() {
		return tA;
	}


	public void settA(double tA) {
		this.tA = tA;
	}


	public double getbE() {
		return bE;
	}


	public void setbE(double bE) {
		this.bE = bE;
	}


	public double getVarComponent() {
		return varComponent;
	}


	public void setVarComponent(double varComponent) {
		this.varComponent = varComponent;
	}

	

		
}
