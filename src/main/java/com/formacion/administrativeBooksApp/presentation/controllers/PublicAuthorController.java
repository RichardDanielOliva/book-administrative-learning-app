package com.formacion.administrativeBooksApp.presentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/publicAuthors")
public class PublicAuthorController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "public/authors/authorsIndex";
	}
	
}
