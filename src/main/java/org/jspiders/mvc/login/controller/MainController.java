package org.jspiders.mvc.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jspiders.mvc.login.model.EmpDTO;
import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.services.DownloadService;
import org.jspiders.mvc.login.services.EmpService;
import org.jspiders.mvc.login.services.ForgotPasswordService;
import org.jspiders.mvc.login.services.LoginService;
import org.jspiders.mvc.login.services.RegisterService;
import org.jspiders.mvc.login.services.mail.inf.SentMailInf;
import org.jspiders.mvc.login.services.mail.inf.SentMailWithAttachInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	private static Logger log =LogManager.getLogger(MainController.class);
	
	@Autowired
	private LoginService logService;

	@Autowired
	private RegisterService regService;

	@Autowired
	private ForgotPasswordService forgotPassService;

	/*
	 * @Autowired
	 * 
	 * @Qualifier("javaMail") private SentMailInf sentMail;
	 */
	@Autowired
	@Qualifier("springMail")
	private SentMailInf sentMailSpring;

	@Autowired
	private DownloadService downloadService;

	@Autowired
	private EmpService empService;

	@Autowired
	private SentMailWithAttachInf sentMailAtach;

	// Home page response
	@RequestMapping(value= {"/","logout","home","index"})
	public String home() {
		log.info("its logged");
		return "index";
	}

	// Registration response
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@ModelAttribute UserDTO dto, Model model) {

		try {
			regService.register(dto);
			model.addAttribute("result", "Registration Successful");
			return "index";
		} catch (Exception e) {
			model.addAttribute("result", "User already exist.... Registration Faild");
			return "index";
		}

	}

	// Login response
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		UserDTO validDto = logService.login(email, password);

		if (validDto == null) {
			model.addAttribute("result", "Invalid username or password");
			return "index";
		} else if (validDto.getPassword().equals(password)) {
			model.addAttribute("result", "Welcome " + validDto.getFirstName() + " " + validDto.getLastName());
			model.addAttribute("email", email);
			return "home";
		} else {
			model.addAttribute("result", "Invalid username or password");
			return "index";
		}
	}

	// forgot password
	@RequestMapping(value = "forgot", method = RequestMethod.POST)
	public String forgotPassword(@RequestParam("email") String email, Model model) {
		if (forgotPassService.forgotPass(email) == null) {
			model.addAttribute("result", "No user found");
			return "index";
		} else {
			String subject = "No Reply";
			String body = "This is a System generated message Please do not try to reply for this mail. \n This message is contains confidential information like password please do not share it whith any one.\n Your Email id is: "
					+ email + " \n\n Your Password is :" + forgotPassService.forgotPass(email);
			// sentMail.sentMail(email, subject, body);
			sentMailSpring.sentMail(email, subject, body);
			model.addAttribute("result", "Please check your Email for details");
			return "index";

		}

	}

	// sent mail with attachment
	@RequestMapping(value = "mailAttach", method = RequestMethod.POST)

	public @ResponseBody String sentMailAtach(HttpServletRequest req, @RequestParam("fileEXT") String fileEXT,
			@RequestParam("email") String email) {
		System.out.println(email + fileEXT);
		String subject = "Attachment";
		String body = "This is your attachment ";
		sentMailAtach.sentMail(email, subject, body, req, fileEXT);
		return "mailsent";
	}

	// download file mapping
	@RequestMapping(value = "download", method = RequestMethod.GET)
	public void generate(HttpServletRequest req, HttpServletResponse resp, @RequestParam("fileEXT") String fileEXT) {
		System.out.println(fileEXT);
		downloadService.downloadFile(req, resp, fileEXT);

	}

	@RequestMapping(value = "getallemp", method = RequestMethod.POST)
	public @ResponseBody List<EmpDTO> getAllEmp() {
		return empService.getAllEmp();
	}
	
	/*
	 * @RequestMapping(value="uploadFile",method=RequestMethod.POST) public void
	 * upload(@RequestParam("file")MultipartFile file) {
	 * System.out.println(file.getOriginalFilename()); }
	 */
}
