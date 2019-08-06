package simSalProject.models;


import java.security.NoSuchAlgorithmException;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import simSalProject.Utils.HashEncrypt;



@Entity
@NamedQueries({
	@NamedQuery(name=Account.ALL_ACC_IDS, query="SELECT a.id FROM Account a"),
	@NamedQuery(name=Account.ALL_ACC_VALUES, query="SELECT a FROM Account a"),
	@NamedQuery(name=Account.GET_ACC_BY_ID, query="SELECT a FROM Account a WHERE a.id = :id"),
	@NamedQuery(name=Account.GET_ROLE_COUNT, query="SELECT count(a) FROM Account a WHERE a.accountRole = :accountRole")
//	@NamedQuery(name=User_.GET_ROLE_FROM_USER, query="SELECT u FROM User_ u WHERE u.userRole = :role"),
})

public class Account extends Entity_{
	private static final long serialVersionUID = 1L;
	public static final String ALL_ACC_IDS = "getAccIds";
	public static final String ALL_ACC_VALUES = "getAllAccs";
	public static final String GET_ACC_BY_ID = "getAccById";
	public static final String GET_ROLE_COUNT = "getRoleCount";
	
	
	public enum AccountRole {
	    ADMIN, USER, 
	}
	
	private String email;
	private String password;
	private AccountRole accountRole;
	
	public Account() {}

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
	
	
	public void setAccRole(AccountRole accountRole) {
		this.accountRole = accountRole;
	}

	
	public AccountRole getAccRole() {
		return accountRole;
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