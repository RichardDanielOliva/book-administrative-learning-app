package com.formacion.administrativeBooksApp.presentation.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.administrativeBooksApp.presentation.api.resourcesDtos.AuthorResource;
import com.formacion.administrativeBooksApp.presentation.api.services.AuthorRestServices;
import com.formacion.administrativeBooksApp.presentation.httpExceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/publicBook/api")
public class PublicAuthorRestController {
	
	@Autowired
	AuthorRestServices authorService;
	
	@GetMapping("/authors")
	public List<AuthorResource> findAll(){
		return authorService.findAll();
	}
	
	@GetMapping("/authors/{id}")
	public ResponseEntity<AuthorResource> readAuthor(@PathVariable("id") int idAuthor) 
			throws ResourceNotFoundException{
		
		return new ResponseEntity<AuthorResource>(authorService.findById(idAuthor), HttpStatus.OK); 
	}

	
}
