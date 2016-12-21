package javaCourse.levelTwo.services.impl;

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
		
	@Autowired
	private AddressDao addressDao;
	
	
}
