package javaCourse.levelTwo.dao;

import java.util.List;

public interface PeriodicEditionDao<T> extends Dao<T> {
	List<T> findAll();
	void deleteById(int issn); 
}
