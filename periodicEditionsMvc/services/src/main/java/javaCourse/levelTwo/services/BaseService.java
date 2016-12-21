package javaCourse.levelTwo.services;

import java.io.Serializable;

import org.apache.log4j.Logger;

import javaCourse.levelTwo.dao.Dao;

/**
 * 
 *
 * 
 * @author Vladimir Pliuta
 *
 */

public class BaseService<T> implements Service<T> {
	private static Logger log = Logger.getLogger(BaseService.class);
	private Dao<T> baseDao;

	public BaseService() {
	}

	public BaseService(Dao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void add(T t) {
		baseDao.add(t);
		log.info("Save " + t);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
		log.info("Update " + t);
	}

	@Override
	public T get(Serializable id) {
		T t = baseDao.get(id);
		log.info("Get class by id: " + id);
		return t;
	}

	public void delete(T t) {
		baseDao.delete(t);
		log.info("Delete: " + t);
	}
}
