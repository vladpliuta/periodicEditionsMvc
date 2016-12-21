package javaCourse.levelTwo.dao;

import java.util.List;

public interface SubscriptionDao<T> extends Dao<T> {
	List<T> findAll();
}
