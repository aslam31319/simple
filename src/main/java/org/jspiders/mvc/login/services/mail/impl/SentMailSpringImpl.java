package org.jspiders.mvc.login.services.mail.impl;

import org.jspiders.mvc.login.services.mail.inf.SentMailInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("springMail")
public class SentMailSpringImpl implements SentMailInf {

	@Autowired
	private MailSender mailSender;

	@Override
	public boolean sentMail(String toEmail, String subject, String body) {
		
		SimpleMailMessage message = new SimpleMailMessage();

		
		message.setFrom("no-repaly@gmail.com");
		message.setTo(toEmail);
		message.setSubject(subject);	
		message.setText(body);
		mailSender.send(message);
		return true;
	}
}
