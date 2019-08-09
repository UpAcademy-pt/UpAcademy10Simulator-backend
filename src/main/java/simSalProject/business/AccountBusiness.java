package simSalProject.business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import simSalProject.Utils.PasswordUtils;
import simSalProject.Utils.SendMail;
import simSalProject.models.Account;
import simSalProject.models.Account.AccountRole;
import simSalProject.models.AccountDTO;
import simSalProject.repositories.AccountRepository;

@Named("AccBus")
@RequestScoped
public class AccountBusiness  {
	
	
	@Inject
	@Named("AccRep")
	AccountRepository ACC_DB;
	
	public String createAccount(String email) {
		if (!isEmailValid(email)) {
			return "The email is not well written";
		}
		
		if (ACC_DB.verifyEmail(email)) {
			return "This Account already exists";
		} else {
		
		Account myAccount = new Account();
		myAccount.setEmail(email);
		
		String randomPassword = SendMail.createRandom();
		myAccount.setSalt(PasswordUtils.generateSalt(2).get());
		String randomSalt = myAccount.getSalt();
		myAccount.setPassword(PasswordUtils.hashPassword(randomPassword, randomSalt).get());
		
		try {
			SendMail.sendMail(email, randomPassword);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myAccount.setAccRole(AccountRole.USER);
		ACC_DB.createEntity(myAccount);
		return "Account Created";
		}
		
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
		if (ACC_DB.getRoleCount(AccountRole.ADMIN) == 0){
			Account initAccount = new Account();
			initAccount.setEmail("admin@admin.com");
			String salt = PasswordUtils.generateSalt(2).get();
			initAccount.setPassword(PasswordUtils.hashPassword("admin", salt ).get());
			initAccount.setAccRole(AccountRole.ADMIN);
			initAccount.setSalt(salt);
			message = createAdmin(initAccount);
			
		} else {
			message = "ADMIN already exists";
		}
		
		return message;
	}
	
	public AccountDTO login(Account myAccount) {
		Account accountInDB = ACC_DB.getAccountByEmail(myAccount.getEmail());
		AccountDTO myAccountDTO = new AccountDTO();
		if (!isEmailValid(myAccount.getEmail())) {
			
			myAccountDTO.setMessage("The email you've written is not an email");

			return myAccountDTO;
		}
		if (ACC_DB.verifyEmail(myAccount.getEmail())) {

			String salt = ACC_DB.getSalt(myAccount.getEmail());
			String hashPassword = ACC_DB.getPassword(myAccount.getEmail());

			if (PasswordUtils.verifyPassword(myAccount.getPassword(), hashPassword, salt)) {
				myAccountDTO.setEmail(myAccount.getEmail());
				myAccountDTO.setId(accountInDB.getId());
				myAccountDTO.setAccountRole(Account.AccountRole.USER.toString());
				myAccountDTO.setMessage("Welcome");
				return myAccountDTO;
			} else {
				myAccountDTO.setMessage("Not a valid Password");
				return myAccountDTO;
			}
		} else {
			myAccountDTO.setMessage("That email is not registered");
			return myAccountDTO;
		}
	}
	
	
	// Code to verify if the email is well written //
	public boolean isEmailValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"; 
		Pattern pat = Pattern.compile(emailRegex);
		
		if (email.equals("")) {
			return false;
		}
		boolean teste = pat.matcher(email).matches();
	
		return teste;
		 
	}
	
	
}
