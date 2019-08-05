package simSalProject.models;


import java.security.NoSuchAlgorithmException;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import simSalProject.Utils.HashEncrypt;



@Entity
@NamedQueries({
	@NamedQuery(name=User_.ALL_USER_IDS, query="SELECT u.id FROM User_ u"),
	@NamedQuery(name=User_.ALL_USER_VALUES, query="SELECT u FROM User_ u"),
	@NamedQuery(name=User_.GET_USER_BY_ID, query="SELECT u FROM User_ u WHERE u.id = :id"),
	@NamedQuery(name=User_.GET_ROLE_COUNT, query="SELECT count(u) FROM User_ u WHERE u.userRole = :userRole")
//	@NamedQuery(name=User_.GET_ROLE_FROM_USER, query="SELECT u FROM User_ u WHERE u.userRole = :role"),
})
public class User_ extends Entity_{
	private static final long serialVersionUID = 1L;
	public static final String ALL_USER_IDS = "getUserIds";
	public static final String ALL_USER_VALUES = "getAllUsers";
	public static final String GET_USER_BY_ID = "getUserById";
	public static final String GET_ROLE_COUNT = "getRoleCount";
	
	
	public enum UserRole {
	    ADMIN, USER, 
	}
	
	private String email;
	private String password;
	private UserRole userRole;
	
	
	public User_() {}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = hashPassword(password);
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public String hashPassword (String passwordToHash) {
		try {
			return HashEncrypt.encryptHash(passwordToHash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	
}