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

	public List<Colaborator> createColaborator(Colaborator myColaborator) {
		COLAB_DB.createEntity(myColaborator);
		return COLAB_DB.getColabByName(myColaborator.getName());
	}

	public Colaborator consultColaborator(long id) {
		Colaborator myColaborator = COLAB_DB.consultEntity(id);
		return myColaborator;
	}

	public String editColaborator(Colaborator myColaboratorToEdit) {
		COLAB_DB.editEntity(myColaboratorToEdit);
		return "Edited";
	}

	public String removeColaborator(Colaborator myColaborator) {
		COLAB_DB.removeEntity(myColaborator);
		return "Colaborator Removed";
	}

	public List<Long> getAllIds() {
		return new ArrayList<Long>(COLAB_DB.allIds());
	}

	public Collection<Colaborator> getAllValues() {
		return COLAB_DB.allValues();
	}
	
	public List<Colaborator> getColabById(long id) {
		return COLAB_DB.getColabById(id);
	}
	
	public long getColabCountByName(String name) {
		return COLAB_DB.getColabCountByName(name);
	}
	
	public List<Colaborator> getColabByName(String name) {
		return COLAB_DB.getColabByName(name);
	}
	
	public long getColabCountById(long id) {
		return COLAB_DB.getColabCountById(id);
	}
	
}
