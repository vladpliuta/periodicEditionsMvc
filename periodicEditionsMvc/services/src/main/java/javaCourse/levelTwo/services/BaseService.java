package javaCourse.levelTwo.services;

import java.io.Serializable;

import org.apache.log4j.Logger;

import javaCourse.levelTwo.dao.Dao;
import javaCourse.levelTwo.dao.exceptions.DaoException;

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

	public void saveOrUpdate(T t) {
		try {
			baseDao.saveOrUpdate(t);
			log.info("Save or update " + t);
		} catch (DaoException e) {
			log.error("Error save or update " + t + e);
		}
	}

	public T get(Serializable id) {
		T t = null;
		try {
			t = baseDao.get(id);
			log.info("Get class by id: " + id);
		} catch (DaoException e) {
			log.error("Error get " + e);
		}
		return t;
	}

	public void delete(T t) {
		try {
			baseDao.delete(t);
			log.info("Delete:" + t);
		} catch (DaoException e) {
			log.error("Error delete" + e);
		}
	}
}
