package com.formacion.administrativeBooksApp.business.api.resourceAssemblerSupports;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

import com.formacion.administrativeBooksApp.persistence.entities.Author;
import com.formacion.administrativeBooksApp.persistence.entities.Book;
import com.formacion.administrativeBooksApp.presentation.api.controllers.PublicAuthorRestController;
import com.formacion.administrativeBooksApp.presentation.api.controllers.PublicBookRestController;
import com.formacion.administrativeBooksApp.presentation.api.resourcesDtos.BookResource;
import com.formacion.administrativeBooksApp.presentation.httpExceptions.ResourceNotFoundException;

@Component
public class BookResourceAssembler extends ResourceAssemblerSupport<Book, BookResource>{

	public BookResourceAssembler() {
		super(PublicBookRestController.class, BookResource.class);
	}

	@Override
	public BookResource toResource(Book book) {
		BookResource BookResource = new BookResource();
		
		mapAttributte(BookResource, book);
		addBookLinks(BookResource, book);	

		return BookResource;
	}
	
	private void mapAttributte(BookResource BookResource, Book book) {
		BookResource.setBookId(book.getId());
		BookResource.setTitle(book.getTitle());
		BookResource.setPublicationDate(book.getPublicationDate());
		BookResource.setISBN10(book.getISBN10());
		BookResource.setISBN13(book.getISBN13());
		BookResource.setNumPage(book.getNumPage());
		BookResource.setFormat(book.getFormat());
		BookResource.setPublicationLanguage(book.getPublicationLanguage());
		BookResource.setTranslateLanguage(book.getTranslateLanguage());
	}
	
	private void addBookLinks(BookResource BookResource, Book book){
		addSelfLink(BookResource);
		addAuthorLinks(BookResource, book);
	}
	
	private void addSelfLink(BookResource BookResource){
		try {
			BookResource.add(ControllerLinkBuilder
					.linkTo(ControllerLinkBuilder
					.methodOn(PublicBookRestController.class)
					.readbook(BookResource.getBookId()))
					.withSelfRel());
		}
		catch(ResourceNotFoundException ex) {
			
		}
	}
	
	private void addAuthorLinks(BookResource BookResource, Book book){		
		if (book.getAuthors().size() > 0) {
			for (Author author : book.getAuthors()) {
				try {
					Link authorLink = ControllerLinkBuilder
							.linkTo(ControllerLinkBuilder.methodOn(PublicAuthorRestController.class).readAuthor(author.getId()))
							.withRel("book");
				
					BookResource.add(authorLink);
				}
				catch(ResourceNotFoundException ex) {	
				}
			}
		}
	}

}
