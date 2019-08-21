package simSalProject.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import simSalProject.models.Account;
import simSalProject.models.Colaborator;
import simSalProject.models.ColaboratorDTO;

@Named("ColabRep")
@RequestScoped
public class ColaboratorRepository extends EntityRepository<Colaborator> {
	

	@Override
	protected String getAllIds() {
		// TODO Auto-generated method stub
		return Colaborator.ALL_COLABORATOR_IDS;
	}

	@Override
	protected String getAllValues() {
		// TODO Auto-generated method stub
		return Colaborator.ALL_COLABORATOR_VALUES;
	}

	public List<Colaborator> getColabById (long id){
		TypedQuery<Colaborator> query = entityManager.createNamedQuery(Colaborator.GET_COLABORATOR_BY_ID, Colaborator.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	public long getColabCountById(long id) {
		TypedQuery<Long> query = entityManager.createNamedQuery(Colaborator.GET_COLABORATOR_COUNT_BY_ID, Long.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	public List<Colaborator> getColabByName (String name){
		TypedQuery<Colaborator> query = entityManager.createNamedQuery(Colaborator.GET_COLABORATOR_BY_NAME, Colaborator.class);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
	public long getColabCountByName(String name) {
		TypedQuery<Long> query = entityManager.createNamedQuery(Colaborator.GET_COLABORATOR_COUNT_BY_NAME, Long.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}
	
	
	@Override
	public Class<Colaborator> getEntityClass(){
		return Colaborator.class;
	}
	
	public ColaboratorDTO ColaboratorToColaboratorDTO(Colaborator myColaborator) {
		ColaboratorDTO myColaboratorDTO = new ColaboratorDTO();
		myColaboratorDTO.setId(myColaborator.getId());
		myColaboratorDTO.setName(myColaborator.getName());
		myColaboratorDTO.setDependents(myColaborator.getDependents());
		myColaboratorDTO.setStatus(myColaborator.getStatus());
		myColaboratorDTO.setSimulations(myColaborator.getSimulations());
		return myColaboratorDTO;
	}

	public Colaborator ColaboratorDTOToColaborator(ColaboratorDTO myColaboratorDTO) {
		Colaborator myColaborator = getColabById(myColaboratorDTO.getId()).get(0);
		return myColaborator;
	}
	
	
	public List<Colaborator> getColabsByAccount(Account account) {
		TypedQuery<Colaborator> query = entityManager.createNamedQuery(Colaborator.GET_COLABORATORS_BY_ACCOUNT_ID, Colaborator.class);
		query.setParameter("account", account);
		return query.getResultList();
	}
	
}
