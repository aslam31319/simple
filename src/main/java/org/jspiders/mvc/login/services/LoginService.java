package org.jspiders.mvc.login.services;

import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.repository.inf.LoginDaoInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

	@Autowired
	@Qualifier("hql")
	private LoginDaoInf logDao;

	public UserDTO login(String email,String password) {

		return logDao.login(email,password);
	}
}
