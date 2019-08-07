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
	private float SA;
	private float IRS;
	private float SS;
	private float TA;
	private float BE;
	private float varComponent;
	
	
	public SimulationFields() {
		super();
	}

	public SimulationFields(String name, float sA, float iRS, float sS, float tA, float bE, float varComponent) {
		super();
		this.name = name;
		this.SA = sA;
		this.IRS = iRS;
		this.SS = sS;
		this.TA = tA;
		this.BE = bE;
		this.varComponent = varComponent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSA() {
		return SA;
	}

	public void setSA(float sA) {
		SA = sA;
	}

	public float getIRS() {
		return IRS;
	}

	public void setIRS(float iRS) {
		IRS = iRS;
	}

	public float getSS() {
		return SS;
	}

	public void setSS(float sS) {
		SS = sS;
	}

	public float getTA() {
		return TA;
	}

	public void setTA(float tA) {
		TA = tA;
	}

	public float getBE() {
		return BE;
	}

	public void setBE(float bE) {
		BE = bE;
	}

	public float getVarComponent() {
		return varComponent;
	}

	public void setVarComponent(float varComponent) {
		this.varComponent = varComponent;
	}
	
	
	
	
}
