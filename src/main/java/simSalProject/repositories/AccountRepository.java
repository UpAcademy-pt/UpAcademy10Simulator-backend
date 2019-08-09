package simSalProject.repositories;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import simSalProject.models.Account;
import simSalProject.models.AccountDTO;
import simSalProject.models.Account.AccountRole;


@Named("AccRep")
@RequestScoped
public class AccountRepository extends EntityRepository<Account>{

	
	public Class<Account> getEntityClass(){
		return Account.class;
	}

	@Override
	protected String getAllIds() {
		// TODO Auto-generated method stub
		return Account.ALL_ACC_IDS;
	}

	@Override
	protected String getAllValues() {
		// TODO Auto-generated method stub
		return Account.ALL_ACC_VALUES;
	}
	
	
	public List<Account> getAccountById (long id){
		TypedQuery<Account> query = entityManager.createNamedQuery(Account.GET_ACC_BY_ID, Account.class);
		query.setParameter("id", id);
		
		return query.getResultList();
	}

	
	public long getRoleCount (AccountRole role){
		TypedQuery<Long> query = entityManager.createNamedQuery(Account.GET_ROLE_COUNT, Long.class);
		query.setParameter("accountRole", role);
		
		return query.getSingleResult();
	}
	
	
	public boolean existsAccountbyEmail (String email){
		boolean result = false;
		TypedQuery<Account> query = entityManager.createNamedQuery(Account.GET_ACC_BY_EMAIL, Account.class);
		query.setParameter("email", email);
		
		
		if(query.getResultList().size()>0) {
			result = true;
		}
		return result;	
		}
	
	public AccountDTO accountToAccountDTO(Account myAccount) {
		AccountDTO myAccountDTO = new AccountDTO();
		myAccountDTO.setId(myAccount.getId());
		myAccountDTO.setEmail(myAccount.getEmail());
		return myAccountDTO;
	}
	
	public Account accountDTOToAccount (AccountDTO myAccountDTO) {
		long id = myAccountDTO.getId();
		Account myAccount = getAccountById(id);
		
		return myAccount;
		
	}
		
}