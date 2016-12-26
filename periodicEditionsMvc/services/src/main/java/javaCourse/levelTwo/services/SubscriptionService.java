package javaCourse.levelTwo.services;

import java.util.List;

import javaCourse.levelTwo.entity.Subscription;

public interface SubscriptionService<T> extends Service<T> {
	List<T> findAll();

	Subscription create(Subscription subscription);
}
