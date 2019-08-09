package simSalProject.repositories;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import simSalProject.models.Colaborator;

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

	public Colaborator getColabById (long id){
		TypedQuery<Colaborator> query = entityManager.createNamedQuery(Colaborator.GET_COLABORATOR_BY_ID, Colaborator.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}
	
	public Colaborator getColabByName (String name){
		TypedQuery<Colaborator> query = entityManager.createNamedQuery(Colaborator.GET_COLABORATOR_BY_NAME, Colaborator.class);
		query.setParameter("name", name);
		
		return query.getSingleResult();
	}
	
	
	@Override
	public Class<Colaborator> getEntityClass(){
		return Colaborator.class;
	}
}
