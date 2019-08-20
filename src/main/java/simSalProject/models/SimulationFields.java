package simSalProject.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
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
	private boolean sA;
	private boolean iRS;
	private boolean sS;
	private boolean tA;
	private boolean bE;
	private boolean varComponent;
	
	public SimulationFields() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean issA() {
		return sA;
	}

	public void setsA(boolean sA) {
		this.sA = sA;
	}

	public boolean isiRS() {
		return iRS;
	}

	public void setiRS(boolean iRS) {
		this.iRS = iRS;
	}

	public boolean issS() {
		return sS;
	}

	public void setsS(boolean sS) {
		this.sS = sS;
	}

	public boolean istA() {
		return tA;
	}

	public void settA(boolean tA) {
		this.tA = tA;
	}

	public boolean isbE() {
		return bE;
	}

	public void setbE(boolean bE) {
		this.bE = bE;
	}

	public boolean isVarComponent() {
		return varComponent;
	}

	public void setVarComponent(boolean varComponent) {
		this.varComponent = varComponent;
	}



	
	
	

	

		
}
