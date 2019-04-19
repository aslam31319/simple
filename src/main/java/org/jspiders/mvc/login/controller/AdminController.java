package org.jspiders.mvc.login.controller;

import org.jspiders.mvc.login.model.UserDTO;
import org.jspiders.mvc.login.services.admin.AddAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private AddAdmin addAdmin;
	
	@RequestMapping("/")
	public String home() {
		return "admin/home";
	}
	
	@RequestMapping(value="/addAdmin",method=RequestMethod.POST)
	public String addAdmin(@ModelAttribute UserDTO dto) {
		addAdmin.register(dto);
		return "admin/addAdmin";
	}
}
