package simSalProject.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = Account.ALL_ACC_IDS, query = "SELECT a.id FROM Account a"),
		@NamedQuery(name = Account.ALL_ACC_VALUES, query = "SELECT a FROM Account a"),
		@NamedQuery(name = Account.GET_ACC_BY_ID, query = "SELECT a FROM Account a WHERE a.id = :id"),
		@NamedQuery(name = Account.GET_ACC_COUNT_BY_EMAIL, query = "SELECT count(a) FROM Account a WHERE a.email = :email"),
		@NamedQuery(name = Account.GET_ROLE_COUNT, query = "SELECT count(a) FROM Account a WHERE a.accountRole = :accountRole"),
		@NamedQuery(name = Account.GET_ACC_BY_EMAIL, query = "SELECT a FROM Account a WHERE a.email = :email"),
		@NamedQuery(name = Account.VERIFY_EMAIL_PASS, query = "SELECT a FROM Account a WHERE a.email = :email AND a.password = :password"),
		@NamedQuery(name = Account.VERIFY_EMAIL, query = "SELECT count(a) FROM Account a WHERE a.email = :email"),
		@NamedQuery(name = Account.VERIFY_PASSWORD, query = "SELECT a.password FROM Account a WHERE a.email = :email"),
		@NamedQuery(name = Account.VERIFY_SALT, query = "SELECT a.salt FROM Account a WHERE a.email = :email"),
		@NamedQuery(name = Account.GET_ID_WITH_EMAIL, query = "SELECT a.id FROM Account a WHERE a.email = :email") })

public class Account extends Entity_ {
	private static final long serialVersionUID = 1L;
	public static final String GET_ACC_COUNT_BY_EMAIL = "getAccCountByEmail";
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

	private String name;
	private String email;
	private String password;
	private String salt;
	private AccountRole accountRole;

	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "account", fetch = FetchType.EAGER)
	private List<Colaborator> colaborators;

	public Account() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public AccountRole getAccountRole() {
		return accountRole;
	}

	public void setAccountRole(AccountRole accountRole) {
		this.accountRole = accountRole;
	}

	public List<Colaborator> getColaborators() {
		return colaborators;
	}

	public void setColaborators(List<Colaborator> colaborators) {
		this.colaborators = colaborators;
	}

	
	
}