package com.formacion.administrativeBooksApp.presentation.api.services;

import java.util.List;

import javax.validation.Valid;

import com.formacion.administrativeBooksApp.persistence.entities.Book;
import com.formacion.administrativeBooksApp.presentation.api.resourcesDtos.BookResource;
import com.formacion.administrativeBooksApp.presentation.dtos.BookBean;
import com.formacion.administrativeBooksApp.presentation.dtos.BookForm;
import com.formacion.administrativeBooksApp.presentation.httpExceptions.ResourceNotFoundException;

public interface BookRestServices {
	BookResource findById(int idBook) throws ResourceNotFoundException;
	
	BookForm insert(BookForm book);

	List<BookResource> findAll();

	void delete(int idBook) throws ResourceNotFoundException;

	void update(BookForm book, int bookId) throws ResourceNotFoundException;
}
