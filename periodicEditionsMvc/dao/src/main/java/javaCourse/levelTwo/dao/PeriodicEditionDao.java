package javaCourse.levelTwo.dao;

import java.util.List;

public interface PeriodicEditionDao<T> extends Dao<T> {
	List<T> findAll(int periodicalsNumber, int currentPage);

	List<T> findAll();

	Long getCount();

	void deleteById(int issn);

	T findById(int issn);
}
