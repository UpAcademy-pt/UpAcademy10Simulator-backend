package simSalProject.business;

import java.util.Collection;

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
	IRSTableRepository IRS_DB;

	public Collection<IRSTable> getAllIRSTable() {
		return IRS_DB.getAllValues();
	}

	public void createIRSTable(Collection <IRSTable> table) {
		
		IRS_DB.setAllTable(table);
		
	}

	public Collection<IRSTable> filterIRSTable(Colaborator colaborator) {
		String depedents = colaborator.getDependents();
		int depedentsInt = Integer.parseInt(depedents);
		String status = colaborator.getStatus();
		return IRS_DB.filteIRSTable(depedentsInt, status);
		
	}
	

}
