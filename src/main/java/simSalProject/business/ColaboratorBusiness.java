package simSalProject.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.Account;
import simSalProject.models.Colaborator;
import simSalProject.models.ColaboratorDTO;
import simSalProject.repositories.ColaboratorRepository;

@Named("ColabBus")
@RequestScoped
public class ColaboratorBusiness {

	@Inject
	@Named("ColabRep")
	ColaboratorRepository COLAB_DB;
	
	@Inject
	@Named("SimBus") 
	SimulationBusiness SIM_B;

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
		myColaborator.setAccount(null);
		COLAB_DB.editEntity(myColaborator);
		COLAB_DB.removeEntity(myColaborator);
		return "Colaborator Removed";
	}

	public List<Long> getAllIds() {
		return new ArrayList<Long>(COLAB_DB.allIds());
	}

	public List<ColaboratorDTO> getAllValues() {
		return ColaboratorToColaboratorDTO(COLAB_DB.allValues());
	}
	
	public List<Colaborator> getColabById(long id) {
		return COLAB_DB.getColabById(id);
	}
	
	public long getColabCountById(long id) {
		return COLAB_DB.getColabCountById(id);
	}
	
	public List<ColaboratorDTO> getColabsByAccount (Account account) {
		return ColaboratorToColaboratorDTO(COLAB_DB.getColabsByAccount(account));
	}
	
	
	public List<ColaboratorDTO> ColaboratorToColaboratorDTO(List<Colaborator> colaborators){
		List<ColaboratorDTO> colaboratorsDTO = new ArrayList<ColaboratorDTO>();
		for (Colaborator colaborator : colaborators) {
			colaboratorsDTO.add(ColaboratorToColaboratorDTO(colaborator));
		}
		return colaboratorsDTO;
	}
	
	public ColaboratorDTO ColaboratorToColaboratorDTO(Colaborator myColaborator) {
		ColaboratorDTO myColaboratorDTO = COLAB_DB.ColaboratorToColaboratorDTO(myColaborator);
		myColaboratorDTO.setName(myColaborator.getName());
		myColaboratorDTO.setDependents(myColaborator.getDependents());
		myColaboratorDTO.setStatus(myColaborator.getStatus());
		myColaboratorDTO.setSimulations(SIM_B.SimulationToSimulationDTO(myColaborator.getSimulations()));
		return myColaboratorDTO;
	}

	public Colaborator ColaboratorDTOToColaborator(ColaboratorDTO myColaboratorDTO) {
		Colaborator myColaborator = getColabById(myColaboratorDTO.getId()).get(0);
		return myColaborator;
	}
}
