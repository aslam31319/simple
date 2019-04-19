package org.jspiders.mvc.login.services.admin;

import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.repository.inf.RegisterDaoInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AddAdmin {
	
	@Autowired
	private RegisterDaoInf regDao;

	@Autowired
	private BCryptPasswordEncoder passEncoder;

	public void register(UserDTO dto) {
		dto.setPassword(passEncoder.encode(dto.getPassword()));
		dto.setRole("ROLE_ADMIN");
		regDao.save(dto);

	}

}