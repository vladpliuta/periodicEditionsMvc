package javaCourse.levelTwo.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javaCourse.levelTwo.dao.PaymentDao;
import javaCourse.levelTwo.dao.PeriodicEditionDao;
import javaCourse.levelTwo.dao.exceptions.DaoException;
import javaCourse.levelTwo.entity.Payment;
import javaCourse.levelTwo.entity.PeriodicEdition;
import javaCourse.levelTwo.services.BaseService;
import javaCourse.levelTwo.services.PaymentService;

@Service("paymentService")
@Transactional
public class PaymentServiceImpl extends BaseService<Payment> implements PaymentService<Payment> {
	private static Logger log = Logger.getLogger(PaymentServiceImpl.class);

	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private PeriodicEditionDao periodicEditionDao;
	
	@Override
	public double calculate (int issn, int period) {
		PeriodicEdition periodicEdition = null;
		try {
			periodicEdition = (PeriodicEdition) periodicEditionDao.get(issn);
		} catch (DaoException e) {
			}
		int discount = 0;
		switch (period) {
		case 1:
			discount = 0;
			break;
		case 3:
			discount = periodicEdition.getDiscountQuarteryear();
			break;
		case 6:
			discount = periodicEdition.getDiscountHalfyear();
			break;
		case 12:
			discount = periodicEdition.getDiscountHalfyear();
			break;
		}
		double coast = (double) (periodicEdition.getMonthPrice() * period * (100 - discount) / 100);
		return coast;
	}
}
