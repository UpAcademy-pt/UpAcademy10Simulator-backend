package simSalProject.models;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=Tax.GET_TAX_BY_NAME, query="SELECT t FROM Tax t WHERE t.name = :name"),
	@NamedQuery(name=Tax.GET_TAX_COUNT_BY_NAME, query="SELECT count(t) FROM Tax t WHERE t.name = :name")
})
public class Tax extends Entity_ {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String GET_TAX_BY_NAME = "getTaxByName";
	public static final String GET_TAX_COUNT_BY_NAME = "getTaxCountByName";
	
	private String name;
	private double value;

	
	
	
	
	public Tax() {
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


	
	
}
