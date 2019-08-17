package com.formacion.administrativeBooksApp.business.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Component;

import com.formacion.administrativeBooksApp.persistence.entities.Author;
import com.formacion.administrativeBooksApp.persistence.entities.Book;
import com.formacion.administrativeBooksApp.persistence.entities.Category;
import com.formacion.administrativeBooksApp.presentation.dtos.BookBean;
import com.formacion.administrativeBooksApp.presentation.dtos.BookForm;

@Component
public class ConvertBookUtil extends ModelMapper {
	
	
	public List<BookBean> booksEntitiesToDtosBeans(List<Book> books) {
		List<BookBean> resultBooksBean = new ArrayList<BookBean>();
		try{
			for (Book book : books) {				
				BookBean newBook = bookEntityToDtoBean(book);
				resultBooksBean.add(newBook);
			}
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		return resultBooksBean;
	}
	
	
	public BookBean bookEntityToDtoBean(Book book) {
		BookBean resultBook = map(book, BookBean.class);
		resultBook = authorBookProperties(resultBook, book.getAuthors());
		resultBook = categoriesBookProperties(resultBook, book.getCategories());
		resultBook.setPublicationLanguage(book.getPublicationLanguage());
		return resultBook;
	}
	
	private BookBean authorBookProperties(BookBean resultBook, Set<Author> authors) {
		List<Integer> idAuthors = new ArrayList<Integer>();
		List<String> fullNameAuthors = new ArrayList<String>();
		  for (Author author : authors) {
			  idAuthors.add(author.getId());
			  fullNameAuthors.add(author.getName()+" " +author.getLastname());
		  }
		  resultBook.setIdAuthors(idAuthors);
		  resultBook.setFullNameAuthors(fullNameAuthors);
		return resultBook;
	}
	
	private BookBean categoriesBookProperties(BookBean resultBook, Set<Category> categories) {
		List<Integer> categoriesId = new ArrayList<Integer>();
		List<String> categoriesTitle = new ArrayList<String>();
		  for (Category category : categories) {
			  categoriesId.add(category.getId());
			  categoriesTitle.add(category.getTitle());
		  }
		  resultBook.setCategoriesId(categoriesId);
		  resultBook.setCategoriesTitle(categoriesTitle);
		return resultBook;
	}
	
	public Book bookDtoFormToEntity(BookForm book, List<Author> authors, List<Category> categories) {
		Book resultBook = map(book, Book.class);
		resultBook = convertFromAuthorIdBookProperties(resultBook, authors, book.getAuthorsId());
		resultBook = convertFromCategoriesIdBookProperties(resultBook, categories, book.getCategoriesId());
		return resultBook;
	}
	
	public Book bookDtoFormToEntity(BookForm book) {
		Book resultBook = map(book, Book.class);
		return resultBook;
	}
	
	public BookForm bookEntityToDtoForm(Book book) {
		return map(book, BookForm.class);
	}
	
	private Book convertFromCategoriesIdBookProperties(Book resultBook, List<Category> collectionCategories, List<Integer> categoriesId) {
		Set<Category> bookCategories = new HashSet<Category>();
		for (Category category : collectionCategories) {
			if(integerInAList(category.getId(), categoriesId)) 
				bookCategories.add(category);
		  }
		resultBook.setCategories(bookCategories);
		return resultBook;
	}
	
	private Book convertFromAuthorIdBookProperties(Book resultBook, List<Author> collectionAuthors, List<Integer> authorsId) {
		Set<Author> bookAuthors = new HashSet<Author>();
		for (Author author : collectionAuthors) {
			if(integerInAList(author.getId(), authorsId)) 
				bookAuthors.add(author);
		  }
		resultBook.setAuthors(bookAuthors);
		return resultBook;
	}

	private boolean integerInAList(int integer, List<Integer> integers) {
		boolean result = false;
		
		for (Integer integerList : integers) {
			if(integerList==integer) result = true;
		}
		return result;
	}
	
}
