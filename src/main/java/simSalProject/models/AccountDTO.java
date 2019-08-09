package simSalProject.models;

public class AccountDTO {
	
	public enum AccountRole {
	    ADMIN, USER, 
	}
	private long id;
	private String email;
	private AccountRole accountRole;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AccountRole getAccountRole() {
		return accountRole;
	}

	public void setAccountRole(AccountRole accountRole) {
		this.accountRole = accountRole;
	}
	
	
	
	
}
