package javaCourse.levelTwo.services.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javaCourse.levelTwo.dao.ReaderDao;
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
		List<Reader> readers = (List<Reader>) readerDao.findAll();
		log.info("Find all readers");
		return readers;
	}

	@Override
	public Reader findByLogin(String login) {
		Reader reader = (Reader) readerDao.findByLogin(login);
		log.info("Find reader with login" + login);
		return reader;
	}

	@Override
	public String getRole(Reader reader) {
		String resalt = null;
		int adminFlag = reader.getAdminFlag();
		if (adminFlag == 1) {
			resalt = "ADMIN";
			log.info("Reader is admin");
		} else if (adminFlag == 0) {
			resalt = "USER";
			log.info("Reader is user");
		}
		return resalt;
	}

	@Override
	public void deleteById(int id) {
		readerDao.deleteById(id);
		log.info("Delete rreader: " + id);
	}
}
