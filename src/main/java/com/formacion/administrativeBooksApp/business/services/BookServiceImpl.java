package com.formacion.administrativeBooksApp.business.services;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.formacion.administrativeBooksApp.business.facades.BookUtilities;

import com.formacion.administrativeBooksApp.persistence.facades.Repositories;


import com.formacion.administrativeBooksApp.presentation.dtos.AuthorBean;
import com.formacion.administrativeBooksApp.presentation.dtos.BookBean;
import com.formacion.administrativeBooksApp.presentation.dtos.BookForm;
import com.formacion.administrativeBooksApp.presentation.dtos.BookSearch;
import com.formacion.administrativeBooksApp.presentation.dtos.CategoryBean;
import com.formacion.administrativeBooksApp.presentation.services.BookServices;
import com.formacion.administrativeBooksApp.persistence.entities.enums.Language;

@Service
public class BookServiceImpl implements BookServices {
	@Autowired
	Repositories repositories;
	@Autowired
	BookUtilities bookUtilies; 
	
	@Override
	@Cacheable(value="booksBean")
	@Transactional(readOnly=true)
	public BookBean findById(int searchBookId) {		
			return repositories.getBooks().findById(searchBookId)
					.map(bookUtilies.getConvert() :: bookEntityToDtoBean)
					.orElseGet(() -> new BookBean());
	}
	
	@Override
	@Cacheable(value="booksBean")
	@Transactional(readOnly=true)
	public List<BookBean> findAll() {
		return repositories.getBooks().findAll()
				.stream()
				.map(bookUtilies.getConvert() :: bookEntityToDtoBean)
				.collect(Collectors.toCollection(() -> new ArrayList<BookBean>()));
	}
	
	@Override
	@Cacheable(value="booksBean")
	@Transactional(readOnly=true)
	public Page<BookBean> findAll(Pageable page) {
		return repositories.getBooks().findAll(page)
				.map(bookUtilies.getConvert() :: bookEntityToDtoBean);
	}
	
	@Override
	@CacheEvict(value = "booksBean", allEntries=true)
	@Transactional(readOnly=true)
	public List<BookBean> findAllByBookModel(BookSearch bookSearch) {
		bookUtilies.getFilter().setBookFilterModel(bookSearch);

		return  repositories.getBookByDate(bookSearch)
				.stream()  
				.map(bookUtilies.getConvert() :: bookEntityToDtoBean) 
				.filter(bookUtilies.getFilter() :: filterBooksByAttributes)
				.collect(Collectors.toCollection(() -> new ArrayList<BookBean>()));
	}
	
	@Override
	@Cacheable(value="booksForm", key = "#searchBookId")
	@Transactional(readOnly=true)
	public BookForm findByIdToUpdate(int searchBookId) {
			return repositories.getBooks().findById(searchBookId)
					.map(bookUtilies.getConvert() :: bookEntityToDtoForm)
					.orElseGet(() -> new BookForm());
	}
	
	
	@Override
	@Caching(evict = { 
				@CacheEvict(value = "booksBean", allEntries=true),
				@CacheEvict(value = "booksFormAuthors", allEntries=true, condition="#book.getNewAuthorsName().size()>0")}
			)
	@Transactional
	public void insert(BookForm book) {
		repositories.getBooks().save(bookUtilies.convertBookDtoFormToEntity(book));
	}
	
	@Override
	@Caching(evict = { 
				@CacheEvict(value = "booksBean", allEntries=true),
				@CacheEvict(value = "booksForm", key = "#book.id"),
				@CacheEvict(value = "booksFormAuthors", allEntries=true, condition="#book.getNewAuthorsName().size()>0")}
		)
	@Transactional
	public void update(BookForm book) {
		if(repositories.getBooks().existsById(book.getId())) {
			insert(book);
		}
	}

	@Override
	@Caching(evict = { 
			  @CacheEvict(value = "booksBean", allEntries=true),
			  @CacheEvict(value = "booksForm", key = "#searchBookId")})
	@Transactional
	public void delete(int searchBookId) {		
		if(repositories.getBooks().existsById(searchBookId)) {
			repositories.getBooks().deleteById(searchBookId);
		} 
	}

	@Override
	@Cacheable(value="booksFormCategories")
	@Transactional(readOnly=true)
	public List<CategoryBean> getBookCategories() {
		return repositories.getCategories().findAll()
				.stream()
				.map(bookUtilies.getConvertCategories() :: categoriesEntityToDtoBean)
				.collect(Collectors.toCollection(() -> new ArrayList<CategoryBean>()));
	}
	
	@Override
	@Cacheable(value="booksFormAuthors")
	@Transactional(readOnly=true)
	public List<AuthorBean> getAuthors() {
		return repositories.getAuthors().findAll()
				.stream()
				.map(bookUtilies.getConvertAuthors() :: authorEntityToDtoBean)
				.collect(Collectors.toCollection(() -> new ArrayList<AuthorBean>()));
				//.collect(Collectors.toList());
	}

	@Override
	public List<Language> getBookLanguague() {
		return Arrays.asList(Language.values());
	}

	@Override
	public String saveImage(MultipartFile multiPart, HttpServletRequest request) {
		return bookUtilies.getImageUtil().saveImage(multiPart, request);
	}
}

