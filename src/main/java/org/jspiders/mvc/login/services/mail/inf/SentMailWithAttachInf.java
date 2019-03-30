package org.jspiders.mvc.login.services.mail.inf;

import javax.servlet.http.HttpServletRequest;

public interface SentMailWithAttachInf {

	
	public boolean sentMail(String toEmail, String subject, String body,HttpServletRequest req,String fileEXT);
}
