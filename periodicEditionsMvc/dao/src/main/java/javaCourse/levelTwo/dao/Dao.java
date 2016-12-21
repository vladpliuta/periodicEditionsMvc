package javaCourse.levelTwo.dao;

import java.io.Serializable;

public interface Dao<T> {
	T add(T t);

    void update(T t);

	T get(Serializable id);

	void delete(T t);

}
