package javaCourse.levelTwo.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javaCourse.levelTwo.dao.AddressDao;
import javaCourse.levelTwo.dao.BaseDao;
import javaCourse.levelTwo.entity.Address;

@Repository
public class AddressDaoImpl extends BaseDao<Address> implements AddressDao<Address> {
	
	@Autowired
	public AddressDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
