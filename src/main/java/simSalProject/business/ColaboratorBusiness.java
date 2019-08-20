package simSalProject.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.Colaborator;
import simSalProject.models.ColaboratorDTO;
import simSalProject.repositories.ColaboratorRepository;

@Named("ColabBus")
@RequestScoped
public class ColaboratorBusiness {

	@Inject
	@Named("ColabRep")
	ColaboratorRepository COLAB_DB;

	public List<ColaboratorDTO> createColaborator(Colaborator myColaborator) {
		COLAB_DB.createEntity(myColaborator);
		List<ColaboratorDTO> colaboratorsDTO = new ArrayList<ColaboratorDTO>();
		colaboratorsDTO.add(COLAB_DB.ColaboratorToColaboratorDTO(COLAB_DB.getColabById(myColaborator.getId()).get(0)));
		return colaboratorsDTO;
	}

	public ColaboratorDTO consultColaborator(long id) {
		Colaborator myColaborator = COLAB_DB.consultEntity(id);
		
		return COLAB_DB.ColaboratorToColaboratorDTO(myColaborator);
	}

	public String editColaborator(ColaboratorDTO myColaboratorDTOToEdit) {
		Colaborator myColaboratorToEdit = COLAB_DB.ColaboratorDTOToColaborator(myColaboratorDTOToEdit);
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

	public List<ColaboratorDTO> getAllValues() {
		List<Colaborator> colaborators = COLAB_DB.allValues();
		List<ColaboratorDTO> colaboratorsDTO = new ArrayList<ColaboratorDTO>();
		for (Colaborator colaborator : colaborators) {
			colaboratorsDTO.add(COLAB_DB.ColaboratorToColaboratorDTO(colaborator));
		}
		return colaboratorsDTO;
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
