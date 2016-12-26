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
import javaCourse.levelTwo.dao.PeriodicEditionDao;
import javaCourse.levelTwo.entity.PeriodicEdition;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfigurationTest.class)
@Transactional
public class PeriodicEditionDaoImplTest {

	@Autowired
	private PeriodicEditionDao periodicEditionDao;

	@Test
	public void testAdd() {
		PeriodicEdition periodicEdition = new PeriodicEdition(11111111, "News", "News", 1, 2.0, 0, 0);
		PeriodicEdition periodicEditionActual = (PeriodicEdition) periodicEditionDao.add(periodicEdition);
		PeriodicEdition periodicEditionExpected = (PeriodicEdition) periodicEditionDao.get(periodicEdition.getId());
		assertNotNull(periodicEditionExpected);
		assertTrue("The expected result is not obtained", periodicEditionExpected.equals(periodicEditionActual));
	}

	@Test
	public void testUpdate() {
		PeriodicEdition periodicEdition = new PeriodicEdition(22222222, "News", "News", 1, 2.0, 0, 0);
		PeriodicEdition periodicEditionActual = (PeriodicEdition) periodicEditionDao.add(periodicEdition);
		periodicEditionActual.setDiscountHalfyear(2);
		periodicEditionDao.update(periodicEditionActual);
		PeriodicEdition periodicEditionExpected = (PeriodicEdition) periodicEditionDao.get(periodicEdition.getId());
		assertNotNull(periodicEditionExpected);
		assertTrue("The expected result is not obtained", periodicEditionExpected.equals(periodicEditionActual));
	}

	@Test
	public void testGet() {
		PeriodicEdition periodicEdition = new PeriodicEdition(44444444, "News", "News", 1, 2.0, 0, 0);
		periodicEditionDao.add(periodicEdition);
		PeriodicEdition periodicEditionExpected = (PeriodicEdition) periodicEditionDao.get(periodicEdition.getId());
		assertNotNull(periodicEditionExpected);
		assertTrue("The expected result is not obtained", periodicEditionExpected.equals(periodicEdition));

	}

	@Test
	public void testDelete() {
		PeriodicEdition periodicEdition = new PeriodicEdition(55555555, "News", "News", 1, 2.0, 0, 0);
		periodicEditionDao.add(periodicEdition);
		PeriodicEdition periodicEditionActual = (PeriodicEdition) periodicEditionDao.get(periodicEdition.getId());
		int idActual = periodicEditionActual.getId();
		periodicEditionDao.delete(periodicEditionActual);
		PeriodicEdition periodicEditionExpected = (PeriodicEdition) periodicEditionDao.get(idActual);
		assertNull(periodicEditionExpected);
	}

	@Test
	public void testDeleteById() {
		PeriodicEdition periodicEdition = new PeriodicEdition(66666666, "News", "News", 1, 2.0, 0, 0);
		periodicEditionDao.add(periodicEdition);
		PeriodicEdition periodicEditionActual = (PeriodicEdition) periodicEditionDao.get(periodicEdition.getId());
		int idActual = periodicEditionActual.getId();
		periodicEditionDao.deleteById(idActual);
		PeriodicEdition periodicEditionExpected = (PeriodicEdition) periodicEditionDao.get(idActual);
		assertNull(periodicEditionExpected);
	}

	@Test
	public void testFindById() {
		PeriodicEdition periodicEdition = new PeriodicEdition(77777777, "News", "News", 1, 2.0, 0, 0);
		periodicEditionDao.add(periodicEdition);
		PeriodicEdition periodicEditionActual = (PeriodicEdition) periodicEditionDao.get(periodicEdition.getId());
		int idActual = periodicEditionActual.getId();
		PeriodicEdition periodicEditionExpected = (PeriodicEdition) periodicEditionDao.findById(idActual);
		assertNotNull(periodicEditionExpected);
		assertTrue("The expected result is not obtained", periodicEditionExpected.equals(periodicEditionActual));
	}
}
