package simSalProject.business;

import java.util.Collection;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.Colaborator;
import simSalProject.models.IRSTable;
import simSalProject.repositories.IRSTableRepository;

@Named("IRSTableBus")
@RequestScoped
public class IRSTableBusiness {
	
	@Inject
	@Named("IRSTableRep")
	IRSTableRepository irsRepository;

	public String getAllIRSTable() {
		return irsRepository.getAllValues();
	}

	public void createIRSTable(Collection <IRSTable> table) {
		System.out.println(irsRepository.existSomethingInIRSTable());
		if (irsRepository.existSomethingInIRSTable()) {	
			irsRepository.deleteAll();
			irsRepository.setAllTable(table);
		} else {
			irsRepository.setAllTable(table);
		}
		
	}

	public List<Object[]> filterIRSTable(Colaborator colaborator) {
		String depedents = colaborator.getDependents();
		int depedentsInt = Integer.parseInt(depedents);
		String status = colaborator.getStatus();
		return irsRepository.filteIRSTable(depedentsInt, status);
		
	}
	

}
	