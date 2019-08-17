package com.formacion.administrativeBooksApp.presentation.api.services;

import java.util.List;

import javax.validation.Valid;

import com.formacion.administrativeBooksApp.persistence.entities.Book;
import com.formacion.administrativeBooksApp.presentation.api.resourcesDtos.AuthorResource;
import com.formacion.administrativeBooksApp.presentation.api.resourcesDtos.BookResource;
import com.formacion.administrativeBooksApp.presentation.dtos.BookBean;
import com.formacion.administrativeBooksApp.presentation.dtos.BookForm;
import com.formacion.administrativeBooksApp.presentation.httpExceptions.ResourceNotFoundException;

public interface AuthorRestServices {

	List<AuthorResource> findAll();

	AuthorResource findById(int searchBookId) throws ResourceNotFoundException;

}
