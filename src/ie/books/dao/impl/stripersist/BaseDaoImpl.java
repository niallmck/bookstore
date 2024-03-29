package ie.books.dao.impl.stripersist;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.stripesstuff.stripersist.Stripersist;

import ie.books.dao.Dao;
import ie.books.model.Customer;

public abstract class BaseDaoImpl<T, ID extends Serializable> implements
		Dao<T, ID> {
	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public List<T> read() {
		return Stripersist.getEntityManager()
				.createQuery("from " + entityClass.getName()).getResultList();
	}

	public T read(ID id) {
		return Stripersist.getEntityManager().find(entityClass, id);
	}

	public void save(T object) {
		Stripersist.getEntityManager().persist(object);
	}

	public void delete(T object) {
		Stripersist.getEntityManager().remove(object);
	}

	public void commit() {
		Stripersist.getEntityManager().getTransaction().commit();
	}

	public T findBy(String fieldName, Object value) {
		Query query = Stripersist.getEntityManager()
				.createQuery(getQuery(fieldName, null))
				.setParameter(fieldName, value);
		return getSingleResult(query);
	}

	public T findBy(String fieldName, Object value, Customer customer) {
		Query query = Stripersist.getEntityManager()
				.createQuery(getQuery(fieldName, customer))
				.setParameter(fieldName, value)
				.setParameter("customer", customer);
		return getSingleResult(query);
	}

	protected Class<T> getEntityClass() {
		return entityClass;
	}

	private String getQuery(String fieldName, Customer customer) {
		String query = "from " + entityClass.getName() + " t " + "where t."
				+ fieldName + " = :" + fieldName;
		if (customer == null) {
			return query;
		}
		return query + " and t.customer = :customer";
	}

	@SuppressWarnings("unchecked")
	private T getSingleResult(Query query) {
		try {
			return (T) query.getSingleResult();
		} catch (NonUniqueResultException exc) {
			return (T) query.getResultList().get(0);
		} catch (NoResultException exc) {
			return null;
		}
	}
}
