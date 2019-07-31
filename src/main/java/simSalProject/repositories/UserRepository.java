package simSalProject.repositories;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import simSalProject.models.User_;


@Named("UserRep")
@RequestScoped
public class UserRepository extends EntityRepository<User_>{

	
	public Class<User_> getEntityClass(){
		return User_.class;
	}

}