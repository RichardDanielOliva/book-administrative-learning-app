package com.formacion.administrativeBooksApp.business.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.administrativeBooksApp.business.api.resourceAssemblerSupports.BookResourceAssembler;
import com.formacion.administrativeBooksApp.business.facades.BookUtilities;
import com.formacion.administrativeBooksApp.persistence.facades.Repositories;
import com.formacion.administrativeBooksApp.presentation.api.resourcesDtos.BookResource;
import com.formacion.administrativeBooksApp.presentation.api.services.BookRestServices;
import com.formacion.administrativeBooksApp.presentation.dtos.BookBean;
import com.formacion.administrativeBooksApp.presentation.dtos.BookForm;
import com.formacion.administrativeBooksApp.presentation.httpExceptions.ResourceNotFoundException;


@Service
public class BookRestServiceImpl implements BookRestServices{
	@Autowired
	Repositories repositories;
	@Autowired
	BookResourceAssembler bookResourceAssembler; 
	@Autowired
	BookUtilities bookUtilies; 
	
	@Override
	@Transactional(readOnly=true)
	public List<BookResource> findAll() {
		return repositories.getBooks().findAll()
				.stream()
				.map(bookResourceAssembler :: toResource)
				.collect(Collectors.toCollection(() -> new ArrayList<BookResource>()));
	}
	
	@Override
	public BookResource findById (int searchBookId) throws ResourceNotFoundException{		
			return repositories.getBooks().findById(searchBookId)
					.map(bookResourceAssembler :: toResource)
					.orElseThrow(() -> new ResourceNotFoundException("Book not found for this id: " + searchBookId));
	}
	
	@Override
	@Transactional
	public BookForm insert(BookForm book){
		System.out.println("2" + book.getId());
		repositories.getBooks().save(bookUtilies.convertBookDtoFormToEntityRest(book));
		return book;
	}
	
	@Override
	@Transactional
	public void update(BookForm book, int bookId) throws  ResourceNotFoundException{
		if(repositories.getBooks().existsById(book.getId())) {
			insert(book);
		} else if (repositories.getBooks().existsById(bookId)){
			book.setId(bookId);
			insert(book);
		} else
			throw new ResourceNotFoundException("Book not found for this id: " + bookId);
	}
	
	@Override
	@Transactional
	public void delete(int searchBookId) throws ResourceNotFoundException{		
		if(repositories.getBooks().existsById(searchBookId)) 
			repositories.getBooks().deleteById(searchBookId);
		else 
			throw new ResourceNotFoundException("Book not found for this id: " + searchBookId);
	}
}
