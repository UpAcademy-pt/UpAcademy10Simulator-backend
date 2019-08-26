package simSalProject.business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import simSalProject.models.SimulationFields;
import simSalProject.repositories.SimulationsFieldsRepository;



public class SimulationsFieldsBusiness {

	@Inject
	SimulationsFieldsRepository simFieldsRepository;
	
	
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
//		simFieldsRepository.createEntity(baseSalary);
//		simFieldsRepository.createEntity(foodSubsidy);
//		simFieldsRepository.createEntity(phone);
//		simFieldsRepository.createEntity(vehicle);
//		simFieldsRepository.createEntity(healthInsurance);
//		simFieldsRepository.createEntity(workInsurance);
//		simFieldsRepository.createEntity(mobileNet);
//		simFieldsRepository.createEntity(zPass);
//		simFieldsRepository.createEntity(otherWithTA);
//		simFieldsRepository.createEntity(vehicleMaintenance);
//		simFieldsRepository.createEntity(otherWithoutTA);
//		simFieldsRepository.createEntity(otherAwards);
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
	
	@Transactional
	public String createSimulationFields(SimulationFields mySimulationField) {
			simFieldsRepository.createEntity(mySimulationField);
			return "Created";		
	}
	
	@Transactional
	public String editSimulationFields(SimulationFields mySimulationFieldsToEdit) {
			simFieldsRepository.editEntity(mySimulationFieldsToEdit);
			return "Edited";
	}
	
	@Transactional
	public void removeSimulationFields(SimulationFields mySimulationFields) {
			simFieldsRepository.removeEntity(mySimulationFields);
		
	}
	
	public List<SimulationFields> consultSimulationField(String name) {
		List<SimulationFields> mySimulationField = simFieldsRepository.getSimulationFieldsByName(name);
		return mySimulationField;
	}
	
	public List<Long> getAllIds() {
		return new ArrayList<Long>(simFieldsRepository.allIds());
	}
	
	public List<SimulationFields> getAllValues() {
		return simFieldsRepository.allValues();
	}

	public List<SimulationFields> getSimulationFieldsByName(String name) {
		// TODO Auto-generated method stub
		return simFieldsRepository.getSimulationFieldsByName(name);
	}
	
	public long getSimFieldsCount(String name) {
		
		return simFieldsRepository.getSimFieldsCount(name);
	}
	
	public List<SimulationFields> getAllSimValues() {
		return simFieldsRepository.getAllSimulationFields();
	}
	
	
}
