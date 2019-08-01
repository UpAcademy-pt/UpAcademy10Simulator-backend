package simSalProject.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Response;

import simSalProject.models.User_;
import simSalProject.repositories.UserRepository;

public class UserBusiness  {
	
	
	@Inject
	@Named("UserBus")
	UserRepository USER_DB;
	
	
	public void createUser(User_ myUser) {
		USER_DB.createEntity(myUser);
	}
	
	
	public User_ consultUser(long id) {
		User_ myUser = USER_DB.consultEntity(id);
		return myUser;
	}
	
	public void editUser(long id, User_ myUserToEdit) {
		USER_DB.editEntity(myUserToEdit);
	}
	
	public void removeUser(User_ myUser) {
		USER_DB.removeEntity(myUser);
	}
	
	public List<Long> getAllIds() {
		return new ArrayList<Long>(USER_DB.allIds());
	}
	
	public Collection<User_> getAllValues() {
		return USER_DB.allValues();
	}
	
	
	
	public Response login() {
		
		
		
		return Response.ok().build();
		
	}
	
	
}
