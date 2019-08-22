package simSalProject.models;

import java.util.ArrayList;
import java.util.List;

public class AccountDTO {
	

	private long id;
	private String name;
	private String email;
	private String accountRole;
	private String message;
	
	private List<ColaboratorDTO> colaboratorsDTO = new ArrayList<ColaboratorDTO>();
	
	
	public AccountDTO() {
		super();
	}

	public List<ColaboratorDTO> getColaboratorsDTO() {
		return colaboratorsDTO;
	}

	public void setColaboratorsDTO(List<ColaboratorDTO> colaboratorsDTO) {
		this.colaboratorsDTO = colaboratorsDTO;
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
