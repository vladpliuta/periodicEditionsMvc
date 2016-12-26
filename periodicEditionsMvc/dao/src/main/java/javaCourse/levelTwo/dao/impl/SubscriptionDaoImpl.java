package javaCourse.levelTwo.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javaCourse.levelTwo.dao.BaseDao;
import javaCourse.levelTwo.dao.SubscriptionDao;
import javaCourse.levelTwo.entity.Subscription;

@Repository
public class SubscriptionDaoImpl extends BaseDao<Subscription> implements SubscriptionDao<Subscription> {
	private static Logger log = Logger.getLogger(SubscriptionDaoImpl.class);

	@Autowired
	public SubscriptionDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public List<Subscription> findAll() {
		Criteria criteria = getSession().createCriteria(Subscription.class);
		List<Subscription> subscriptions = (List<Subscription>) criteria.list();
		log.info("Find all subscriptions");
		return subscriptions;
	}
}
