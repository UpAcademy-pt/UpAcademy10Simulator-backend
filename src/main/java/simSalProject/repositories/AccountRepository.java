package simSalProject.repositories;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import simSalProject.models.Account;
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
	
	public List<Account> getUserById (long id){
		TypedQuery<Account> query = entityManager.createNamedQuery(Account.GET_ACC_BY_ID, Account.class);
		query.setParameter("id", id);
		
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

	public long getRoleCount (AccountRole role){
		TypedQuery<Long> query = entityManager.createNamedQuery(Account.GET_ROLE_COUNT, Long.class);
		query.setParameter("accountRole", role);
		
		return query.getSingleResult();
	}

}