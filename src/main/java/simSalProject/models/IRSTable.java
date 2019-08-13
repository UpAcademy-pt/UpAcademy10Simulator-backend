package simSalProject.models;

import simSalProject.models.Entity_;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
	@NamedQuery(name=IRSTable.ALL_IRS_VALUES, query="SELECT a FROM IRSTable a"),
	@NamedQuery(name=IRSTable.ALL_IRS_IDS, query="SELECT a.id FROM IRSTable a"),
	@NamedQuery(name=IRSTable.FILTER_IRS_BY_ZERO, query="SELECT a FROM IRSTable a WHERE a.n_titulares_rendimento = :n_titulares_rendimento"),
	@NamedQuery(name=IRSTable.FILTER_IRS_BY_ONE, query="SELECT a.id, a.remuneracao_mensal, a.um FROM IRSTable a WHERE a.n_titulares_rendimento = :n_titulares_rendimento"),
	@NamedQuery(name=IRSTable.FILTER_IRS_BY_TWO, query="SELECT a.id, a.remuneracao_mensal, a.dois FROM IRSTable a WHERE a.n_titulares_rendimento = :n_titulares_rendimento"),
	@NamedQuery(name=IRSTable.FILTER_IRS_BY_THREE, query="SELECT a.id, a.remuneracao_mensal, a.tres FROM IRSTable a WHERE a.n_titulares_rendimento = :n_titulares_rendimento"),
	@NamedQuery(name=IRSTable.FILTER_IRS_BY_FOUR, query="SELECT a.id, a.remuneracao_mensal, a.quatro FROM IRSTable a WHERE a.n_titulares_rendimento = :n_titulares_rendimento"),
	@NamedQuery(name=IRSTable.FILTER_IRS_BY_FIVE, query="SELECT a.id, a.remuneracao_mensal, a.cinco FROM IRSTable a WHERE a.n_titulares_rendimento = :n_titulares_rendimento")
	
})
	
public class IRSTable extends Entity_{
	private static final long serialVersionUID = 1L;
	
	public static final String ALL_IRS_VALUES = "getAll";
	public static final String ALL_IRS_IDS = "getAllIds";
	public static final String FILTER_IRS_BY_ZERO = "filterByZero";
	public static final String FILTER_IRS_BY_ONE = "filterByOne";
	public static final String FILTER_IRS_BY_TWO = "filterByTwo";
	public static final String FILTER_IRS_BY_THREE = "filterByThree";
	public static final String FILTER_IRS_BY_FOUR = "filterByFour";
	public static final String FILTER_IRS_BY_FIVE = "filterByFive";
	
	
	
	private int remuneracao_mensal;
	private double zero;
	private double um;
	private double dois;
	private double tres;
	private double quatro;
	private double cinco;
	private String n_titulares_rendimento;
	
	public IRSTable() {}

	public double getRemuneracao_mensal() {
		return remuneracao_mensal;
	}

	public void setRemuneracao_mensal(int remuneracao_mensal) {
		this.remuneracao_mensal = remuneracao_mensal;
	}

	public double getZero() {
		return zero;
	}

	public void setZero(double zero) {
		this.zero = zero;
	}

	public double getUm() {
		return um;
	}

	public void setUm(double um) {
		this.um = um;
	}

	public double getDois() {
		return dois;
	}

	public void setDois(double dois) {
		this.dois = dois;
	}

	public double getTres() {
		return tres;
	}

	public void setTres(double tres) {
		this.tres = tres;
	}

	public double getQuatro() {
		return quatro;
	}

	public void setQuatro(double quatro) {
		this.quatro = quatro;
	}

	public double getCinco() {
		return cinco;
	}

	public void setCinco(double cinco) {
		this.cinco = cinco;
	}

	public String getN_titulares_rendimento() {
		return n_titulares_rendimento;
	}

	public void setN_titulares_rendimento(String n_titulares_rendimento) {
		this.n_titulares_rendimento = n_titulares_rendimento;
	}

	

	
	
	

}
