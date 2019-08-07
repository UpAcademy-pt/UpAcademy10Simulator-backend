package simSalProject.business;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.repositories.SimulationsFieldsRepository;

@Named("SimFieldsBus")
@RequestScoped
public class SimulationsFieldsBusiness {

	@Inject
	@Named("SimFieldsRep")
	SimulationsFieldsRepository SIMF_DB;
	
	
}
