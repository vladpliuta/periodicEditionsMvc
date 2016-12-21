package javaCourse.levelTwo.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
//import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javaCourse.levelTwo.dao.BaseDao;
import javaCourse.levelTwo.dao.ReaderDao;
import javaCourse.levelTwo.entity.Reader;

@Repository("readerDao")
public class ReaderDaoImpl extends BaseDao<Reader> implements ReaderDao<Reader> {
	private static Logger log = Logger.getLogger(ReaderDaoImpl.class);

	@Autowired
	public ReaderDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public List<Reader> findAll() {
		// Query query = getSession().createQuery("findAll");
		// readers = (List<Reader>) query.list();
		Criteria criteria = getSession().createCriteria(Reader.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(10);
		List<Reader> readers = (List<Reader>) criteria.list();
		log.info("Find all readers");
		return readers;
	}

	public Reader findByLogin(String login) {
		Criteria criteria = getSession().createCriteria(Reader.class);
		criteria.add(Restrictions.eq("login", login));
		Reader reader = (Reader) criteria.uniqueResult();
		log.info("Find reader with login" + login);
		return reader;
	}
}
