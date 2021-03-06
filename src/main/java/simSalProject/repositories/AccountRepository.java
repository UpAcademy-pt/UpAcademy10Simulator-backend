package simSalProject.repositories;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.TypedQuery;

import simSalProject.models.Account;
import simSalProject.models.Account.AccountRole;
import simSalProject.models.AccountDTO;


public class AccountRepository extends EntityRepository<Account> {

	public Class<Account> getEntityClass() {
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

	public List<Account> getAccountById(long id) {
		TypedQuery<Account> query = entityManager.createNamedQuery(Account.GET_ACC_BY_ID, Account.class);
		query.setParameter("id", id);

		return query.getResultList();
	}

	public long getAccCountByEmail(String email) {
		TypedQuery<Long> query = entityManager.createNamedQuery(Account.GET_ACC_COUNT_BY_EMAIL, Long.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

	public List<Account> getAccountByEmail(String email) {
		TypedQuery<Account> query = entityManager.createNamedQuery(Account.GET_ACC_BY_EMAIL, Account.class);
		query.setParameter("email", email);
		return query.getResultList();
	}

//	public Account verifyEmailAndPass(String email, String password) {
//		TypedQuery<Account> query = entityManager.createNamedQuery(Account.VERIFY_EMAIL_PASS, Account.class);
//		query.setParameter("email", email);
//		query.setParameter("password", password);
//		return query.getSingleResult();
//	}

	public boolean verifyEmail(String email) {
		TypedQuery<Long> query = entityManager.createNamedQuery(Account.VERIFY_EMAIL, Long.class);
		query.setParameter("email", email);
		if (query.getSingleResult() == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**********************************************************************************************************
	 * 
	 * @param email
	 * @return Password
	 */

	public String getPassword(String email) {
		TypedQuery<String> query = entityManager.createNamedQuery(Account.VERIFY_PASSWORD, String.class);
		query.setParameter("email", email);
		return query.getSingleResult();

	}

	/**********************************************************************************************************
	 * 
	 * @param email
	 * @return salt
	 */

	public String getSalt(String email) {
		TypedQuery<String> query = entityManager.createNamedQuery(Account.VERIFY_SALT, String.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

	public long getIdWithEmail(String email) {
		TypedQuery<Long> query = entityManager.createNamedQuery(Account.GET_ID_WITH_EMAIL, Long.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

	public long getRoleCount(AccountRole role) {
		TypedQuery<Long> query = entityManager.createNamedQuery(Account.GET_ROLE_COUNT, Long.class);
		query.setParameter("accountRole", role);

		return query.getSingleResult();
	}

	public boolean existsAccountbyEmail(String email) {
		boolean result = false;
		TypedQuery<Account> query = entityManager.createNamedQuery(Account.GET_ACC_BY_EMAIL, Account.class);
		query.setParameter("email", email);
		if (query.getResultList().size() > 0) {
			result = true;
		}
		return result;
	}

	public AccountDTO accountToAccountDTO(Account myAccount) {
		AccountDTO myAccountDTO = new AccountDTO();
		myAccountDTO.setId(myAccount.getId());
		myAccountDTO.setName(myAccount.getName());
		myAccountDTO.setEmail(myAccount.getEmail());
		return myAccountDTO;
	}

	public Account accountDTOToAccount(AccountDTO myAccountDTO) {
		Account myAccount = getAccountById(myAccountDTO.getId()).get(0);
		return myAccount;

	}
	
	public long getAccCount() {
		TypedQuery<Long> query = entityManager.createNamedQuery(Account.GET_ACC_COUNT, Long.class);
		return query.getSingleResult();
	}
	
	public long getAccCountById(long id) {
		TypedQuery<Long> query = entityManager.createNamedQuery(Account.GET_ACC_COUNT_BY_ID, Long.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	public List<Account> getAccWithFilterSimsBetweenDates(String email, LocalDateTime startDate, LocalDateTime endDate){
		TypedQuery<Account> query = entityManager.createNamedQuery(Account.GET_SIMS_BETWEEN_DATES_FOR_ACCOUNT, Account.class);
		query.setParameter("email", email);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		return query.getResultList();
	}
	
	public List<Account> getAccsWithFilterSimsBetweenDates(LocalDateTime startDate, LocalDateTime endDate){
		TypedQuery<Account> query = entityManager.createNamedQuery(Account.GET_SIMS_BETWEEN_DATES_FOR_ALL_ACCOUNTS, Account.class);
		query.setParameter("startDate", startDate);
		query.setParameter("endDate", endDate);
		return query.getResultList();
	}
	
	public List<Account> getSimsForAllAccs(){
		TypedQuery<Account> query = entityManager.createNamedQuery(Account.GET_SIMS_FOR_ALL_ACCOUNTS, Account.class);
		return query.getResultList();
	}

}