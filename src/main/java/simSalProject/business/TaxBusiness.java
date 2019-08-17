package simSalProject.business;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.Tax;
import simSalProject.repositories.TaxRepository;

@Named("TaxBus")
@RequestScoped
public class TaxBusiness {

	@Inject
	@Named("TaxRep")
	TaxRepository TAX_DB;
	
	public List<Tax> createTax(Tax myTax) {
		TAX_DB.createEntity(myTax);
		return TAX_DB.getTaxByName(myTax.getName());
	}

	public Tax consultTax(long id) {
		Tax myTax = TAX_DB.consultEntity(id);
		return myTax;
	}

	public String editTax(Tax myTaxToEdit) {
		TAX_DB.editEntity(myTaxToEdit);
		return "Edited";
	}

	public String removeTax(Tax myTax) {
		TAX_DB.removeEntity(myTax);
		return "Tax Removed";
	}

	public long getTaxCountByName(String name) {
		// TODO Auto-generated method stub
		return TAX_DB.getTaxCountByName(name);
	}
	
	public List<Tax> getTaxByName(String name) {
		return TAX_DB.getTaxByName(name);
	}
	
	public List<Tax> getAllTaxes() {
		return TAX_DB.getAllTaxes();
	}
	
}
