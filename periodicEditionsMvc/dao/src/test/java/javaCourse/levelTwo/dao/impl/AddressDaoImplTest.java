package javaCourse.levelTwo.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javaCourse.levelTwo.configuration.HibernateConfigurationTest;
import javaCourse.levelTwo.dao.AddressDao;
import javaCourse.levelTwo.entity.Address;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfigurationTest.class)
@Transactional
public class AddressDaoImplTest {
	private Address address = new Address(123456, "Minsk", "street", "100", 1);
	@Autowired
	private AddressDao addressDao;

	@Test
	public void testAdd() {
		Address addressActual = (Address) addressDao.add(address);
		Address addressExpected = (Address) addressDao.get(address.getId());
		System.out.println(addressActual);
		System.out.println(addressExpected);
		assertNotNull(addressExpected);
		assertTrue("The expected result is not obtained", addressExpected.equals(addressActual));
	}

	@Test
	public void testUpdate() {
		addressDao.add(address);
		Address addressActual = (Address) addressDao.get(address.getId());
		addressActual.setHouse("50");
		addressDao.update(addressActual);
		Address addressExpected = (Address) addressDao.get(address.getId());
		assertNotNull(addressExpected);
		assertTrue("The expected result is not obtained", addressExpected.equals(addressActual));
	}

	@Test
	public void testGet() {
		addressDao.add(address);
		Address addressExpected = (Address) addressDao.get(address.getId());
		assertNotNull(addressExpected);
		assertTrue("The expected result is not obtained", addressExpected.equals(address));

	}

	@Test
	public void testDelete() {
		addressDao.add(address);
		Address addressActual = (Address) addressDao.get(address.getId());
		int idActual = addressActual.getId();
		addressDao.delete(addressActual);
		Address addressExpected = (Address) addressDao.get(idActual);
		assertNull(addressExpected);
	}
}
