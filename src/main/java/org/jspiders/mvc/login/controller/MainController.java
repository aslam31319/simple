package org.jspiders.mvc.login.controller;

import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.services.LoginService;
import org.jspiders.mvc.login.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@Autowired
	private LoginService logService;
	@Autowired
	private RegisterService regService;

	// Home page response
	@RequestMapping("/")
	public String home() {
		return "index";
	}

	// Registration response
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@ModelAttribute UserDTO dto, Model model) {

		if (regService.register(dto)) {
			model.addAttribute("result", "Registration Successful");
			return "index";
		} else {
			model.addAttribute("result", "User already exist.... Registration Faild");
			return "index";
		}

	}

	// Login response
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		UserDTO validDto = logService.login(email, password);

		if (validDto.getPassword() == null) {
			model.addAttribute("result", "Invalid username or password");
			return "index";
		} else if (validDto.getPassword().equals(password)) {
			model.addAttribute("result", "Welcome " + validDto.getFirstName() + " " + validDto.getLastName());
			return "home";
		} else {
			model.addAttribute("result", "Invalid username or password");
			return "index";
		}
	}

	// trying rest api

	/*
	 * @RequestMapping(value="api/{user_id}",method=RequestMethod.GET)
	 * 
	 * @ResponseBody public UserDTO getUser(@PathVariable("user_id") int id) {
	 * return new UserDTO(); }
	 */
}
