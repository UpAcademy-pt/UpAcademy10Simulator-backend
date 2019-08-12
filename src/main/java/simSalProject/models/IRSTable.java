package simSalProject.models;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
	@NamedQuery(name=IRSTable.ALL_IRS_VALUES, query="SELECT a FROM IRSTable a")
})
	
public class IRSTable extends Entity_{
	private static final long serialVersionUID = 1L;
	
	public static final String ALL_IRS_VALUES = "getAll";
	
	
	private double monthlySalary;
	private double zeroKids;
	private double oneKid;
	private double twoKids;
	private double threeKids;
	private double fourKids;
	private double fiveKids;
	private String civilState;
	
	public IRSTable() {}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public double getZeroKids() {
		return zeroKids;
	}

	public void setZeroKids(double zeroKids) {
		this.zeroKids = zeroKids;
	}

	public double getOneKid() {
		return oneKid;
	}

	public void setOneKid(double oneKid) {
		this.oneKid = oneKid;
	}

	public double getTwoKids() {
		return twoKids;
	}

	public void setTwoKids(double twoKids) {
		this.twoKids = twoKids;
	}

	public double getThreeKids() {
		return threeKids;
	}

	public void setThreeKids(double threeKids) {
		this.threeKids = threeKids;
	}

	public double getFourKids() {
		return fourKids;
	}

	public void setFourKids(double fourKids) {
		this.fourKids = fourKids;
	}

	public double getFiveKids() {
		return fiveKids;
	}

	public void setFiveKids(double fiveKids) {
		this.fiveKids = fiveKids;
	}

	public String getCivilState() {
		return civilState;
	}

	public void setCivilState(String civilState) {
		this.civilState = civilState;
	}
	
	
	

}
