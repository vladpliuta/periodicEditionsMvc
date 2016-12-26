package javaCourse.levelTwo.services;

import java.util.List;

import javaCourse.levelTwo.entity.PeriodicEdition;

public interface PeriodicEditionService<T> extends Service<T> {
	List<T> findAll(int periodicalsNumber, int currentPage);

	List<T> findAll();

	int getPageCount(int periodicalsNumber);

	void deleteById(int issn);
	
	T findById(int issn);

	PeriodicEdition create(PeriodicEdition periodicEdition);
}
