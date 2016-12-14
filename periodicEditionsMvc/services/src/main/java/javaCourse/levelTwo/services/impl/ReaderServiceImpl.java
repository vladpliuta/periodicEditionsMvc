package javaCourse.levelTwo.services.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javaCourse.levelTwo.dao.ReaderDao;
import javaCourse.levelTwo.dao.exceptions.DaoException;
import javaCourse.levelTwo.entity.Reader;
import javaCourse.levelTwo.services.BaseService;
import javaCourse.levelTwo.services.ReaderService;

@Service("readerService")
@Transactional
public class ReaderServiceImpl extends BaseService<Reader> implements ReaderService<Reader> {
	private static Logger log = Logger.getLogger(ReaderServiceImpl.class);
	
	@Autowired
	private ReaderDao readerDao;

	@Override
	public List<Reader> findAll() {
		List<Reader> readers = null;
		try {
			readers = (List<Reader>) readerDao.findAll();
			log.info("Find all readers");
		} catch (DaoException e) {
			log.error("Error find all readers " + e);
		}
		return readers;
	}

	@Override
	public Reader findByLogin(String login) {
		Reader reader = null;
		try {
			reader = (Reader) readerDao.findByLogin(login);
			log.info("Find reader with login" + login);
		} catch (DaoException e) {
			log.error("Error find reader with login" + login + e);
		}
		return reader;
	}
	@Override
	public String checkLogin (String login, String password){
		Reader reader = null;
		String resalt = "error";
		try {
			reader = (Reader) readerDao.findByLogin(login);
			String baseLogin = reader.getLogin();
			String basePassword = reader.getPassword();
			int adminFlag = reader.getAdminFlag();
			if (login.equals(baseLogin) && password.equals(basePassword)) {
				if (adminFlag == 1) {
					resalt = "admin";
					log.info("Find admin " + login);
				} else {
					resalt = "user";
					log.info("Find user " + login);
				}
			} else {
				resalt = "error";
				log.info("Not check " + login);
			}
		} catch (DaoException e) {
			log.error("Uncheck" + login + e);
	}
		return resalt;
	}
}
