package javaCourse.levelTwo.services;

import java.util.List;

import javaCourse.levelTwo.entity.PeriodicEdition;

public interface PeriodicEditionService <T> extends Service<T> {
	List<T> findAll();
	void deleteById(int issn);
	PeriodicEdition create (PeriodicEdition periodicEdition);
	}




