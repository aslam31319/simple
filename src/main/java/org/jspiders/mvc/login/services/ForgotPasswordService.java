package org.jspiders.mvc.login.services;

import java.util.UUID;

import org.jspiders.mvc.login.repository.inf.ForgotPasswordDaoInf;
import org.jspiders.mvc.login.repository.inf.ResetPasswordInf;
import org.jspiders.mvc.login.services.mail.inf.SentMailInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ForgotPasswordService {

	@Autowired
	@Qualifier("springMail")
	private SentMailInf sentMailSpring;

	@Autowired
	private ForgotPasswordDaoInf forgotPassDao;

	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	private ResetPasswordInf resetPasswordRepo;

	public Boolean forgotPass(String email) {

		String token = UUID.randomUUID().toString();
		token=token.substring(0,7);

		if (forgotPassDao.getUser(email) == null) {
			return false;
		} else {
			String password=passEncoder.encode(token);
			
			System.out.println(resetPasswordRepo.resetPassword(email,password));;
			String subject = "No Reply";
			String body = "This is a System generated message Please do not try to reply for this mail. \n This message is contains confidential information like password please do not share it whith any one.\n Your Email id is: "
					+ email + " \n\n Your Password is :" + token;
			
			
			sentMailSpring.sentMail(email, subject, body);

			return true;
		}
		// return forgotPassDao.getUser(email);
	}

}
