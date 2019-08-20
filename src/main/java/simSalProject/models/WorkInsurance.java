package simSalProject.models;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=WorkInsurance.GET_ALL_WORKINSURANCE_VALUES, query="SELECT w FROM WorkInsurance w")
})
public class WorkInsurance extends Entity_{
	private static final long serialVersionUID = 1L;
	
	
	public static final String GET_ALL_WORKINSURANCE_VALUES = "getWorkInsuranceValue";
	
	public WorkInsurance() {}

	
	private double workInsuranceVariable;
	private int varAccountedForWorkInsurance;

	public double getWorkInsuranceVariable() {
		return workInsuranceVariable;
	}


	public void setWorkInsuranceVariable(double workInsuranceVariable) {
		this.workInsuranceVariable = workInsuranceVariable;
	}


	public int getVarAccountedForWorkInsurance() {
		return varAccountedForWorkInsurance;
	}


	public void setVarAccountedForWorkInsurance(int varAccountedForWorkInsurance) {
		this.varAccountedForWorkInsurance = varAccountedForWorkInsurance;
	}
	
	
	
}
