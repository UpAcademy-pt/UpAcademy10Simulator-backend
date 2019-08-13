package simSalProject.models;

import javax.persistence.Entity;
import simSalProject.models.Entity_;

@Entity
public class SimFieldsData extends Entity_ {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private float value;
	private float result;
	
	
	
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
