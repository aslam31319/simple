package org.jspiders.mvc.login.services.mail.impl;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.jspiders.mvc.login.services.downloadfiles.GenerateCSV;
import org.jspiders.mvc.login.services.downloadfiles.GeneratePDF;
import org.jspiders.mvc.login.services.downloadfiles.GenerateXLSX;
import org.jspiders.mvc.login.services.mail.inf.SentMailWithAttachInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;

@Service
public class SentMailWithAttachImpl implements SentMailWithAttachInf {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private GenerateCSV getCSV;

	@Autowired
	private GeneratePDF getPDF;

	@Autowired
	private GenerateXLSX getXLSX;

	@Override
	public boolean sentMail(String toEmail, String subject, String body, HttpServletRequest req, String fileEXT) {

		MimeMessage mail = mailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(mail, true);

			helper.setFrom("no-reply@spring.com");
			helper.setTo(toEmail);
			helper.setSubject(subject);
			helper.setText(body);
			if (fileEXT.equals("CSV")) {
				getCSV.generateCSV(req);
				File file = new File(req.getServletContext().getRealPath("/") + "user.csv");
				helper.addAttachment(file.getName(), file);
			}
			if (fileEXT.equals("PDF")) {
				getPDF.generatePDF(req);
				File file = new File(req.getServletContext().getRealPath("/") + "user.pdf");
				helper.addAttachment(file.getName(), file);
			}
			if (fileEXT.equals("XLSX")) {
				getXLSX.generateXLSX(req);
				File file = new File(req.getServletContext().getRealPath("/") + "user.xlsx");
				helper.addAttachment(file.getName(), file);
			}
		} catch (MessagingException | IOException | DocumentException e) {
			throw new MailParseException(e);
		}
		mailSender.send(mail);

		return true;
	}

}
