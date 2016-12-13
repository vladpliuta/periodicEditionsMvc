package javaCourse.levelTwo.services;

import java.util.List;

public interface SubscriptionService<T> extends Service<T> {
	List<T> findAll();
}
