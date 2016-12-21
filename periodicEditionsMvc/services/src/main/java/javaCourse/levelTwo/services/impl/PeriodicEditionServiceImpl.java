package javaCourse.levelTwo.services.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javaCourse.levelTwo.dao.PeriodicEditionDao;
import javaCourse.levelTwo.entity.PeriodicEdition;
import javaCourse.levelTwo.services.BaseService;
import javaCourse.levelTwo.services.PeriodicEditionService;

@Service("periodicEditionService")
@Transactional
public class PeriodicEditionServiceImpl extends BaseService<PeriodicEdition>
		implements PeriodicEditionService<PeriodicEdition> {
	private static Logger log = Logger.getLogger(PeriodicEditionServiceImpl.class);

	@Autowired
	private PeriodicEditionDao periodicEditionDao;

	@Override
	public List<PeriodicEdition> findAll() {

		List<PeriodicEdition> periodicEditions = (List<PeriodicEdition>) periodicEditionDao.findAll();
		log.info("Find all periodic editions");
		return periodicEditions;
	}

	@Override
	public void deleteById(int issn) {
		periodicEditionDao.deleteById(issn);
		log.info("Delete periodic edition: " + issn);
	}

	@Override
	public PeriodicEdition create(PeriodicEdition periodicEdition) {
		if (periodicEdition != null) {
			return (PeriodicEdition) periodicEditionDao.add(periodicEdition);
		}
		return periodicEdition;
	}
}
