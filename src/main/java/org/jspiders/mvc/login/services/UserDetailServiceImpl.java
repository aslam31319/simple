package org.jspiders.mvc.login.services;

import java.util.HashSet;
import java.util.Set;

import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.repository.inf.LoginDaoInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	@Qualifier("hql")
	private LoginDaoInf logDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username+"asf");
		UserDTO dto=logDao.login(username);
		System.out.println(dto);
		System.out.println(dto.getPassword());
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(dto.getRole()));
		
		System.out.println(dto.getRole());
		return new User(dto.getEmail(), dto.getPassword(), grantedAuthorities);
	}

}
