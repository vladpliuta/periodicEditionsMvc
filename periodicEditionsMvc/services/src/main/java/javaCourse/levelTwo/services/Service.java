package javaCourse.levelTwo.services;

import java.io.Serializable;


public interface Service<T> {
	void saveOrUpdate(T t);

	T get(Serializable id);

	void delete(T t);
}
