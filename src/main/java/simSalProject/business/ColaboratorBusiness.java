package simSalProject.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.Colaborator;
import simSalProject.repositories.ColaboratorRepository;

@Named("ColabBus")
@RequestScoped
public class ColaboratorBusiness {

	@Inject
	@Named("ColabRep")
	ColaboratorRepository COLAB_DB;
	
	public String createColaborator(Colaborator myColaborator) {
		
		COLAB_DB.createEntity(myColaborator);
		return "Created";
		
	}
	
	public Colaborator consultColaborator(long id) {
		Colaborator myColaborator = COLAB_DB.consultEntity(id);
		return myColaborator;
	}
	
	public void editColaborator(long id, Colaborator myColaboratorToEdit) {
		
			COLAB_DB.editEntity(myColaboratorToEdit);
		
	}
	
	public void removeColaborator(Colaborator myColaborator) {
		
			COLAB_DB.removeEntity(myColaborator);
		
	}
	
	public List<Long> getAllIds() {
		return new ArrayList<Long>(COLAB_DB.allIds());
	}
	
	public Collection<Colaborator> getAllValues() {
		return COLAB_DB.allValues();
	}
	
}
