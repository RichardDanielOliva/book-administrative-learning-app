package com.formacion.administrativeBooksApp.business.api.resourceAssemblerSupports;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

import com.formacion.administrativeBooksApp.persistence.entities.Author;
import com.formacion.administrativeBooksApp.persistence.entities.Book;
import com.formacion.administrativeBooksApp.presentation.api.controllers.PublicAuthorRestController;
import com.formacion.administrativeBooksApp.presentation.api.controllers.PublicBookRestController;
import com.formacion.administrativeBooksApp.presentation.api.resourcesDtos.AuthorResource;
import com.formacion.administrativeBooksApp.presentation.httpExceptions.ResourceNotFoundException;

@Component
public class AuthorResourceAssembler extends ResourceAssemblerSupport<Author, AuthorResource>{

	public AuthorResourceAssembler() {
		super(PublicAuthorRestController.class, AuthorResource.class);
	}

	@Override
	public AuthorResource toResource(Author author) {
		AuthorResource authorResource= new AuthorResource();
		
		mapAttributte(authorResource, author);
		addAuthorLinks(authorResource, author);	

		return authorResource;
	}
	
	private void mapAttributte(AuthorResource authorResource, Author author) {
		authorResource.setAuthorId(author.getId());
		authorResource.setName(author.getName());
		authorResource.setLastname(author.getLastname());
		authorResource.setBirthdate(author.getBirthdate());
		authorResource.setGender(author.getGender());
		authorResource.setNationality(author.getNationality());
		authorResource.setShortBiography(author.getShortBiography());
	}
	
	private void addAuthorLinks(AuthorResource authorResource, Author author){
		addSelfLink(authorResource, author);
		addBookLinks(authorResource, author);
	}
	
	private void addSelfLink(AuthorResource authorResource, Author author){
		try {
			authorResource.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(PublicAuthorRestController.class).readAuthor(author.getId())).withSelfRel());
		}
		catch(ResourceNotFoundException ex) {
			
		}
	}
	
	private void addBookLinks(AuthorResource authorResource, Author author){		
		if (author.getBooks().size() > 0) {
			for (Book book : author.getBooks()) {
				try {
					Link ordersLink = ControllerLinkBuilder
							.linkTo(ControllerLinkBuilder.methodOn(PublicBookRestController.class).readbook(book.getId()))
							.withRel("book");
				
					authorResource.add(ordersLink);
				}
				catch(ResourceNotFoundException ex) {	
				}
			}
		}
	}

}
