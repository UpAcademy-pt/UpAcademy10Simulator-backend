package simSalProject.models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;



@Entity
public class User_ extends Entity_{
	private static final long serialVersionUID = 1L;
	
	private enum UserRole {
	    OWNER, ADMIN, BASEUSER, 
	}
	
	private String email;
	private String password;
	private UserRole userRole;
	
	public User_() {}

	public User_(String email, String password, UserRole role ) {
		this.email = email;
		this.password = password;
		this.userRole = role;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public UserRole getUserRole() {
		return userRole;
	}
}