package javaCourse.levelTwo.dao;

import org.apache.log4j.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javaCourse.levelTwo.dao.exceptions.DaoException;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
/**
 * 
 *base CRUD operation with POJO
 * 
 * @author Vladimir Pliuta
 *
 */
@Repository
public class BaseDao<T> implements Dao<T> {
	private static Logger log = Logger.getLogger(BaseDao.class);
	private SessionFactory sessionFactory;

	@Autowired
	public BaseDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void saveOrUpdate(T t) throws DaoException {
		try {
			getSession().saveOrUpdate(t);
			log.info("Save or update " + t);
		} catch (HibernateException e) {
			log.error("Error save or update " + t + " in Dao" + e);
			throw new DaoException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public T get(Serializable id) throws DaoException {
		T t;
		try {
			t = (T) getSession().get(getPersistentClass(), id);
			log.info("Get class by id: " + id);
		} catch (HibernateException e) {
			log.error("Error get " + getPersistentClass() + " in Dao" + e);
			throw new DaoException(e);
		}
		return t;
	}

	public void delete(T t) throws DaoException {
		try {
			getSession().delete(t);
			log.info("Delete:" + t);
		} catch (HibernateException e) {
			log.error("Error delete " + getPersistentClass() + " in Dao" + e);
			throw new DaoException(e);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Class getPersistentClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
