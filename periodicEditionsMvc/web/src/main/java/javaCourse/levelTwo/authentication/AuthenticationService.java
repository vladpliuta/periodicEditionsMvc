package javaCourse.levelTwo.authentication;

import java.util.ArrayList;
import java.util.List;

import javaCourse.levelTwo.entity.Reader;
import javaCourse.levelTwo.services.ReaderService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("authService")
public class AuthenticationService implements UserDetailsService {
	private static Logger log = Logger.getLogger(AuthenticationService.class);

	@Autowired
	private ReaderService readerService;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Reader reader = (Reader) readerService.findByLogin(login);
		log.info("Reader " + reader);
		if (reader == null) {
			log.info("Reader not found");
			throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(reader.getLogin(), reader.getPassword(), true,
				true, true, true, getGrantedAuthorities(reader));
	}

	
	private List<GrantedAuthority> getGrantedAuthorities(Reader reader) {
		String role = readerService.getRole(reader);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		return authorities;
	}

}
