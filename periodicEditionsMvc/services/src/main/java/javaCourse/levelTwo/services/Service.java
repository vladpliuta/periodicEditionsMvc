package javaCourse.levelTwo.services;

import java.io.Serializable;


public interface Service<T> {
	void add(T t);

    void update(T t);

	T get(Serializable id);

	void delete(T t);
}
