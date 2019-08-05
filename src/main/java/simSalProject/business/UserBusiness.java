package simSalProject.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.Response;

import simSalProject.Utils.SendMail;
import simSalProject.models.User_;
import simSalProject.repositories.UserRepository;

@Named("UserBus")
@RequestScoped
public class UserBusiness  {
	
	
	@Inject
	@Named("UserRep")
	UserRepository USER_DB;
	
	
	public String createUser(User_ myUser) {
		String randomPassword = SendMail.createRandom();
		myUser.setPassword(randomPassword);
		try {
			SendMail.sendMail(myUser.getEmail(), randomPassword);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (USER_DB.allValues().contains(myUser)) {
			return "This user already exists";
		}
		USER_DB.createEntity(myUser);
		return "Created";
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
