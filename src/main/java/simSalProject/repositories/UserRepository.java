package simSalProject.repositories;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import simSalProject.models.User_;
import simSalProject.models.User_.UserRole;


@Named("UserRep")
@RequestScoped
public class UserRepository extends EntityRepository<User_>{

	
	public Class<User_> getEntityClass(){
		return User_.class;
	}

	@Override
	protected String getAllIds() {
		// TODO Auto-generated method stub
		return User_.ALL_USER_IDS;
	}

	@Override
	protected String getAllValues() {
		// TODO Auto-generated method stub
		return User_.ALL_USER_VALUES;
	}
	
	public List<User_> getUserById (long id){
		TypedQuery<User_> query = entityManager.createNamedQuery(User_.GET_USER_BY_ID, User_.class);
		query.setParameter("id", id);
		
		return query.getResultList();
	}

	public long getRoleCount (UserRole role){
		TypedQuery<Long> query = entityManager.createNamedQuery(User_.GET_ROLE_COUNT, Long.class);
		query.setParameter("userRole", role);
		
		return query.getSingleResult();
	}

}