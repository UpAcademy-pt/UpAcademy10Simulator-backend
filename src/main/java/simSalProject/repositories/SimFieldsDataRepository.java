package simSalProject.repositories;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import simSalProject.models.SimFieldsData;
import simSalProject.models.SimFieldsDataDTO;
import simSalProject.models.Simulation;


@Named("SimFieldsDataRep")
@RequestScoped
public class SimFieldsDataRepository extends EntityRepository<SimFieldsData> {

	@Override
	protected String getAllIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getAllValues() {
		// TODO Auto-generated method stub
		return SimFieldsData.ALL_SIMFIELDSDATA_VALUES;
	}

	@Override
	protected Class<SimFieldsData> getEntityClass() {
		// TODO Auto-generated method stub
		return SimFieldsData.class;
	}
	
	public long getSimFieldsDataCountById(long id) {
		TypedQuery<Long> query = entityManager.createNamedQuery(SimFieldsData.GET_SIMFIELDSDATA_COUNT_BY_ID, Long.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	public List<SimFieldsData> getSimFieldsDataById(long id) {
		TypedQuery<SimFieldsData> query = entityManager.createNamedQuery(SimFieldsData.GET_SIM_FIELDS_DATA_BY_ID, SimFieldsData.class);
		query.setParameter("id", id);
		
		return query.getResultList();
	}
	
	public List<SimFieldsData> getFieldsDataBySimId(Simulation simulation){
		TypedQuery<SimFieldsData> query = entityManager.createNamedQuery(SimFieldsData.GET_SIM_FIELDS_DATA_BY_SIM_ID, SimFieldsData.class);
		query.setParameter("simulation", simulation);
		
		return query.getResultList();
	}
	
	
	
	
	public SimFieldsDataDTO SimFieldsDataToSimFieldsDataDTO(SimFieldsData mySimFieldsData) {
		SimFieldsDataDTO mySimFieldsDataDTO = new SimFieldsDataDTO();
		mySimFieldsDataDTO.setId(mySimFieldsData.getId());
		return mySimFieldsDataDTO;
	}
	
	

	public SimFieldsData SimFieldsDataDTOToSimFieldsData(SimFieldsDataDTO mySimFieldsDataDTO) {
		SimFieldsData mySimFieldsData = getSimFieldsDataById(mySimFieldsDataDTO.getId()).get(0);
		return mySimFieldsData;
	}
	
	
	
}
