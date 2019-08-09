package simSalProject.models;


import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@Entity
@NamedQueries({
	@NamedQuery(name=Account.ALL_ACC_IDS, query="SELECT a.id FROM Account a"),
	@NamedQuery(name=Account.ALL_ACC_VALUES, query="SELECT a FROM Account a"),
	@NamedQuery(name=Account.GET_ACC_BY_ID, query="SELECT a FROM Account a WHERE a.id = :id"),
	@NamedQuery(name=Account.GET_ROLE_COUNT, query="SELECT count(a) FROM Account a WHERE a.accountRole = :accountRole"),
	@NamedQuery(name=Account.GET_ACC_BY_EMAIL, query="SELECT a FROM Account a WHERE a.email = :email")
	@NamedQuery(name=Account.VERIFY_EMAIL_PASS, query="SELECT a FROM Account a WHERE a.email = :email AND a.password = :password"),
	@NamedQuery(name=Account.VERIFY_EMAIL, query="SELECT count(a) FROM Account a WHERE a.email = :email"),	
	@NamedQuery(name=Account.VERIFY_PASSWORD, query="SELECT a.password FROM Account a WHERE a.email = :email"),
	@NamedQuery(name=Account.VERIFY_SALT, query="SELECT a.salt FROM Account a WHERE a.email = :email"),
	@NamedQuery(name=Account.GET_ID_WITH_EMAIL, query="SELECT a.id FROM Account a WHERE a.email = :email")
//	@NamedQuery(name=User_.GET_ROLE_FROM_USER, query="SELECT u FROM User_ u WHERE u.userRole = :role"),
})

public class Account extends Entity_{
	private static final long serialVersionUID = 1L;
	public static final String ALL_ACC_IDS = "getAccIds";
	public static final String ALL_ACC_VALUES = "getAllAccs";
	public static final String GET_ACC_BY_ID = "getAccById";
	public static final String GET_ROLE_COUNT = "getRoleCount";
	public static final String GET_ACC_BY_EMAIL = "existsAccountbyEmail";
	public static final String VERIFY_EMAIL_PASS = "verifyEmailAndPass";
	public static final String VERIFY_EMAIL = "verifyEmail";
	public static final String VERIFY_PASSWORD = "verifyPassword";
	public static final String VERIFY_SALT = "verifySalt";
	public static final String GET_ID_WITH_EMAIL = "getIdWithEmail";

	
	
	public enum AccountRole {
	    ADMIN, USER, 
	}

	
	private String email;
	private String password;
	private String salt;
	private AccountRole accountRole;
	
	public Account() {}

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
	
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setAccRole(AccountRole accountRole) {
		this.accountRole = accountRole;
	}

	
	public AccountRole getAccRole() {
		return accountRole;
	}

//	public String hashPassword (String passwordToHash) {
//		try {
//			byte[] salt = HashEncrypt.getSalt();
//			setSalt(salt);
//			String securePassword = HashEncrypt.getSecurePassword(passwordToHash, salt);
//			
//			return securePassword;
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	

	
	
}