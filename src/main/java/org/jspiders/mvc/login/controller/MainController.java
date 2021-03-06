package org.jspiders.mvc.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jspiders.mvc.login.model.EmpDTO;
import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.services.DownloadService;
import org.jspiders.mvc.login.services.EmpService;
import org.jspiders.mvc.login.services.PasswordService;
import org.jspiders.mvc.login.services.RegisterService;
import org.jspiders.mvc.login.services.mail.inf.SentMailWithAttachInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	private static Logger log = LogManager.getLogger(MainController.class);

	@Autowired
	private RegisterService regService;

	@Autowired
	private PasswordService passwordService;

	@Autowired
	private DownloadService downloadService;

	@Autowired
	private EmpService empService;

	@Autowired
	private SentMailWithAttachInf sentMailAtach;

	// Home page response
	@RequestMapping(value = { "/", "home", "index" })
	public String home() {
		log.info("Home controller is called");
		return "index";
	}

	@RequestMapping("chpwdform")
	public String chpwd() {
		log.info("Change password form is called");
		return "changePassword";
	}

	@RequestMapping(value = { "login" })
	public String login(@RequestParam(name = "error", defaultValue = "false") String error, Model model) {
		log.info("Requested for login page");
		if (error.equals("true")) {
			model.addAttribute("result", "Invalid email or password");
			return "login";
		}

		return "login";
	}

	@RequestMapping(value = { "regp" })
	public String regp() {
		log.info("its logged");
		return "register";
	}

	@RequestMapping(value = { "welcome" })
	public String welcome() {
		log.info("its logged");
		return "home";
	}

	// Registration response
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@ModelAttribute UserDTO dto, Model model) {

		log.info("Register controller is called");
		try {
			regService.register(dto);
			model.addAttribute("result", "Registration Successful");
			return "login";
		} catch (Exception e) {
			log.warn("Trying to register with already existing id");
			model.addAttribute("result", "User already exist.... Registration Faild");
			return "index";
		}

	}

	// forgot password
	@RequestMapping(value = "forgot", method = RequestMethod.POST)
	public String forgotPassword(@RequestParam("recemail") String email, Model model) {

		if (passwordService.forgotPass(email)) {
			model.addAttribute("result", "Please check your Email for details");
			return "login";
		} else {

			model.addAttribute("result", "No user found");
			return "register";
		}

	}

	// change password
	@RequestMapping(value = "changePassword", method = RequestMethod.POST)
	public String changePassword(@RequestParam("email") String email,
			@RequestParam("currentPassword") String currentPassword, @RequestParam("newPassword") String newPassword,
			Model model) {

		String logedInEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		
		System.out.println(logedInEmail);
		if (logedInEmail.equals(email)) {
			if (passwordService.changePassword(email, currentPassword, newPassword)) {
				model.addAttribute("result", "Password changed please login again");
				return "login";
			} else {

				model.addAttribute("result", "Invalid username or password");
				return "login";

			}
		} else {
			model.addAttribute("result", "Invalid username or password");
			return "login";
		}

	}

	// sent mail with attachment
	@RequestMapping(value = "mailAttach", method = RequestMethod.POST)

	public @ResponseBody String sentMailAtach(HttpServletRequest req, @RequestParam("fileEXT") String fileEXT,
			@RequestParam("email") String email) {
		log.info("Emali with Attach to " + email);
		String subject = "Attachment";
		String body = "This is your attachment ";
		sentMailAtach.sentMail(email, subject, body, req, fileEXT);
		return "mailsent";
	}

	// download file mapping
	@RequestMapping(value = "download", method = RequestMethod.GET)
	public void generate(HttpServletRequest req, HttpServletResponse resp, @RequestParam("fileEXT") String fileEXT) {
		log.info("Download for " + fileEXT);
		downloadService.downloadFile(req, resp, fileEXT);

	}

	@RequestMapping(value = "getallemp", method = RequestMethod.POST)
	public @ResponseBody List<EmpDTO> getAllEmp() {
		log.info("Fetching all employee details");
		return empService.getAllEmp();
	}

	// @Autowired
	// @Qualifier("springMail")
	// private SentMailInf sentMailSpring;

	// @Autowired
	// private LoginService logService;

	/*
	 * @Autowired
	 * 
	 * @Qualifier("javaMail") private SentMailInf sentMail;
	 */

	/*
	 * if (forgotPassService.forgotPass(email) == null) {
	 * model.addAttribute("result", "No user found"); return "register"; } else {
	 * String subject = "No Reply"; String body =
	 * "This is a System generated message Please do not try to reply for this mail. \n This message is contains confidential information like password please do not share it whith any one.\n Your Email id is: "
	 * + email + " \n\n Your Password is :" + forgotPassService.forgotPass(email);
	 * // sentMail.sentMail(email, subject, body); sentMailSpring.sentMail(email,
	 * subject, body); model.addAttribute("result",
	 * "Please check your Email for details"); return "login";
	 * 
	 * }
	 */

	/*
	 * This method is not needed any more since i am using Spring Security
	 * 
	 * 
	 * 
	 * // Login response
	 * 
	 * @RequestMapping(value = "login", method = RequestMethod.POST) public String
	 * login(@RequestParam("email") String email, @RequestParam("password") String
	 * password, Model model) { log.info("Login controller is called"); UserDTO
	 * validDto = logService.login(email, password);
	 * 
	 * if (validDto == null) {
	 * log.warn("Trying to login using invalid credentials");
	 * model.addAttribute("result", "Invalid username or password"); return "index";
	 * } else if (validDto.getPassword().equals(password)) {
	 * model.addAttribute("result", "Welcome " + validDto.getFirstName() + " " +
	 * validDto.getLastName()); model.addAttribute("email", email); return "home"; }
	 * else { log.warn("Trying to login using invalid credentials");
	 * model.addAttribute("result", "Invalid username or password"); return "index";
	 * } }
	 */

	/*
	 * @RequestMapping(value="uploadFile",method=RequestMethod.POST) public void
	 * upload(@RequestParam("file")MultipartFile file) {
	 * System.out.println(file.getOriginalFilename()); }
	 */
}
