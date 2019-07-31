package simSalProject.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import simSalProject.models.Entity_;


@Transactional
public abstract class EntityRepository<T extends Entity_> {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	protected EntityManager entityManager;
	

	
	public void createEntity(T entity) {
		entityManager.persist(entity);
	}
	
	
	public void editEntity(T entity) {
		entityManager.merge(entity);
	}
	
	public T consultEntity(long id) {
		return entityManager.find(getEntityClass(), id);
		
	}
	
	public void removeEntity(T entity) {
		T managedEntity = entityManager.find(getEntityClass(), entity.getId());
		entityManager.remove(managedEntity);
	}
	
	protected abstract Class<T> getEntityClass();

	
}