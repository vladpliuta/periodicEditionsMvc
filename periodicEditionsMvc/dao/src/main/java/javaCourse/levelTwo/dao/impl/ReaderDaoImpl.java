package javaCourse.levelTwo.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javaCourse.levelTwo.dao.BaseDao;
import javaCourse.levelTwo.dao.ReaderDao;
import javaCourse.levelTwo.dao.exceptions.DaoException;
import javaCourse.levelTwo.entity.Reader;

@Repository("readerDao")
public class ReaderDaoImpl extends BaseDao<Reader> implements ReaderDao<Reader> {
	private static Logger log = Logger.getLogger(ReaderDaoImpl.class);

	@Autowired
	public ReaderDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public List<Reader> findAll() throws DaoException {
		List<Reader> readers;
		try {
			Query query = getSession().createQuery("findAll");
			readers = (List<Reader>) query.list();
			log.info("Find all readers");
		} catch (HibernateException e) {
			log.error("Error find all readers " + e);
			throw new DaoException(e);
		}
		return readers;
	}

	public Reader findByLogin(String login) throws DaoException {
		Reader reader;
		try {
			Criteria criteria = getSession().createCriteria(Reader.class);
			criteria.add(Restrictions.eq("login", login));
			reader = (Reader) criteria.uniqueResult();
			log.info("Find reader with login" + login);
		} catch (HibernateException e) {
			log.error("Error find reader with login" + login + e);
			throw new DaoException(e);
		}
		return reader;
	}
}
