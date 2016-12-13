package javaCourse.levelTwo.dao;

import java.util.List;

import javaCourse.levelTwo.dao.exceptions.DaoException;

public interface SubscriptionDao<T> extends Dao<T> {
	List<T> findAll() throws DaoException;
}
