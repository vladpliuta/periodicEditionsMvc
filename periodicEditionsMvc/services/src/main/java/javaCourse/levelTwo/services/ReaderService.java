package javaCourse.levelTwo.services;

import java.util.List;


public interface ReaderService<T> extends Service<T> {
	List<T> findAll();
	T findByLogin(String login);
	String getRole (T reader);
}
