package com.formacion.administrativeBooksApp.presentation.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.administrativeBooksApp.presentation.api.resourcesDtos.BookResource;
import com.formacion.administrativeBooksApp.presentation.api.services.BookRestServices;
import com.formacion.administrativeBooksApp.presentation.dtos.BookForm;
import com.formacion.administrativeBooksApp.presentation.httpExceptions.InvalidDataException;
import com.formacion.administrativeBooksApp.presentation.httpExceptions.ResourceNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Public Book Controller", description = "This is the Book Controller")
@CrossOrigin(origins= {"http://localhost:4200", "http://localhost:7070"})
@RestController
@RequestMapping("/publicBook/api")
public class PublicBookRestController {
	@Autowired
	BookRestServices booksServices;
	
	@ApiOperation(value = "This will get a list of books.", notes = "These are some notes about the Book API.")
	@GetMapping("/books")
	public ResponseEntity<List<BookResource>> findAll(){
		return new ResponseEntity<List<BookResource>>(booksServices.findAll(), HttpStatus.OK); 
	}
	
	@PostMapping(value = "/books")
	@ResponseStatus(HttpStatus.CREATED)
	public BookForm saveBook (@Valid @RequestBody BookForm book){
		return booksServices.insert(book); 
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<BookResource> readbook(@PathVariable("id") int idBook) 
			throws ResourceNotFoundException{
		
		return new ResponseEntity<BookResource>(booksServices.findById(idBook), HttpStatus.OK); 
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<BookForm> updateBook(@PathVariable(value = "id") @Min(1) int bookId,@Valid @RequestBody BookForm book, BindingResult result) 
			throws InvalidDataException, ResourceNotFoundException{
		
		if(result.hasErrors()) {
			throw new InvalidDataException("Field error in object 'book'");
		}
		
		booksServices.update(book, bookId);
		
		return new ResponseEntity<BookForm>(book, HttpStatus.ACCEPTED); 
	}
	
	
	
	@DeleteMapping("/books/{id}")
	public Map<String, Boolean> deleteBook(@PathVariable("id") @Min(1) int idBook) 
			throws ResourceNotFoundException{
		
		booksServices.delete(idBook);
		
		Map<String, Boolean> deleteResponse = new HashMap<>();
		deleteResponse.put("Book deleted", Boolean.TRUE);
		
		return deleteResponse;
	}
	
}
