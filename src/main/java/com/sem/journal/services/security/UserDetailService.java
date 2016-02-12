package com.sem.journal.services.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sem.journal.model.JournalUser;
import com.sem.journal.repos.JournalUserRepository;
import com.sem.journal.util.SecurityConstants;

/**
 * Servicio utilizado para consultar la informacion de un usuario contra la base
 * de datos
 * 
 * @author Diego Agudelo
 *
 */
@Service
public class UserDetailService implements UserDetailsService {

	/**
	 * Constante utilizada para denotar que el usuario consultado no es valido
	 */
	private static final String INVALID_USER = " is not registered!";

	/**
	 * Repositorio de consulta
	 */
	@Autowired
	private JournalUserRepository journalUserRepository;

	/**
	 * Metodo que carga la informacion de un usuario dado el 'nombre de usuario'
	 */
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		JournalUser user = journalUserRepository.findJournalUserByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(email + INVALID_USER);
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if (user.isPublisher()) {
			authorities.add(new SimpleGrantedAuthority(SecurityConstants.ROLE_PUBLISHER));
		} else {
			authorities.add(new SimpleGrantedAuthority(SecurityConstants.ROLE_PUBLIC));
		}

		return new User(email, user.getPassword().toString(), authorities);
	}

}