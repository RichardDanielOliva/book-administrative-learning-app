package com.formacion.administrativeBooksApp.business.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacion.administrativeBooksApp.business.api.resourceAssemblerSupports.AuthorResourceAssembler;
import com.formacion.administrativeBooksApp.persistence.facades.Repositories;
import com.formacion.administrativeBooksApp.presentation.api.resourcesDtos.AuthorResource;
import com.formacion.administrativeBooksApp.presentation.api.services.AuthorRestServices;
import com.formacion.administrativeBooksApp.presentation.httpExceptions.ResourceNotFoundException;


@Service
public class AuthorRestServiceImpl implements AuthorRestServices{
	@Autowired
	Repositories repositories;
	
	@Autowired
	AuthorResourceAssembler authorResourceAssembler; 
	
	@Override
	@Transactional(readOnly=true)
	public List<AuthorResource> findAll() {
		return repositories.getAuthors().findAll()
				.stream()
				.map(authorResourceAssembler :: toResource)
				.collect(Collectors.toCollection(() -> new ArrayList<AuthorResource>()));
	}
	
	@Override
	public AuthorResource findById (int searchBookId) throws  ResourceNotFoundException{		
		return repositories.getAuthors().findById(searchBookId)
				.map(authorResourceAssembler :: toResource)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found for this id: " + searchBookId));
	}

}
