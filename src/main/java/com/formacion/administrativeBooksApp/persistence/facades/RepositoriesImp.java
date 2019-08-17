package com.formacion.administrativeBooksApp.persistence.facades;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.formacion.administrativeBooksApp.persistence.entities.Author;
import com.formacion.administrativeBooksApp.persistence.entities.Book;
import com.formacion.administrativeBooksApp.persistence.repositories.AuthorRepository;
import com.formacion.administrativeBooksApp.persistence.repositories.BookRepository;
import com.formacion.administrativeBooksApp.persistence.repositories.CategoryRepository;
import com.formacion.administrativeBooksApp.presentation.dtos.BookForm;
import com.formacion.administrativeBooksApp.presentation.dtos.BookSearch;
import com.formacion.administrativeBooksApp.presentation.services.AuthorServices;

@Service
public class RepositoriesImp implements Repositories{
	@Autowired  
	BookRepository books;
	@Autowired
	CategoryRepository categories;
	@Autowired
	AuthorRepository authors;
	
	@Override
	public List<Integer> getAuthorsIdsByNameAndLastName(BookForm book){
		return getIdOfNewAuthor(book.getNewAuthorsName().iterator(), book.getNewAuthorsLastName().iterator(), book.getAuthorsId());
	}
	
	private List<Integer> getIdOfNewAuthor(Iterator iteratorNames, Iterator iteratorLastNames, List<Integer> authorsId) {
		while(iteratorNames.hasNext()) {
			Optional<Author> author = authors.findByNameAndLastname((String) iteratorNames.next(), (String) iteratorLastNames.next());
			if (author.isPresent()) 
				authorsId.add(author.get().getId());
	      }
		
		return authorsId;
	}; 
	
	@Override
	public List<Book> getBookByDate(BookSearch bookSearch) {
		List<Book> resultBookByDate = null;
		Date dateToFind = bookSearch.getPublicationDate();
		int dateControlBeforeAfter = bookSearch.getPublicationDateBeforeAfter();
		
		if(bookSearch.getPublicationDate() == null) 
			resultBookByDate = books.findAll();
		else {
			switch (dateControlBeforeAfter) {
				case -1: resultBookByDate = books.findByPublicationDateBefore(dateToFind);
					break;
				case 0: resultBookByDate = books.findByPublicationDate(dateToFind);
					break;
				case 1: resultBookByDate = books.findByPublicationDateAfter(dateToFind);
					break;
			}
		}	
		
		return resultBookByDate;
	}
	
	@Override
	public void insertAuthorFromBookForm(List <String> names, List <String> lastNames) {
		Iterator iteratorNames = names.iterator();
		Iterator iteratorLastNames = lastNames.iterator();
		
		while(iteratorNames.hasNext()) {
			String name=(String) iteratorNames.next();
			String lastname=(String) iteratorLastNames.next();
			Optional<Author> author = authors.findByNameAndLastname(name, lastname);
			if (!author.isPresent()) {
				Author newAuthor= new Author();
				newAuthor.setName(name);
				newAuthor.setLastname(lastname);
				System.out.println(newAuthor);
				authors.save(newAuthor);
			}
	      }
	}
	
	
	@Override
	public BookRepository getBooks() {
		return books;
	}
	@Override
	public void setBooks(BookRepository books) {
		this.books = books;
	}
	@Override
	public CategoryRepository getCategories() {
		return categories;
	}
	@Override
	public void setCategories(CategoryRepository categories) {
		this.categories = categories;
	}
	@Override
	public AuthorRepository getAuthors() {
		return authors;
	}
	@Override
	public void setAuthors(AuthorRepository authors) {
		this.authors = authors;
	}	
	

}
