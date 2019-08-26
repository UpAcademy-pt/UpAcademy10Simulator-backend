package simSalProject.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import simSalProject.models.Entity_;



public abstract class EntityRepository<T extends Entity_> {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	protected EntityManager entityManager;
	

	
	public T createEntity(T entity) {
		entityManager.persist(entity);
		return entity;
	}
	
	
	public T editEntity(T entity) {
		return entityManager.merge(entity);
	}
	
	public T consultEntity(long id) {
		return entityManager.find(getEntityClass(), id);
		
	}
	
	public void removeEntity(T entity) {
		System.out.println("Entrou no remove");
		T managedEntity = entityManager.find(getEntityClass(), entity.getId());
		entityManager.remove(managedEntity);
	}
	
	protected abstract String getAllIds();
	public List<Long> allIds(){
		return entityManager.createNamedQuery(getAllIds(), Long.class).getResultList();
	}
	
	protected abstract String getAllValues();
	public List<T> allValues(){
		return entityManager.createNamedQuery(getAllValues(), getEntityClass()).getResultList();
	}
	
	protected abstract Class<T> getEntityClass();

	
}