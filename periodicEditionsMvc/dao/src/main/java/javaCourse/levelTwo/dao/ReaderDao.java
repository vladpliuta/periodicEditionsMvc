package javaCourse.levelTwo.dao;

import java.util.List;

public interface ReaderDao<T> extends Dao<T> {
	List<T> findAll();

	T findByLogin(String login);
}
