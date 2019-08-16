package simSalProject.models;

import javax.persistence.Entity;

@Entity
public class Tax extends Entity_ {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double autoTaxation;
	private double socialSecurityWorker;
	private double socialSecurityCompany;
	
	
	
	
	public Tax() {
		super();
	}


	public Tax(double autoTaxation, double socialSecurityWorker, double socialSecurityCompany) {
		super();
		this.autoTaxation = autoTaxation;
		this.socialSecurityWorker = socialSecurityWorker;
		this.socialSecurityCompany = socialSecurityCompany;
	}
	
	
	public double getAutoTaxation() {
		return autoTaxation;
	}
	public void setAutoTaxation(double autoTaxation) {
		this.autoTaxation = autoTaxation;
	}
	public double getSocialSecurityWorker() {
		return socialSecurityWorker;
	}
	public void setSocialSecurityWorker(double socialSecurityWorker) {
		this.socialSecurityWorker = socialSecurityWorker;
	}
	public double getSocialSecurityCompany() {
		return socialSecurityCompany;
	}
	public void setSocialSecurityCompany(double socialSecurityCompany) {
		this.socialSecurityCompany = socialSecurityCompany;
	}
	
	
	
}
