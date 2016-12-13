package javaCourse.levelTwo.services;

import java.util.List;


public interface PeriodicEditionService <T> extends Service<T> {
	List<T> findAll();
}




