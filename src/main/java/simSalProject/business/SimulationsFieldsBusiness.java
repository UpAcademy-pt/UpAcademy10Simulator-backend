package simSalProject.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.models.SimulationFields;
import simSalProject.repositories.SimulationsFieldsRepository;


@Named("SimFieldsBus")
@RequestScoped
public class SimulationsFieldsBusiness {

	@Inject
	@Named("SimFieldsRep")
	SimulationsFieldsRepository SIMF_DB;
	
	
//	public String initDataBase() {
//		List <SimulationFields> fields = new ArrayList();
//		SimulationFields baseSalary = new SimulationFields("baseSalary",0,0,0,0,0,0);
//		SimulationFields foodSubsidy = new SimulationFields("foodSubsidy",0,0,0,0,0,0);
//		SimulationFields phone = new SimulationFields("phone",0,0,0,0,0,0);
//		SimulationFields vehicle = new SimulationFields("vehicle",0,0,0,0,0,0);
//		SimulationFields healthInsurance = new SimulationFields("healthInsurance",0,0,0,0,0,0);
//		SimulationFields workInsurance = new SimulationFields("workInsurance",0,0,0,0,0,0);
//		SimulationFields mobileNet = new SimulationFields("mobileNet",0,0,0,0,0,0);
//		SimulationFields zPass = new SimulationFields("zPass",0,0,0,0,0,0);
//		SimulationFields otherWithTA = new SimulationFields("otherWithTA",0,0,0,0,0,0);
//		SimulationFields vehicleMaintenance = new SimulationFields("vehicleMaintenance",0,0,0,0,0,0);
//		SimulationFields otherWithoutTA = new SimulationFields("otherWithoutTA",0,0,0,0,0,0);
//		SimulationFields otherAwards = new SimulationFields("otherAwards",0,0,0,0,0,0);
//		
//		
//		SIMF_DB.createEntity(baseSalary);
//		SIMF_DB.createEntity(foodSubsidy);
//		SIMF_DB.createEntity(phone);
//		SIMF_DB.createEntity(vehicle);
//		SIMF_DB.createEntity(healthInsurance);
//		SIMF_DB.createEntity(workInsurance);
//		SIMF_DB.createEntity(mobileNet);
//		SIMF_DB.createEntity(zPass);
//		SIMF_DB.createEntity(otherWithTA);
//		SIMF_DB.createEntity(vehicleMaintenance);
//		SIMF_DB.createEntity(otherWithoutTA);
//		SIMF_DB.createEntity(otherAwards);
//		return "Inited Fields";
				
//R01 - Salário base	15							Não	Sim	Sim	Não	Não	Não
//R02 - Subsídio de Alimentação	11				Sim	Não	Não	Não	Não	Não
//R03 - Telemóvel	12								Não	Não	Não	Não	Sim	Não
//R04 - Renting Viatura	12						Não	Não	Não	Sim	Sim	Não
//R05 - Combustível viatura	12					Não	Não	Não	Sim	Sim	Não
//R06 - Seguro de Trabalho	12					Não	Não	Não	Não	Sim	Não
//R07 - Seguro de Saúde	12						Não	Não	Não	Não	Sim	Não
//R08 - Banda larga em casa	12					Não	Não	Não	Não	Sim	Não
//R09 - Via verde	12								Não	Não	Não	Sim	Sim	Não
//R10 - Outras despesas com trib. Autonoma	12	Não	Não	Não	Sim	Não	Não
//R11 - Manutenção da viatura	12					Não	Não	Não	Sim	Sim	Não
//R12 - Outras despesas sem trib. Autonoma	12	Não	Não	Não	Não	Não	Não
//R13 - Outros Prémios	12						Não	Sim	Não	Não	Não	Não

		
//	}
//	public String manageSimulationFields(SimulationFields mySimulationField) {
//		if
//		
//		return null;
//		
//	}
	
	public String createSimulationFields(SimulationFields mySimulationField) {
			SIMF_DB.createEntity(mySimulationField);
			return "Created";		
	}
	
	public String editSimulationFields(SimulationFields mySimulationFieldsToEdit) {
			SIMF_DB.editEntity(mySimulationFieldsToEdit);
			return "Edited";
	}
	
	public void removeSimulationFields(SimulationFields mySimulationFields) {
			SIMF_DB.removeEntity(mySimulationFields);
		
	}
	
	public List<SimulationFields> consultSimulationField(String name) {
		List<SimulationFields> mySimulationField = SIMF_DB.getSimulationFieldsByName(name);
		return mySimulationField;
	}
	
	public List<Long> getAllIds() {
		return new ArrayList<Long>(SIMF_DB.allIds());
	}
	
	public List<SimulationFields> getAllValues() {
		return SIMF_DB.allValues();
	}

	public List<SimulationFields> getSimulationFieldsByName(String name) {
		// TODO Auto-generated method stub
		return SIMF_DB.getSimulationFieldsByName(name);
	}
	
	public long getSimFieldsCount(String name) {
		
		return SIMF_DB.getSimFieldsCount(name);
	}
	
	public List<SimulationFields> getAllSimValues() {
		return SIMF_DB.getAllSimulationFields();
	}
	
	
}
