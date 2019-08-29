package simSalProject.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;

import simSalProject.models.Account;
import simSalProject.models.Colaborator;
import simSalProject.models.ColaboratorDTO;
import simSalProject.models.Simulation;
import simSalProject.repositories.ColaboratorRepository;


public class ColaboratorBusiness {

	@Inject
	ColaboratorRepository colabRepository;
	
	@Inject
	SimulationBusiness simBusiness;

	@Transactional
	public Colaborator createColaborator(Colaborator myColaborator) {
		return colabRepository.createEntity(myColaborator);
	}

	public ColaboratorDTO consultColaborator(long id) {
		return colabRepository.ColaboratorToColaboratorDTO(colabRepository.consultEntity(id));
	}

	@Transactional
	public String editColaborator(ColaboratorDTO myColaboratorDTOToEdit) {
		Colaborator myColaboratorToEdit = colabRepository.ColaboratorDTOToColaborator(myColaboratorDTOToEdit);
		colabRepository.editEntity(myColaboratorToEdit);
		return "Edited";
	}

	@Transactional
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
	
	public static <T> Predicate<T> distinctByKey(
		    Function<? super T, ?> keyExtractor) {
		   
		    Map<Object, Boolean> seen = new ConcurrentHashMap<>(); 
		    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null; 
		}
	
	public ColaboratorDTO ColaboratorToColaboratorDTO(Colaborator myColaborator) {
		ColaboratorDTO myColaboratorDTO = colabRepository.ColaboratorToColaboratorDTO(myColaborator);
		myColaboratorDTO.setName(myColaborator.getName());
		myColaboratorDTO.setDependents(myColaborator.getDependents());
		myColaboratorDTO.setStatus(myColaborator.getStatus());
		List<Simulation> simdb = myColaborator.getSimulations();
		List<Simulation> sim = simdb.stream() 
				  .filter(distinctByKey(p -> p.getId())) 
				  .collect(Collectors.toList());
		myColaboratorDTO.setSimulations(simBusiness.SimulationToSimulationDTO(sim));
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
