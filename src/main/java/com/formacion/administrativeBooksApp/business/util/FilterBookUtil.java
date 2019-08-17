package com.formacion.administrativeBooksApp.business.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.formacion.administrativeBooksApp.persistence.entities.Book;
import com.formacion.administrativeBooksApp.persistence.entities.enums.Language;
import com.formacion.administrativeBooksApp.persistence.repositories.BookRepository;
import com.formacion.administrativeBooksApp.presentation.dtos.BookBean;
import com.formacion.administrativeBooksApp.presentation.dtos.BookSearch;

@Component
public class FilterBookUtil {
	private BookSearch bookFilterModel;
	
	public List<Book> filterBookByDate(BookSearch bookSearch, BookRepository bookRepository) {
		List<Book> resultBookByDate = null;
		Date dateToFind = bookSearch.getPublicationDate();
		int dateControlBeforeAfter = bookSearch.getPublicationDateBeforeAfter();
		
		if(bookSearch.getPublicationDate() == null) 
			resultBookByDate = bookRepository.findAll();
		else {
			switch (dateControlBeforeAfter) {
				case -1: resultBookByDate = bookRepository.findByPublicationDateBefore(dateToFind);
					break;
				case 0: resultBookByDate = bookRepository.findByPublicationDate(dateToFind);
					break;
				case 1: resultBookByDate = bookRepository.findByPublicationDateAfter(dateToFind);
					break;
			}
		}	
		
		return resultBookByDate;
	}
	
	public List<BookBean> filterBookByAttributes(List<BookBean> bookstoFilter, BookSearch bookSearch) {
		List<BookBean> booksfilterResult = new ArrayList<BookBean>();
		
		for (BookBean book : bookstoFilter) 
			if( 
				filterBookByTitle(bookSearch.getTitle(), book.getTitle()) &&
				filterBookByNameOrLastname(bookSearch.getAuthor(), book.getFullNameAuthors()) &&
				filterBookByISBN(bookSearch.getISBN13(),book.getISBN13()) &&
				filterBookByLanguage(bookSearch.getSearchLanguages(), book.getTranslateLanguage()) &&
				filterBookByCategoryOrRating(bookSearch.getCategoriesId(), book.getCategoriesId()) 
					) booksfilterResult.add(book);
		
		return booksfilterResult;
	}
	
	public Boolean filterBooksByAttributes(BookBean book) {
		return 	filterBookByTitle(bookFilterModel.getTitle(), book.getTitle()) &&
				filterBookByNameOrLastname(bookFilterModel.getAuthor(), book.getFullNameAuthors()) &&
				filterBookByISBN(bookFilterModel.getISBN13(),book.getISBN13()) &&
				filterBookByLanguage(bookFilterModel.getSearchLanguages(), book.getTranslateLanguage()) &&
				filterBookByCategoryOrRating(bookFilterModel.getCategoriesId(), book.getCategoriesId()) 
			;
	}
	
	private Boolean filterBookByTitle(String searchTitle, String title) {
		return searchTitle.isEmpty() || searchTitle.toLowerCase().indexOf(title.toLowerCase())> -1 ;
	}
	
	private Boolean filterBookByNameOrLastname(String searchAttribute, List <String> listAttribute ) {
		Boolean resultSearchBook = false;
		
		if (searchAttribute.isEmpty()) resultSearchBook = true;
		else 
			for (String attribute : listAttribute) 
				if (attribute.toLowerCase().indexOf(searchAttribute.toLowerCase())>-1) 
					resultSearchBook = true;

		return resultSearchBook;
	}
	
	private Boolean filterBookByISBN(Long searchISBN, Long ISBN) {
		return searchISBN == 0 || Long.toString(ISBN).indexOf(Long.toString(searchISBN)) > -1 ;
	}
	
	private Boolean filterBookByLanguage(List<String> selectedLanguage, Language bookLanguage) {
		Boolean resultSearchBook = false;
		
		if (selectedLanguage.isEmpty()||bookLanguage==null) 
			resultSearchBook = true;
		else 
			for (String selectedAttribute : selectedLanguage) 
				if (selectedAttribute.equals(bookLanguage.toString())) 
					resultSearchBook = true;

		return resultSearchBook;
	}
	
	private Boolean filterBookByCategoryOrRating(List<Integer> selectedAttribute, List<Integer> bookAttribute) {
		Boolean resultSearchBook = false;
		if (selectedAttribute.isEmpty()) resultSearchBook = true;
		else 
			for (Integer selAttribute : selectedAttribute) 
				for (Integer bkAttribute : bookAttribute) 
					if (selAttribute.toString().indexOf(bkAttribute.toString())>-1) resultSearchBook = true;

		return resultSearchBook;
	}

	public BookSearch getBookFilterModel() {
		return bookFilterModel;
	}

	public void setBookFilterModel(BookSearch bookFilterModel) {
		this.bookFilterModel = bookFilterModel;
	}
}
