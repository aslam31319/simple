package org.jspiders.mvc.login.services.mail.inf;

public interface SentMailInf {
	default public boolean sentMail(String toEmail,String subject,String body) {
		return false;
	};
}
