package simSalProject.business;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.repositories.ColaboratorRepository;

@Named("ColabBus")
@RequestScoped
public class ColaboratorBusiness {

	@Inject
	@Named("ColabRep")
	ColaboratorRepository COLAB_DB;
	
	
}
