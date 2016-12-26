package javaCourse.levelTwo.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javaCourse.levelTwo.configuration.HibernateConfigurationTest;
import javaCourse.levelTwo.dao.PaymentDao;

import javaCourse.levelTwo.entity.Payment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfigurationTest.class)
@Transactional
public class PaymentDaoImplTest {
	private Payment payment = new Payment(1.1);

	@Autowired
	private PaymentDao paymentDao;

	@Test
	public void testAdd() {
		Payment paymentActual = (Payment) paymentDao.add(payment);
		Payment paymentExpected = (Payment) paymentDao.get(payment.getId());
		assertNotNull(paymentExpected);
		assertTrue("The expected result is not obtained", paymentExpected.equals(paymentActual));
	}

	@Test
	public void testUpdate() {
		paymentDao.add(payment);
		Payment paymentActual = (Payment) paymentDao.get(payment.getId());
		paymentActual.setCoast(2.2);
		paymentDao.update(paymentActual);
		Payment paymentExpected = (Payment) paymentDao.get(payment.getId());
		assertNotNull(paymentExpected);
		assertTrue("The expected result is not obtained", paymentExpected.equals(paymentActual));
	}

	@Test
	public void testGet() {
		paymentDao.add(payment);
		Payment paymentExpected = (Payment) paymentDao.get(payment.getId());
		assertNotNull(paymentExpected);
		assertTrue("The expected result is not obtained", paymentExpected.equals(payment));

	}

	@Test
	public void testDelete() {
		paymentDao.add(payment);
		Payment paymentActual = (Payment) paymentDao.get(payment.getId());
		int idActual = paymentActual.getId();
		paymentDao.delete(paymentActual);
		Payment paymentExpected = (Payment) paymentDao.get(idActual);
		assertNull(paymentExpected);
	}
}
