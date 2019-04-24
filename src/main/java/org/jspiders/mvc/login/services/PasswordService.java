package org.jspiders.mvc.login.services;

import java.util.UUID;

import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.repository.inf.LoginDaoInf;
import org.jspiders.mvc.login.repository.inf.ResetPasswordInf;
import org.jspiders.mvc.login.services.mail.inf.SentMailInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

	@Autowired
	@Qualifier("springMail")
	private SentMailInf sentMailSpring;

	@Autowired
	private BCryptPasswordEncoder passEncoder;

	@Autowired
	private ResetPasswordInf resetPasswordRepo;
	
	@Autowired
	@Qualifier("hql")
	private LoginDaoInf getUser;

	public Boolean forgotPass(String email) {

		String token = UUID.randomUUID().toString();
		token = token.substring(0, 7);

		if (getUser.login(email) == null) {
			return false;
		} else {
			String password = passEncoder.encode(token);

			resetPasswordRepo.resetPassword(email, password);
			String subject = "No Reply";
			String body = "This is a System generated message Please do not try to reply for this mail. \n This message is contains confidential information like password please do not share it whith any one.\n Your Email id is: "
					+ email + " \n\n Your Password is :" + token;

			sentMailSpring.sentMail(email, subject, body);

			return true;
		}
		// return forgotPassDao.getUser(email);
	}

	public boolean changePassword(String email, String currentPassword, String newPassword) {

		UserDTO dto = getUser.login(email);
		
		if (passEncoder.matches(currentPassword, dto.getPassword())) {
			resetPasswordRepo.resetPassword(email, passEncoder.encode(newPassword));
			return true;
			
		} else {

			return false;
		}
	}

}
