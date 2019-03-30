package org.jspiders.mvc.login.services;

import org.jspiders.mvc.login.repository.inf.ForgotPasswordDaoInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForgotPasswordService {
	
	@Autowired
	private ForgotPasswordDaoInf forgotPassDao;
	
	public String forgotPass(String email) {
		return forgotPassDao.getUser(email);
	}
	
}
