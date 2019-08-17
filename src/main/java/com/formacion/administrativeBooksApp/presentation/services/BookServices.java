package com.formacion.administrativeBooksApp.presentation.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.formacion.administrativeBooksApp.persistence.entities.enums.Language;
import com.formacion.administrativeBooksApp.presentation.dtos.AuthorBean;
import com.formacion.administrativeBooksApp.presentation.dtos.BookBean;
import com.formacion.administrativeBooksApp.presentation.dtos.BookForm;
import com.formacion.administrativeBooksApp.presentation.dtos.BookSearch;
import com.formacion.administrativeBooksApp.presentation.dtos.CategoryBean;

public interface BookServices {
	List<BookBean> findAll();
	Page<BookBean> findAll(Pageable page);
	
	List<BookBean> findAllByBookModel(BookSearch bookSearch);
	
	BookBean findById(int searchBookId);
	BookForm findByIdToUpdate(int searchBookId);
	
	void insert(BookForm book);
	void update(BookForm book);
	void delete(int findBookId);
	
	String saveImage(MultipartFile multiPart, HttpServletRequest request);
	
	List<CategoryBean> getBookCategories();
	List<Language> getBookLanguague();
	List<AuthorBean> getAuthors();

}
