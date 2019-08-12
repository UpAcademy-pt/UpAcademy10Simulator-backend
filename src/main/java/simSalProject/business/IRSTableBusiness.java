package simSalProject.business;

import java.util.Collection;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.IRSTable;
import simSalProject.repositories.IRSTableRepository;

@Named("IRSTableBus")
@RequestScoped
public class IRSTableBusiness {
	
	@Inject
	@Named("IRSTableRep")
	IRSTableRepository IRS_DB;

	public Collection<IRSTable> getAllIRSTable() {
		return IRS_DB.allValues();
	}

	public void createIRSTable(Collection <IRSTable> table) {
		
		IRS_DB.setAllTable(table);
		
	}
	

}
