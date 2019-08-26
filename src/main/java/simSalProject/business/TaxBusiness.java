package simSalProject.business;

import java.util.List;

import javax.inject.Inject;

import simSalProject.models.Tax;
import simSalProject.repositories.TaxRepository;


public class TaxBusiness {

	@Inject
	TaxRepository taxRepository;
	
	public List<Tax> createTax(Tax myTax) {
		taxRepository.createEntity(myTax);
		return taxRepository.getTaxByName(myTax.getName());
	}

	public Tax consultTax(long id) {
		Tax myTax = taxRepository.consultEntity(id);
		return myTax;
	}

	public String editTax(Tax myTaxToEdit) {
		taxRepository.editEntity(myTaxToEdit);
		return "Edited";
	}

	public String removeTax(Tax myTax) {
		taxRepository.removeEntity(myTax);
		return "Tax Removed";
	}

	public long getTaxCountByName(String name) {
		// TODO Auto-generated method stub
		return taxRepository.getTaxCountByName(name);
	}
	
	public List<Tax> getTaxByName(String name) {
		return taxRepository.getTaxByName(name);
	}
	
	public List<Tax> getAllTaxes() {
		return taxRepository.getAllTaxes();
	}
	
}
