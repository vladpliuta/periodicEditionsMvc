package javaCourse.levelTwo.dao.impl;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javaCourse.levelTwo.dao.AddressDao;
import javaCourse.levelTwo.dao.BaseDao;
import javaCourse.levelTwo.entity.Address;

@Repository("addressDao")
public class AddressDaoImpl extends BaseDao<Address> implements AddressDao<Address> {
	private static Logger log = Logger.getLogger(AddressDaoImpl.class);
	
	@Autowired
	public AddressDaoImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
}
