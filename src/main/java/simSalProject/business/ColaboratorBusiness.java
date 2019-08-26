package simSalProject.business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import simSalProject.models.Account;
import simSalProject.models.Colaborator;
import simSalProject.models.ColaboratorDTO;
import simSalProject.repositories.ColaboratorRepository;


public class ColaboratorBusiness {

	@Inject
	ColaboratorRepository colabRepository;
	
	@Inject
	SimulationBusiness simRepository;

	public List<ColaboratorDTO> createColaborator(Colaborator myColaborator) {
		colabRepository.createEntity(myColaborator);
		List<ColaboratorDTO> colaboratorsDTO = new ArrayList<ColaboratorDTO>();
		colaboratorsDTO.add(colabRepository.ColaboratorToColaboratorDTO(colabRepository.getColabById(myColaborator.getId()).get(0)));
		return colaboratorsDTO;
	}

	public ColaboratorDTO consultColaborator(long id) {
		return colabRepository.ColaboratorToColaboratorDTO(colabRepository.consultEntity(id));
	}

	public String editColaborator(ColaboratorDTO myColaboratorDTOToEdit) {
		Colaborator myColaboratorToEdit = colabRepository.ColaboratorDTOToColaborator(myColaboratorDTOToEdit);
		colabRepository.editEntity(myColaboratorToEdit);
		return "Edited";
	}

	public String removeColaborator(Colaborator myColaborator) {
		myColaborator.setAccount(null);
		colabRepository.editEntity(myColaborator);
		colabRepository.removeEntity(myColaborator);
		return "Colaborator Removed";
	}

	public List<Long> getAllIds() {
		return new ArrayList<Long>(colabRepository.allIds());
	}

	public List<ColaboratorDTO> getAllValues() {
		return ColaboratorToColaboratorDTO(colabRepository.allValues());
	}
	
	public List<Colaborator> getColabById(long id) {
		return colabRepository.getColabById(id);
	}
	
	public long getColabCountById(long id) {
		return colabRepository.getColabCountById(id);
	}
	
	public List<ColaboratorDTO> getColabsByAccount (Account account) {
		return ColaboratorToColaboratorDTO(colabRepository.getColabsByAccount(account));
	}
	
	
	public List<ColaboratorDTO> ColaboratorToColaboratorDTO(List<Colaborator> colaborators){
		List<ColaboratorDTO> colaboratorsDTO = new ArrayList<ColaboratorDTO>();
		for (Colaborator colaborator : colaborators) {
			colaboratorsDTO.add(ColaboratorToColaboratorDTO(colaborator));
		}
		return colaboratorsDTO;
	}
	
	public ColaboratorDTO ColaboratorToColaboratorDTO(Colaborator myColaborator) {
		ColaboratorDTO myColaboratorDTO = colabRepository.ColaboratorToColaboratorDTO(myColaborator);
		myColaboratorDTO.setName(myColaborator.getName());
		myColaboratorDTO.setDependents(myColaborator.getDependents());
		myColaboratorDTO.setStatus(myColaborator.getStatus());
		myColaboratorDTO.setSimulations(simRepository.SimulationToSimulationDTO(myColaborator.getSimulations()));
		return myColaboratorDTO;
	}

	public Colaborator ColaboratorDTOToColaborator(ColaboratorDTO myColaboratorDTO) {
		Colaborator myColaborator = getColabById(myColaboratorDTO.getId()).get(0);
		return myColaborator;
	}
	
	public long getColabCount() {
		return colabRepository.getColabCount();
	}
}
