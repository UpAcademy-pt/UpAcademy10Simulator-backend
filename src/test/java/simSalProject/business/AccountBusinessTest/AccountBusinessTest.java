package simSalProject.business.AccountBusinessTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import simSalProject.business.AccountBusiness;
import simSalProject.models.AccountDTO;



public class AccountBusinessTest {

	
	AccountBusiness accountBusiness = new AccountBusiness();
	
	
	
	@Disabled
	@DisplayName("Create account should return a string Account Created")
	public void createAccountTest() {
		AccountDTO myAccountDTO = new AccountDTO();
		myAccountDTO.setEmail("joaoltxs@hotmail.com");
		myAccountDTO.setName("John");
		assertEquals("Account Created", accountBusiness.createAccount(myAccountDTO));
	}
	
}
