package com.formacion.administrativeBooksApp.business.util;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.formacion.administrativeBooksApp.persistence.entities.Author;
import com.formacion.administrativeBooksApp.presentation.dtos.AuthorBean;


@Component
public class ConvertAuthorUtil extends ModelMapper {
	public List<AuthorBean> authorsEntitiesToDtoBean(List<Author> authors){
		List<AuthorBean> authorsBean = new ArrayList<AuthorBean>();
		for (Author author : authors) {				
			AuthorBean newAuthorBean = map(author, AuthorBean.class);
			authorsBean.add(newAuthorBean);
		}
		return authorsBean;
	}
	
	public AuthorBean authorEntityToDtoBean(Author author){
		return map(author, AuthorBean.class);
	}
}
