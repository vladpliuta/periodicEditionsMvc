package javaCourse.levelTwo.dao;

import java.io.Serializable;

import javaCourse.levelTwo.dao.exceptions.DaoException;

public interface Dao<T> {
	void saveOrUpdate(T t) throws DaoException;

	T get(Serializable id) throws DaoException;

	void delete(T t) throws DaoException;

}
