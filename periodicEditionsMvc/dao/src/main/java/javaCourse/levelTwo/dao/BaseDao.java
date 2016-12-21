package javaCourse.levelTwo.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * 
 * base CRUD operation with POJO
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

	@Override
	public T add(T t) {
		getSession().save(t);
		log.info("Save " + t);
		return (T) t;
	}

	@Override
	public void update(T t) {
		getSession().update(t);
		log.info("Update " + t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Serializable id) {
		T t = (T) getSession().get(getPersistentClass(), id);
		log.info("Get class by id: " + id);
		return t;
	}

	@Override
	public void delete(T t) {
		getSession().delete(t);
		log.info("Delete:" + t);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Class getPersistentClass() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
}
