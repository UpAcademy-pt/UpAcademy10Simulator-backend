package simSalProject.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Colaborator")
@Table(name = "colaborator")
@NamedQueries({ @NamedQuery(name = Colaborator.ALL_COLABORATOR_IDS, query = "SELECT c.id FROM Colaborator c"),
		@NamedQuery(name = Colaborator.ALL_COLABORATOR_VALUES, query = "SELECT c FROM Colaborator c"),
		@NamedQuery(name = Colaborator.GET_COLABORATOR_BY_ID, query = "SELECT c FROM Colaborator c WHERE c.id = :id"),
		@NamedQuery(name = Colaborator.GET_COLABORATOR_BY_NAME, query = "SELECT c FROM Colaborator C WHERE c.name = :name"),
		@NamedQuery(name = Colaborator.GET_COLABORATOR_COUNT_BY_NAME, query = "SELECT count(c) FROM Colaborator c WHERE c.name = :name"),
		@NamedQuery(name = Colaborator.GET_COLABORATOR_COUNT_BY_ID, query = "SELECT count(c) FROM Colaborator c WHERE c.id = :id"),
		@NamedQuery(name = Colaborator.GET_COLABORATORS_BY_ACCOUNT_ID, query = "SELECT c FROM Colaborator c WHERE c.account = :account"),
		@NamedQuery(name = Colaborator.GET_COLAB_COUNT, query = "SELECT count(c) FROM Colaborator c"),
})
public class Colaborator extends Entity_ {
	private static final long serialVersionUID = 1L;
	public static final String ALL_COLABORATOR_IDS = "getAllColabIds";
	public static final String ALL_COLABORATOR_VALUES = "getAllColabs";
	public static final String GET_COLABORATOR_BY_ID = "getColabById";
	public static final String GET_COLABORATOR_COUNT_BY_ID = "getColabCountById";
	public static final String GET_COLABORATOR_BY_NAME = "getColabByName";
	public static final String GET_COLABORATOR_COUNT_BY_NAME = "getColabCountByName";
	public static final String GET_COLABORATORS_BY_ACCOUNT_ID = "getColabsByAccountId";
	public static final String GET_COLAB_COUNT = "getColabCount";
	
	@ManyToOne
	private Account account;
	private String name;
	private String status;
	private String dependents;
	

	@OneToMany(cascade = {CascadeType.ALL}, mappedBy = "colaborator", fetch = FetchType.EAGER)
	private List<Simulation> simulations = new ArrayList<>();

	public Colaborator() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDependents() {
		return dependents;
	}

	public void setDependents(String dependents) {
		this.dependents = dependents;
	}

	public List<Simulation> getSimulations() {
		return simulations;
	}

	public void setSimulations(List<Simulation> simulations) {
		this.simulations = simulations;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	

}
