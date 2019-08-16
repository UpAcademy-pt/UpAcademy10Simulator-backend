package simSalProject.models;

public class AccountDTO {
	

	private long id;
	private String name;
	private String email;
	private String accountRole;
	private String message;
	
	
	
	
	public AccountDTO() {
		super();
	}
	
	
	

	public AccountDTO(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getAccountRole() {
		return accountRole;
	}

	public void setAccountRole(String accountRole) {
		this.accountRole = accountRole;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
