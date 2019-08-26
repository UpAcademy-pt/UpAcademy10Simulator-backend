package simSalProject.business;

import java.io.IOException;
import java.util.ArrayList;
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
import simSalProject.models.Colaborator;
import simSalProject.repositories.AccountRepository;


public class AccountBusiness {

	@Inject
	AccountRepository accRepository;
	
	@Inject
	ColaboratorBusiness colabRepository;

	public String createAccount(AccountDTO myAccountDTO) {
		if (!isEmailValid(myAccountDTO.getEmail())) {
			return "The email is not well written";
		}
		if (accRepository.verifyEmail(myAccountDTO.getEmail())) {
			return "This Account already exists";
		} else {
		
		Account myAccount = new Account();
		myAccount.setName(myAccountDTO.getName());
		myAccount.setEmail(myAccountDTO.getEmail());
		String randomPassword = SendMail.createRandom();
		myAccount.setSalt(PasswordUtils.generateSalt(2).get());
		String randomSalt = myAccount.getSalt();
		myAccount.setPassword(PasswordUtils.hashPassword(randomPassword, randomSalt).get());
		
		try {
			SendMail.sendMail(myAccountDTO.getEmail(), randomPassword);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myAccount.setAccountRole(AccountRole.USER);
		accRepository.createEntity(myAccount);
		return "Account Created";
		}
		
	}
	public String changePassword(Account myAccountToEdit) {
		String salt = PasswordUtils.generateSalt(2).get();
		Account currentAccount = accRepository.getAccountByEmail(myAccountToEdit.getEmail()).get(0);
		currentAccount.setEmail(myAccountToEdit.getEmail());
		currentAccount.setSalt(salt);
		currentAccount.setPassword(PasswordUtils.hashPassword(myAccountToEdit.getPassword(), salt).get());
		
		accRepository.editEntity(currentAccount);
		return "Welcome user with new Password";
	}
	

	public String createAdmin(Account adminAccount) {
		accRepository.createEntity(adminAccount);
		return "ADMIN didn't exist, ADMIN created with default credentials";
	}

	public Account consultAccount(long id) {
		Account myAccount = accRepository.consultEntity(id);
		return myAccount;
	}

	public void editAccount(Account myAccountToEdit) {
		if (myAccountToEdit.getAccountRole() == AccountRole.ADMIN) return;
		accRepository.editEntity(myAccountToEdit);
	}

	public String removeAccount(Account myAccount) {
		if (myAccount.getAccountRole() != AccountRole.ADMIN) {
			List<Colaborator> colaborators = myAccount.getColaborators();
			for (Colaborator colaborator : colaborators) {
				colaborator.setAccount(null);
				colabRepository.editColaborator(colabRepository.ColaboratorToColaboratorDTO(colaborator));
				colabRepository.removeColaborator(colaborator);
			}
			myAccount.setColaborators(null);
			accRepository.editEntity(myAccount);
			accRepository.removeEntity(myAccount);
			return "Account Removed";
		} else {
			return "ADMIN não pode ser removido";
		}
		
	}

	public List<Long> getAllIds() {
		return new ArrayList<Long>(accRepository.allIds());
	}

	public List<AccountDTO> getAllValues() {
		List<Account> accounts = accRepository.allValues();
		List<AccountDTO> accountsDTO = new ArrayList<AccountDTO>();
		for (Account account : accounts) {
			if(account.getAccountRole() == Account.AccountRole.USER) {
				accountsDTO.add(accountToAccountDTO(account));
			}
		}
		return accountsDTO;
	}

	public String initDataBase() {
		String message = "";
		if (accRepository.getRoleCount(AccountRole.ADMIN) == 0) {
			Account initAccount = new Account();
			initAccount.setEmail("admin@admin.com");
			String salt = PasswordUtils.generateSalt(2).get();
			initAccount.setPassword(PasswordUtils.hashPassword("admin", salt).get());
			initAccount.setAccountRole(AccountRole.ADMIN);
			initAccount.setSalt(salt);
			message = createAdmin(initAccount);

		} else {
			message = "ADMIN already exists";
		}

		return message;
	}
	

	public AccountDTO login(Account myAccount) {
		List<Account> accountInDB = accRepository.getAccountByEmail(myAccount.getEmail());
		AccountDTO myAccountDTO = accRepository.accountToAccountDTO(myAccount);
		if (myAccount.getPassword() == null) {
			myAccountDTO.setMessage("You have to write the password!");
			return myAccountDTO;
		}

		if (!isEmailValid(myAccount.getEmail())) {

			myAccountDTO.setMessage("Email not valid");

			return myAccountDTO;
		}
		if (accRepository.verifyEmail(myAccount.getEmail())) {

			String salt = accountInDB.get(0).getSalt();
			String hashPassword = accountInDB.get(0).getPassword();

			if (PasswordUtils.verifyPassword(myAccount.getPassword(), hashPassword, salt)) {
				
				myAccountDTO.setEmail(myAccount.getEmail());
				myAccountDTO.setId(accountInDB.get(0).getId());
				if (accountInDB.get(0).getAccountRole() == Account.AccountRole.ADMIN) {
					myAccountDTO.setAccountRole(Account.AccountRole.ADMIN.toString());
				} 
				else {
					myAccountDTO.setAccountRole(Account.AccountRole.USER.toString());
				}
				myAccountDTO.setMessage("Welcome");
				return myAccountDTO;
			} else {
				myAccountDTO.setMessage("Invalid password");
				return myAccountDTO;
			}
		} else {
			myAccountDTO.setMessage("Email is not registered");
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
	
	public long getAccCountByEmail(String email) {
		return accRepository.getAccCountByEmail(email);
	}
	
	public List<Account> getAccountByEmail (String email){
		return accRepository.getAccountByEmail(email);
	}
	
	public List<AccountDTO> accountToAccountDTO(List<Account> accounts){
		List<AccountDTO> accountsDTO = new ArrayList<AccountDTO>();
		for (Account account : accounts) {
			accountsDTO.add(accountToAccountDTO(account));
		}
		return accountsDTO;
	}
	
	public AccountDTO accountToAccountDTO(Account myAccount) {
		AccountDTO myAccountDTO = accRepository.accountToAccountDTO(myAccount);
		myAccountDTO.setColaboratorsDTO(colabRepository.ColaboratorToColaboratorDTO(myAccount.getColaborators()));
		return myAccountDTO;
	}

	public Account accountDTOToAccount(AccountDTO myAccountDTO) {
		Account myAccount = accRepository.getAccountById(myAccountDTO.getId()).get(0);
		return myAccount;
	}
	
	public long getAccCount() {
		return accRepository.getAccCount();
	}
	
	
}
