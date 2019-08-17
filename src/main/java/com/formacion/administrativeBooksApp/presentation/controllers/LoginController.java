package com.formacion.administrativeBooksApp.presentation.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class LoginController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/formLogin", method = RequestMethod.GET)
	public ModelAndView loginForm() {
		return new ModelAndView("public/formLogin");
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest resquest) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		
		logoutHandler.logout(resquest, null, null);
		
		return new ModelAndView("redirect:/admin/formLogin");
	}
	
}
