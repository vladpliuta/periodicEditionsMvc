package javaCourse.levelTwo.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javaCourse.levelTwo.dao.BaseDao;
import javaCourse.levelTwo.dao.PeriodicEditionDao;
import javaCourse.levelTwo.entity.PeriodicEdition;


@Repository("periodicEditionDao")
public class PeriodicEditionDaoImpl extends BaseDao<PeriodicEdition> implements PeriodicEditionDao<PeriodicEdition> {
	private static Logger log = Logger.getLogger(PeriodicEditionDaoImpl.class);

	@Autowired
	public PeriodicEditionDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public List<PeriodicEdition> findAll() {
		Criteria criteria = getSession().createCriteria(PeriodicEdition.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(10);
		List<PeriodicEdition> periodicEditions = (List<PeriodicEdition>) criteria.list();
		log.info("Find all periodic editions");
		return periodicEditions;
	}

	@Override
	public void deleteById(int issn) {
		Criteria criteria = getSession().createCriteria(PeriodicEdition.class);
		criteria.add(Restrictions.eq("id", issn));
		PeriodicEdition periodicEdition = (PeriodicEdition) criteria.uniqueResult();
		delete(periodicEdition);
	}
}
