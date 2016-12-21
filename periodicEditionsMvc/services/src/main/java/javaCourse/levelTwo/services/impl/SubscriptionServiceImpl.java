package javaCourse.levelTwo.services.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javaCourse.levelTwo.dao.SubscriptionDao;
import javaCourse.levelTwo.entity.Subscription;
import javaCourse.levelTwo.services.BaseService;
import javaCourse.levelTwo.services.SubscriptionService;

@Service("subscriptionService")
@Transactional
public class SubscriptionServiceImpl extends BaseService<Subscription> implements SubscriptionService<Subscription> {
	private static Logger log = Logger.getLogger(SubscriptionServiceImpl.class);

	@Autowired
	private SubscriptionDao subscriptionDao;

	@Override
	public List<Subscription> findAll() {
		List<Subscription> subscriptions = (List<Subscription>) subscriptionDao.findAll();
		log.info("Find all subscriptions");
		return subscriptions;
	}
}
