package javaCourse.levelTwo.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javaCourse.levelTwo.configuration.HibernateConfigurationTest;
import javaCourse.levelTwo.dao.SubscriptionDao;
import javaCourse.levelTwo.entity.Subscription;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfigurationTest.class)
@Transactional
public class SubscriptionDaoImplTest {
	
	@Autowired
	private SubscriptionDao subscriptionDao;

	@Test
	public void testAdd() {
		Subscription subscription = new Subscription(1, 11111111, 1);
		Subscription subscriptionActual = (Subscription) subscriptionDao.add(subscription);
		Subscription subscriptionExpected = (Subscription) subscriptionDao.get(subscription.getId());
		assertNotNull(subscriptionExpected);
		assertTrue("The expected result is not obtained", subscriptionExpected.equals(subscriptionActual));
	}

	@Test
	public void testUpdate() {
		Subscription subscription = new Subscription(1, 22222222, 1);
		subscriptionDao.add(subscription);
		Subscription subscriptionActual = (Subscription) subscriptionDao.get(subscription.getId());
		subscriptionActual.setPeriod(2);
		subscriptionDao.update(subscriptionActual);
		Subscription subscriptionExpected = (Subscription) subscriptionDao.get(subscription.getId());
		assertNotNull(subscriptionExpected);
		assertTrue("The expected result is not obtained", subscriptionExpected.equals(subscriptionActual));
	}

	@Test
	public void testGet() {
		Subscription subscription = new Subscription(1, 33333333, 1);
		subscriptionDao.add(subscription);
		Subscription subscriptionExpected = (Subscription) subscriptionDao.get(subscription.getId());
		assertNotNull(subscriptionExpected);
		assertTrue("The expected result is not obtained", subscriptionExpected.equals(subscription));
	}
	@Test
	public void testDelete() {
		Subscription subscription = new Subscription(1, 44444444, 1);
		subscriptionDao.add(subscription);
		Subscription subscriptionActual = (Subscription) subscriptionDao.get(subscription.getId());
		int idActual = subscriptionActual.getId();
		subscriptionDao.delete(subscriptionActual);
		Subscription subscriptionExpected = (Subscription) subscriptionDao.get(idActual);
		assertNull(subscriptionExpected);
	}
}