package javaCourse.levelTwo.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javaCourse.levelTwo.dao.PaymentDao;
import javaCourse.levelTwo.entity.Payment;
import javaCourse.levelTwo.services.BaseService;
import javaCourse.levelTwo.services.PaymentService;

@Service("paymentService")
@Transactional
public class PaymentServiceImpl extends BaseService<Payment> implements PaymentService<Payment> {
	private static Logger log = Logger.getLogger(PaymentServiceImpl.class);

	@Autowired
	private PaymentDao paymentDao;
}
