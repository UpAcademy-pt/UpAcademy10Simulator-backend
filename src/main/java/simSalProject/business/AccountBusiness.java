package simSalProject.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.Utils.SendMail;
import simSalProject.models.Account;
import simSalProject.models.Account.AccountRole;
import simSalProject.repositories.AccountRepository;

@Named("AccBus")
@RequestScoped
public class AccountBusiness  {
	
	
	@Inject
	@Named("AccRep")
	AccountRepository ACC_DB;
	
	
	public String createAccount(Account myAccount) {
		if (ACC_DB.existsAccountbyEmail(myAccount.getEmail())) {
			return "This Account already exists";
		} else if (!ACC_DB.existsAccountbyEmail(myAccount.getEmail())) {
		String randomPassword = SendMail.createRandom();
		myAccount.setPassword(randomPassword);
		try {
			SendMail.sendMail(myAccount.getEmail(), randomPassword);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myAccount.setAccRole(AccountRole.USER);
		ACC_DB.createEntity(myAccount);
		return "Created";
		}
		return null;
	}

	public String createAdmin(Account adminAccount) {
		ACC_DB.createEntity(adminAccount);
		return "ADMIN didn't exist, ADMIN created with default credentials";
	}
	
	
	public Account consultAccount(long id) {
		Account myAccount = ACC_DB.consultEntity(id);
		return myAccount;
	}
	
	public void editAccount(long id, Account myAccountToEdit) {
		if (myAccountToEdit.getAccRole() != AccountRole.ADMIN) {
			ACC_DB.editEntity(myAccountToEdit);
		}
	}
	
	public void removeAccount(Account myAccount) {
		if (myAccount.getAccRole() != AccountRole.ADMIN) {
			ACC_DB.removeEntity(myAccount);
		}
	}
	
	public List<Long> getAllIds() {
		return new ArrayList<Long>(ACC_DB.allIds());
	}
	
	public Collection<Account> getAllValues() {
		return ACC_DB.allValues();
	}
	
	
	
	public String initDataBase() {
		
		String message = "";
		//0 is ENUM(0), which is ADMIN
		if (ACC_DB.getRoleCount(AccountRole.ADMIN) == 0){
			Account initAccount = new Account();
			initAccount.setEmail("admin@admin.com");
			initAccount.setPassword("admin");
			initAccount.setAccRole(AccountRole.ADMIN);
			message = createAdmin(initAccount);
			
		} else {
			message = "ADMIN already exists";
		}
		
		return message;
	}
	
	public String login() {
		
		
		
		return "";
		
	}
	
	
}
