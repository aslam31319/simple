package org.jspiders.mvc.login.services;

import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.repository.inf.RegisterDaoInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegisterService {
	@Autowired
	private RegisterDaoInf regDao;

	public boolean register(UserDTO dto) {
		return regDao.save(dto);
	}
}
