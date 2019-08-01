package simSalProject.models;


import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;



@Entity
public class User_ extends Entity_{
	private static final long serialVersionUID = 1L;
	
	private enum UserRole {
	    OWNER, ADMIN, BASEUSER, 
	}
	
	private String email;
	private Integer password;
	private UserRole userRole;
	private long date;
	
	
	public User_() {}

	public User_(String email, String password, UserRole role ) {
		this.email = email;
		this.password = password.hashCode();
		this.userRole = role;
		this.date = new Date().getTime();
		


	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getEmail() {
		return email;
	}

	public int getPassword() {
		return password;
	}
	
	public UserRole getUserRole() {
		return userRole;
	}
	

	public int myHashCode(int password) {
		System.out.println(this.date);
		System.out.println("Entrou: "+ Objects.hash(password, this.date));
		return Objects.hash(password, this.date);
	}
	
}