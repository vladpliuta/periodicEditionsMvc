package javaCourse.levelTwo.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javaCourse.levelTwo.configuration.HibernateConfigurationTest;
import javaCourse.levelTwo.dao.ReaderDao;
import javaCourse.levelTwo.entity.Reader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfigurationTest.class)
@Transactional
public class ReaderDaoImplTest {

	Reader reader = new Reader("Ivan", "Ivan", "ivan", "ivan");

	@Autowired
	private ReaderDao readerDao;

	@Test
	public void testAdd() {
		Reader readerActual = (Reader) readerDao.add(reader);
		Reader readerExpected = (Reader) readerDao.get(reader.getId());
		assertNotNull(readerExpected);
		assertTrue("The expected result is not obtained", readerExpected.equals(readerActual));
	}

	@Test
	public void testUpdate() {
		readerDao.add(reader);
		Reader readerActual = (Reader) readerDao.get(reader.getId());
		readerActual.setForename("Petr");
		readerDao.update(readerActual);
		Reader readerExpected = (Reader) readerDao.get(reader.getId());
		assertNotNull(readerExpected);
		assertTrue("The expected result is not obtained", readerExpected.equals(readerActual));
	}

	@Test
	public void testGet() {
		readerDao.add(reader);
		Reader readerExpected = (Reader) readerDao.get(reader.getId());
		assertNotNull(readerExpected);
		assertTrue("The expected result is not obtained", readerExpected.equals(reader));

	}

	@Test
	public void testDelete() {
		readerDao.add(reader);
		Reader readerActual = (Reader) readerDao.get(reader.getId());
		int idActual = readerActual.getId();
		readerDao.delete(readerActual);
		Reader readerExpected = (Reader) readerDao.get(idActual);
		assertNull(readerExpected);
	}

	@Test
	public void testDeleteById() {
		readerDao.add(reader);
		Reader readerActual = (Reader) readerDao.get(reader.getId());
		int idActual = readerActual.getId();
		readerDao.deleteById(idActual);
		Reader readerExpected = (Reader) readerDao.get(idActual);
		assertNull(readerExpected);
	}

	@Test
	public void testFindByLogin() {
		Reader reader = new Reader("Ivan", "Ivan", "login", "ivan");
		readerDao.add(reader);
		Reader readerActual = (Reader) readerDao.get(reader.getId());
		String login = readerActual.getLogin();
		Reader readerExpected = (Reader) readerDao.findByLogin(login);
		assertNotNull(readerExpected);
		assertTrue("The expected result is not obtained", readerExpected.equals(readerActual));
	}
	@Test
    public void testFindAll(){
	    List<Reader> readers = readerDao.findAll();
        assertEquals(0, readers.size());
    }
}
