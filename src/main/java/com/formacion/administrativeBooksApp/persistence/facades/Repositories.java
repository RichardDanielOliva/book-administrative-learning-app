package com.formacion.administrativeBooksApp.persistence.facades;

import java.util.List;

import com.formacion.administrativeBooksApp.persistence.entities.Book;
import com.formacion.administrativeBooksApp.persistence.repositories.AuthorRepository;
import com.formacion.administrativeBooksApp.persistence.repositories.BookRepository;
import com.formacion.administrativeBooksApp.persistence.repositories.CategoryRepository;
import com.formacion.administrativeBooksApp.presentation.dtos.BookForm;
import com.formacion.administrativeBooksApp.presentation.dtos.BookSearch;

public interface Repositories {
	List<Integer> getAuthorsIdsByNameAndLastName(BookForm book);
	void insertAuthorFromBookForm(List <String> names, List <String> lastNames);
	List<Book> getBookByDate(BookSearch bookSearch);
	
	BookRepository getBooks();
	void setBooks(BookRepository books);
	CategoryRepository getCategories();
	void setCategories(CategoryRepository categories);
	AuthorRepository getAuthors();
	void setAuthors(AuthorRepository authors);
}
