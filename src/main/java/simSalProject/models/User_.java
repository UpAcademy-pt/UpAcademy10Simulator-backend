package simSalProject.models;


import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@Entity
@NamedQueries({
	@NamedQuery(name=User_.ALL_USER_IDS, query="SELECT u.id FROM User_ u"),
	@NamedQuery(name=User_.ALL_USER_VALUES, query="SELECT u FROM User_ u"),
	@NamedQuery(name=User_.GET_USER_BY_ID, query="SELECT u FROM User_ u WHERE u.id = :id")
})
public class User_ extends Entity_{
	private static final long serialVersionUID = 1L;
	public static final String ALL_USER_IDS = "getUserIds";
	public static final String ALL_USER_VALUES = "getAllUsers";
	public static final String GET_USER_BY_ID = "getUserById";
	
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