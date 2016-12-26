package javaCourse.levelTwo.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javaCourse.levelTwo.dao.BaseDao;
import javaCourse.levelTwo.dao.PaymentDao;
import javaCourse.levelTwo.entity.Payment;

@Repository
public class PaymentDaoImpl extends BaseDao<Payment> implements PaymentDao<Payment> {

	@Autowired
	public PaymentDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
