package simSalProject.models;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=SimulationFields.ALL_SIM_FIELDS_IDS, query="SELECT sf.id FROM SimulationFields sf "),
	@NamedQuery(name=SimulationFields.ALL_SIM_FIELDS_VALUES, query="SELECT sf FROM SimulationFields sf"),
})
public class SimulationFields extends Entity_{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ALL_SIM_FIELDS_IDS = "getAllSimFieldsIds";
	public static final String ALL_SIM_FIELDS_VALUES = "getAllSimFieldsValues";
	
	private String name;
	private double SA;
	private double IRS;
	private double SS;
	private double TA;
	private double BE;
	private double varComponent;
	
	
	public SimulationFields() {
		super();
	}

	

	public SimulationFields(String name, double sA, double iRS, double sS, double tA, double bE, double varComponent) {
		super();
		this.name = name;
		SA = sA;
		IRS = iRS;
		SS = sS;
		TA = tA;
		BE = bE;
		this.varComponent = varComponent;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSA() {
		return SA;
	}


	public void setSA(double sA) {
		SA = sA;
	}


	public double getIRS() {
		return IRS;
	}


	public void setIRS(double iRS) {
		IRS = iRS;
	}


	public double getSS() {
		return SS;
	}


	public void setSS(double sS) {
		SS = sS;
	}


	public double getTA() {
		return TA;
	}


	public void setTA(double tA) {
		TA = tA;
	}


	public double getBE() {
		return BE;
	}


	public void setBE(double bE) {
		BE = bE;
	}


	public double getVarComponent() {
		return varComponent;
	}


	public void setVarComponent(double varComponent) {
		this.varComponent = varComponent;
	}

	
	
	
	
}
