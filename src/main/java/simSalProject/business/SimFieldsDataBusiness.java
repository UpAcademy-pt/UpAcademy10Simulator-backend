package simSalProject.business;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.repositories.SimFieldsDataRepository;

@Named("SimFieldsDataBus")
@RequestScoped
public class SimFieldsDataBusiness {

	@Inject
	@Named("SimFieldsDataRep")
	SimFieldsDataRepository SIMFD_DB;
	
	
	
	
}
