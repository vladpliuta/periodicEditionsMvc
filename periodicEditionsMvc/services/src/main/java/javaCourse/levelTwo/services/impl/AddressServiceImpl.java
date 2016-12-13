package javaCourse.levelTwo.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javaCourse.levelTwo.dao.AddressDao;
import javaCourse.levelTwo.entity.Address;
import javaCourse.levelTwo.services.AddressService;
import javaCourse.levelTwo.services.BaseService;

@Service("addressService")
@Transactional
public class AddressServiceImpl extends BaseService<Address> implements AddressService<Address> {
	private static Logger log = Logger.getLogger(AddressServiceImpl.class);
	
	@Autowired
	private AddressDao addressDao;
	
	
}
