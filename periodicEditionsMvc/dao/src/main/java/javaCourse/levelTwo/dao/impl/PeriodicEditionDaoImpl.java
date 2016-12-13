package javaCourse.levelTwo.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javaCourse.levelTwo.dao.BaseDao;
import javaCourse.levelTwo.dao.PeriodicEditionDao;
import javaCourse.levelTwo.dao.exceptions.DaoException;
import javaCourse.levelTwo.entity.PeriodicEdition;


@Repository("periodicEditionDao")
public class PeriodicEditionDaoImpl extends BaseDao<PeriodicEdition> implements PeriodicEditionDao<PeriodicEdition> {
	private static Logger log = Logger.getLogger(PeriodicEditionDaoImpl.class);

	@Autowired
	public PeriodicEditionDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public List<PeriodicEdition> findAll() throws DaoException {
		List<PeriodicEdition> periodicEditions;
		try {
			Criteria criteria = getSession().createCriteria(PeriodicEdition.class);
			criteria.setFirstResult(0);
			criteria.setMaxResults(10);
			periodicEditions = (List<PeriodicEdition>) criteria.list();
			log.info("Find all periodic editions");
		} catch (HibernateException e) {
			log.error("Error find all perodic editions " + e);
			throw new DaoException(e);
		}
		return periodicEditions;
	}
}
