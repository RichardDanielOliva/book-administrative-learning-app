package com.formacion.administrativeBooksApp.presentation.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.formacion.administrativeBooksApp.persistence.entities.Author;
import com.formacion.administrativeBooksApp.persistence.repositories.AuthorRepository;

@Controller
public class HomeController {	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		return new ModelAndView("public/home");
	}
}
