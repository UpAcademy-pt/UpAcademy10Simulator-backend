package simSalProject.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Simulation")
@Table(name = "simulation")
@NamedQueries({ @NamedQuery(name = Simulation.ALL_SIM_IDS, query = "SELECT s.id FROM Simulation s"),
		@NamedQuery(name = Simulation.ALL_SIM_VALUES, query = "SELECT s FROM Simulation s"),
		@NamedQuery(name = Simulation.GET_SIM_BY_ID, query = "SELECT s FROM Simulation s WHERE s.id = :id"),
		@NamedQuery(name = Simulation.GET_SIM_COUNT_BY_ID, query = "SELECT count(s) FROM Simulation s WHERE s.id = :id"),
		@NamedQuery(name = Simulation.GET_SIM_BY_COLAB_ID, query = "SELECT s FROM Simulation s WHERE s.colaborator = :colaborator")

})
public class Simulation extends Entity_ {

	private static final long serialVersionUID = 1L;
	public static final String ALL_SIM_IDS = "getAllSimIds";
	public static final String ALL_SIM_VALUES = "getAllSims";
	public static final String GET_SIM_BY_ID = "getSimByID";
	public static final String GET_SIM_COUNT_BY_ID = "getSimCountById";
	public static final String GET_SIM_BY_COLAB_ID = "getSimulationsByColabId";
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Colaborator colaborator;
	
	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, mappedBy = "simulation")
	private List<SimFieldsData> simFieldsData = new ArrayList<>();
	
	
	private Date date;
	
	public Simulation() {
		super();
	}

	public Colaborator getColaborator() {
		return colaborator;
	}

	public void setColaborator(Colaborator colaborator) {
		this.colaborator = colaborator;
	}

	public List<SimFieldsData> getSimFieldsData() {
		return simFieldsData;
	}

	public void setSimFieldsData(List<SimFieldsData> simFieldsData) {
		this.simFieldsData = simFieldsData;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	
	
	
}
